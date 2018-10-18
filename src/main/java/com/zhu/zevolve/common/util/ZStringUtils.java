package com.zhu.zevolve.common.util;

import com.google.common.base.CaseFormat;

public class ZStringUtils {
    private ZStringUtils(){}
    public static String toUpperCamel(String s){
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, s);
    }
}
