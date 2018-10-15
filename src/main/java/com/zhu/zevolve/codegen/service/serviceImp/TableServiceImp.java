package com.zhu.zevolve.codegen.service.serviceImp;

import com.zhu.zevolve.codegen.mapper.TableMapper;
import com.zhu.zevolve.codegen.model.TableMeta;
import com.zhu.zevolve.codegen.service.TableService;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableServiceImp extends BaseServiceImpl<TableMeta> implements TableService {
    @Autowired
    TableMapper tableMapper;

    @Override
    protected BaseMapper getMapper() {
        return this.tableMapper;
    }
}
