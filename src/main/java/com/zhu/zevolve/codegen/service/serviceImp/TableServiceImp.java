package com.zhu.zevolve.codegen.service.serviceImp;

import com.zhu.zevolve.codegen.mapper.TableMapper;
import com.zhu.zevolve.codegen.model.Table;
import com.zhu.zevolve.codegen.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableServiceImp implements TableService {
    @Autowired
    TableMapper tableMapper;
    @Override
    public List<Table> getAllTable() {

        return tableMapper.getAllTable();
    }
}
