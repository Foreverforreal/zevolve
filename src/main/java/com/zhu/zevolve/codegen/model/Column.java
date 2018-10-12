package com.zhu.zevolve.codegen.model;

import lombok.Data;

@Data
public class Column {
    private String columnName;
    private String dataType;// 列名类型
    private String comments;// 列名备注
    private String attrName;// 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrname;// 属性名称(第一个字母小写)，如：user_name => userName
    private String attrType;// 属性类型
    private String extra;// auto_increment
}
