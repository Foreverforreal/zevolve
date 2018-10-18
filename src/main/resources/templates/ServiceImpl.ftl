package ${package};

import ${tableClass.packageName}.mapper.${tableClass.shortClassName}Mapper;
import ${tableClass.packageName}.model.${tableClass.shortClassName};
import ${tableClass.packageName}.service.${tableClass.shortClassName}Service;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ${tableClass.shortClassName}ServiceImp extends BaseServiceImpl<TableMeta> implements ${tableClass.shortClassName}Service {
    @Autowired
    ${tableClass.shortClassName}Mapper ${tableClass.variableName}Mapper;

    @Override
    protected BaseMapper getMapper() {
        return this.tableMapper;
    }
}
