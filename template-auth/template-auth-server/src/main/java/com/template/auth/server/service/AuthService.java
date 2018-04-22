package com.template.auth.server.service;

import com.template.auth.server.bean.JwtAuthenticationRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 1:38
 * Description:
 */
public interface AuthService {

    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;

    String refresh(String oldToken);

    void validate(String token) throws Exception;

    Boolean invalid(String token);

}
