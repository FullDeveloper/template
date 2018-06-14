package com.template.common.util;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/6/3
 * TIME: 下午3:40
 * description:
 */
public class MD5Util {

    private static boolean checkSignMD5(JSONObject reqObj, String md5_key)
    {
        System.out.println("进入商户[" + reqObj.getString("oid_partner")
                + "]MD5签名验证");
        if (reqObj == null)
        {
            return false;
        }
        String sign = reqObj.getString("sign");
        // 生成待签名串
        String sign_src = genSignData(reqObj);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]待签名原串"
                + sign_src);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]签名串"
                + sign);
        sign_src += "&key=" + md5_key;
        try
        {
            if (sign.equals(Md5Algorithm.getInstance().md5Digest(
                    sign_src.getBytes("utf-8"))))
            {
                System.out.println("商户[" + reqObj.getString("oid_partner")
                        + "]MD5签名验证通过");
                return true;
            } else
            {
                System.out.println("商户[" + reqObj.getString("oid_partner")
                        + "]MD5签名验证未通过");
                return false;
            }
        } catch (UnsupportedEncodingException e)
        {
            System.out.println("商户[" + reqObj.getString("oid_partner")
                    + "]MD5签名验证异常" + e.getMessage());
            return false;
        }
    }

    public static String genSignData(JSONObject jsonObject)
    {
        StringBuffer content = new StringBuffer();

        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < keys.size(); i++)
        {
            String key = (String) keys.get(i);
            if ("sign".equals(key))
            {
                continue;
            }
            if ("PAY_URL".equals(key))
            {
                continue;
            }
            String value = jsonObject.getString(key);
            // 空串不参与签名
            if (isnull(value))
            {
                continue;
            }
            content.append((i == 0 ? "" : "&") + key + "=" + value);

        }
        String signSrc = content.toString();
        if (signSrc.startsWith("&"))
        {
            signSrc = signSrc.replaceFirst("&", "");
        }
        return signSrc;
    }

    /**
     * str空判断
     * @param str
     * @return
     * @author guoyx
     */
    public static boolean isnull(String str)
    {
        if (null == str || str.equalsIgnoreCase("null") || str.equals(""))
        {
            return true;
        } else
            return false;
    }
}
