package com.template.common.exception.auth;

import com.template.common.constant.CommonConstants;
import com.template.common.exception.BaseException;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 2:19
 * Description:
 */
public class ClientTokenException extends BaseException {

    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }

}
