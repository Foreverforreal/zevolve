package com.zhu.zevolve.codegen.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "tables",schema = "information_schema")
public class TableMeta {
    private String	tableCatalog;
    private String	tableSchema;
    @Id
    private String	tableName;
    private String	tableType;
    private String	engine;
    private long	version;
    private String	rowFormat;
    private long	tableRows;
    private long	avgRowLength;
    private long	dataLength;
    private long	maxDataLength;
    private long	indexLength;
    private long	dataFree;
    private long	autoIncrement;
    private LocalDateTime createTime;
    private LocalDateTime	updateTime;
    private LocalDateTime	checkTime;
    private String	tableCollation;
    private long	checksum;
    private String	createOptions;
    private String	tableComment;
}
