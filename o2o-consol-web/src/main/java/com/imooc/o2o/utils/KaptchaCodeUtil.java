package com.imooc.o2o.utils;

import com.google.code.kaptcha.Constants;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class KaptchaCodeUtil {

    public static boolean checkKaptchaInCode(HttpServletRequest request) {
        String kaptChaSysCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String kaptChaInCode = request.getParameter("captCha_in");
        if (StringUtils.isEmpty(kaptChaInCode) || !kaptChaInCode.toUpperCase().equals(kaptChaSysCode.toUpperCase())) {
            return false;
        }
        return true;
    }
}
