package com.template.common.result.auth;

import com.template.common.constant.RestCodeConstants;
import com.template.common.result.BaseResponse;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/15
 * TIME: 下午11:58
 * description:
 */
public class TokenForbiddenResponse extends BaseResponse {

    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
