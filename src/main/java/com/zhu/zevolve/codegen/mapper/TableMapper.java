package com.zhu.zevolve.codegen.mapper;

import com.zhu.zevolve.codegen.model.TableMeta;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TableMapper extends BaseMapper<TableMeta> {
}
