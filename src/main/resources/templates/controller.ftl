package ${package};

import ${modulePackage}.service.${tableClass.shortClassName}Service;
import com.zhu.zevolve.common.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @program: zevolve
* @description: Controller
* @author: zhu
* @create: ${dateTime?string["yyyy-MM-dd HH:mm:ss"]}
**/

@RestController
@Slf4j
@RequestMapping("")
public class ${tableClass.shortClassName}Controller {
    @Autowired
    ${tableClass.shortClassName}Service ${tableClass.variableName}Service;
}
