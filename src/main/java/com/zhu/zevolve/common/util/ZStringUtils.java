package com.zhu.zevolve.common.util;

import com.google.common.base.CaseFormat;

public class ZStringUtils {
    private ZStringUtils(){}

    public static String toUpperCamel(String s){
        s = s.toLowerCase();
        if(s.contains("-")){
            return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, s);
        }
        if(s.contains("_")){
            return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, s);
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, s);
    }
}
