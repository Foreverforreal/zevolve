package com.zhu.zevolve.common.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ZStringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = { "talbleName", "TABLENAME", "tablename","table_name","tAble_Name" })
    void toUpperCamel(String params) {
        System.out.println(params + " --> "+ZStringUtils.toUpperCamel(params));
    }
}