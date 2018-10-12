package com.zhu.zevolve.codegen.model;

import lombok.Data;

import java.util.List;

@Data
public class Table {
    private String tableName;//表的名称
    private String comments;//表的备注
    private Column pk;//表的主键
    private List<Column> columns;//表的列名(不包含主键)
    private String className;//类名(第一个字母大写)，如：sys_user => SysUser
    private String classname;//类名(第一个字母小写)，如：sys_user => sysUser
}
