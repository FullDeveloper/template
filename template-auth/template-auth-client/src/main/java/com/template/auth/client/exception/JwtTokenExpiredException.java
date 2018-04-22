package com.template.auth.client.exception;

/**
 * Create By Project Template
 *
 * @author zrb
 * @date 2018/4/15
 * description
 */
public class JwtTokenExpiredException extends Exception {

    public JwtTokenExpiredException(String s) {
        super(s);
    }

}
