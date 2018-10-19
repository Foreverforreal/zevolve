package com.zhu.zevolve.codegen.service.serviceImpl;

import com.zhu.zevolve.codegen.mapper.TablesMapper;
import com.zhu.zevolve.codegen.model.Tables;
import com.zhu.zevolve.codegen.service.TablesService;
import lombok.extern.slf4j.Slf4j;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class TablesServiceImpl extends BaseServiceImpl<Tables> implements TablesService {
    @Autowired
    TablesMapper tablesMapper;

    @Override
    protected BaseMapper getMapper() {
        return this.tablesMapper;
    }
}
