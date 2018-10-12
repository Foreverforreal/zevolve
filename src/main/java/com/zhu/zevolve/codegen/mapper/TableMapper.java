package com.zhu.zevolve.codegen.mapper;

import com.zhu.zevolve.codegen.model.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableMapper {
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables " +
            "where table_schema = (select database())")
    List<Table> getAllTable();
}
