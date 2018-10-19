package ${package};

import ${modulePackage}.model.${tableClass.shortClassName};
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ${tableClass.shortClassName}Mapper extends BaseMapper<${tableClass.shortClassName}> {
}