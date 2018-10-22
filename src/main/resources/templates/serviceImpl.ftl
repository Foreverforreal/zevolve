package ${package};

import ${modulePackage}.mapper.${tableClass.shortClassName}Mapper;
import ${modulePackage}.model.${tableClass.shortClassName};
import ${modulePackage}.service.${tableClass.shortClassName}Service;
import lombok.extern.slf4j.Slf4j;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class ${tableClass.shortClassName}ServiceImpl extends BaseServiceImpl<${tableClass.shortClassName}> implements ${tableClass.shortClassName}Service {
    @Autowired
    ${tableClass.shortClassName}Mapper ${tableClass.variableName}Mapper;

    @Override
    protected BaseMapper getMapper() {
        return this.${tableClass.variableName}Mapper;
    }
}
