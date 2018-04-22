package com.template.auth.server.interceptor;

import com.template.auth.common.bean.IJWTInfo;
import com.template.auth.server.configuration.ClientConfiguration;
import com.template.auth.server.service.AuthClientService;
import com.template.auth.server.util.ClientTokenUtil;
import com.template.common.exception.auth.ClientForbiddenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 2:21
 * Description:
 */
@Slf4j
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ClientConfiguration clientConfiguration;
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private AuthClientService authClientService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String token = request.getHeader(clientConfiguration.getClientTokenHeader());
        log.info("client token = {}", token);
        IJWTInfo infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        List<String> allowedClient = authClientService.getAllowedClient(clientConfiguration.getClientId());
        for (String client : allowedClient) {
            if (client.equals(uniqueName)) {
                return super.preHandle(request, response, handler);
            }
        }
        log.info("client token is not Forbidden client code = {}", uniqueName);
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
