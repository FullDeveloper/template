package com.template.gate.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.template.auth.client.config.ServiceAuthConfig;
import com.template.auth.client.config.UserAuthConfig;
import com.template.auth.client.jwt.ServiceAuthUtil;
import com.template.auth.client.jwt.UserAuthUtil;
import com.template.auth.common.bean.IJWTInfo;
import com.template.auth.common.bean.PermissionInfo;
import com.template.common.bean.LogInfo;
import com.template.common.constant.CommonConstants;
import com.template.common.context.BaseContextHandler;
import com.template.common.result.auth.TokenErrorResponse;
import com.template.common.result.auth.TokenForbiddenResponse;
import com.template.gate.zuul.feign.ILogService;
import com.template.gate.zuul.feign.IUserService;
import com.template.gate.zuul.util.DBLog;
import com.template.gate.zuul.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 14:25
 * Description:
 */
@Slf4j
@Component
public class ClientAccessFilter extends ZuulFilter {


    @Value("${zuul.prefix}")
    private String zuulPrefix;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthUtil serviceAuthUtil;

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private UserAuthUtil userAuthUtil;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ILogService iLogService;

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());

        final String method = request.getMethod();

        log.info("request uri => {}", requestUri);
        log.info("from remote client host => {}", RequestUtils.getRemoteHost(request));
        BaseContextHandler.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }
        IJWTInfo user = null;
        try {
            user = getJWTUser(request, ctx);
        } catch (Exception e) {
            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(e.getMessage())), 200);
            return null;
        }
        List<PermissionInfo> permissionIfs = iUserService.getAllPermissionInfo();
        // 判断资源是否启用权限约束
        // Stream<PermissionInfo> stream = getPermissionIfs(requestUri, method, permissionIfs);

        // List<PermissionInfo> result = stream.collect(Collectors.toList());
        // PermissionInfo[] permissions = result.toArray(new PermissionInfo[]{});
        PermissionInfo permissionInfo = getPermissionInfoByUri(requestUri, "", permissionIfs);
        /*if (permissions.length > 0) {
            setCurrentUserInfoAndLog(ctx,user,permissions[0]);
            // checkUserPermission(permissions, ctx, user);
        }*/
        if (permissionInfo != null) {
            try {
                setCurrentUserInfoAndLog(ctx, user, permissionInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 申请客户端密钥头
        ctx.addZuulRequestHeader(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken());
        return null;
    }

    private void checkUserPermission(PermissionInfo[] permissions, RequestContext ctx, IJWTInfo user) throws IOException {
        List<PermissionInfo> permissionInfoList = iUserService.getPermissionByUsername(user.getUniqueName());
        PermissionInfo current = null;
        for (PermissionInfo info : permissions) {
            boolean anyMatch = permissionInfoList.parallelStream().anyMatch(new Predicate<PermissionInfo>() {
                @Override
                public boolean test(PermissionInfo permissionInfo) {
                    return permissionInfo.getCode().equals(info.getCode());
                }
            });
            if (anyMatch) {
                current = info;
                break;
            }
        }
        if (current == null) {
            setFailedRequest(JSON.toJSONString(new TokenForbiddenResponse("Token Forbidden!")), 200);
        } else {
            if (!RequestMethod.GET.toString().equals(current.getMethod())) {
                setCurrentUserInfoAndLog(ctx, user, current);
            }
        }
    }

    private void setCurrentUserInfoAndLog(RequestContext ctx, IJWTInfo user, PermissionInfo pm) throws IOException {
        String host = RequestUtils.getRemoteHost(ctx.getRequest());
        ctx.addZuulRequestHeader("userId", user.getId());
        ctx.addZuulRequestHeader("userName", URLEncoder.encode(user.getName()));
        ctx.addZuulRequestHeader("userHost", host);
        String requestStr = RequestUtils.dumpRequest(ctx.getRequest());
        LogInfo logInfo = new LogInfo(
                pm.getName(),
                Long.parseLong(pm.getType()),
                pm.getUri(),
                requestStr,
                "",
                ctx.getRequest().getMethod(),
                null,
                "gateway",
                System.currentTimeMillis(),
                null,
                null,
                user.getId()

        );
        DBLog.getInstance().setLogService(iLogService);
        BaseContextHandler.set(CommonConstants.LOG_INFO_NAME, logInfo);
        // DBLog.getInstance().setLogService(iLogService).offerQueue(logInfo);
    }

    public PermissionInfo getPermissionInfoByUri(final String requestUri, final String method, List<PermissionInfo> serviceInfo) {
        for (PermissionInfo permissionInfo : serviceInfo) {
            if (requestUri.contains(permissionInfo.getUri())) {
                return permissionInfo;
            }
        }
        return null;
    }


    /**
     * 获取目标权限资源
     *
     * @param requestUri
     * @param method
     * @param serviceInfo
     * @return
     */
    private Stream<PermissionInfo> getPermissionIfs(final String requestUri, final String method, List<PermissionInfo> serviceInfo) {
        return serviceInfo.parallelStream().filter(new Predicate<PermissionInfo>() {
            @Override
            public boolean test(PermissionInfo permissionInfo) {
                String url = permissionInfo.getUri();
                String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                String regEx = "^" + uri + "$";
                return (Pattern.compile(regEx).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                        && method.equals(permissionInfo.getMethod());
            }
        });
    }

    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    /**
     * 返回session中的用户信息
     *
     * @param request
     * @param ctx
     * @return
     */
    private IJWTInfo getJWTUser(HttpServletRequest request, RequestContext ctx) throws Exception {
        String authToken = request.getHeader(userAuthConfig.getTokenHeader());
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        ctx.addZuulRequestHeader(userAuthConfig.getTokenHeader(), authToken);
        BaseContextHandler.setToken(authToken);
        return userAuthUtil.getInfoFromToken(authToken);
    }

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }
}
