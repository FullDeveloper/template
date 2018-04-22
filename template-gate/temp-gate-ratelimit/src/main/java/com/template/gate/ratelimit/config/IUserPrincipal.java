package com.template.gate.ratelimit.config;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: zrb
 * Date: 2018/4/22
 * Time: 14:36
 * Description:
 */
public interface IUserPrincipal {

    String getName(HttpServletRequest request);

}
