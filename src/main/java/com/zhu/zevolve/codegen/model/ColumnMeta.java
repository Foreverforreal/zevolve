package com.zhu.zevolve.codegen.model;

import lombok.Data;

@Data
public class ColumnMeta {
    private String	tableCatalog;
    private String	tableSchema;
    private String	tableName;
    private String	columnName;
    private long	ordinalPosition;
    private String	columnDefault;
    private String	isNullable;
    private String	dataType;
    private long	characterMaximum_length;
    private long	characterOctet_length;
    private long	numericPrecision;
    private long	numericScale;
    private long	datetimePrecision;
    private String	characterSetName;
    private String	collationName;
    private String	columnType;
    private String	columnKey;
    private String	extra;
    private String	privileges;
    private String	columnComment;
    private String	generationExpression;

}
