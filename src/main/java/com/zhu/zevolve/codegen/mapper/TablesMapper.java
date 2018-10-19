package com.zhu.zevolve.codegen.mapper;

import com.zhu.zevolve.codegen.model.Tables;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TablesMapper extends BaseMapper<Tables> {
}
