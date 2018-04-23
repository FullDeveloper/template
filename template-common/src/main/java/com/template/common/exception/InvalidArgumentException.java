package com.template.common.exception;

import com.template.common.constant.CommonConstants;

/**
 * Create By Project template
 *
 * @author zrb
 * @date 2018/4/23
 * description
 */
public class InvalidArgumentException extends BaseException {

    public InvalidArgumentException(String message) {
        super(message, CommonConstants.EX_ARGUMENT_INVALID_CODE);
    }
}
