package com.template.common.result.auth;

import com.template.common.constant.RestCodeConstants;
import com.template.common.result.BaseResponse;

/**
 * Author: zrb
 * Date: 2018/4/23
 * Time: 9:57
 * Description:
 */
public class TokenErrorResponse extends BaseResponse {

    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
