package com.template.auth.server.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 1:38
 * Description:
 */
public interface AuthClientService {

    String apply(String clientId, String secret) throws Exception;
    /**
     * 获取授权的客户端列表
     * @param serviceId
     * @param secret
     * @return
     */
    List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 获取服务授权的客户端列表
     * @param serviceId
     * @return
     */
    List<String> getAllowedClient(String serviceId);

    void registryClient();

    void validate(String clientId, String secret) throws Exception;

}
