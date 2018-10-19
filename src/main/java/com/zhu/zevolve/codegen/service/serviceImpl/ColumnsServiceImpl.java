package com.zhu.zevolve.codegen.service.serviceImpl;

import com.zhu.zevolve.codegen.mapper.ColumnsMapper;
import com.zhu.zevolve.codegen.model.Columns;
import com.zhu.zevolve.codegen.service.ColumnsService;
import lombok.extern.slf4j.Slf4j;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class ColumnsServiceImpl extends BaseServiceImpl<Columns> implements ColumnsService {
    @Autowired
    ColumnsMapper columnsMapper;

    @Override
    protected BaseMapper getMapper() {
        return this.columnsMapper;
    }
}
