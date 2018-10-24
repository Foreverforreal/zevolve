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

    @PostMapping
    public ResponseEntity<Integer> add(${tableClass.shortClassName} ${tableClass.variableName}){
        try {
            int count = ${tableClass.variableName}Service.insert(${tableClass.variableName});
            if(count > 0){
                return ResponseEntity.build().createSuccess().body(count);
            }
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }

    @DeleteMapping("delete")
    public ResponseEntity delete(Integer id){
        ${tableClass.shortClassName} ${tableClass.variableName} = new ${tableClass.shortClassName}();
        ${tableClass.variableName}.setId(id);
        try {
            int count = ${tableClass.variableName}Service.delteLogic(${tableClass.variableName});
            if(count > 0){
                return ResponseEntity.build().createSuccess().body(count);
            }
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }

    @PutMapping
    public ResponseEntity update(${tableClass.shortClassName} ${tableClass.variableName}){
        try {
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<${tableClass.shortClassName}> get(@PathVariable Integer id){
        ${tableClass.shortClassName} ${tableClass.variableName} = ${tableClass.variableName}Service.selectByPrimaryKey(id);
        if(Objects.isNull(${tableClass.variableName})){
            return ResponseEntity.build().notFound();
        }
            return ResponseEntity.build().ok().body(${tableClass.variableName});
    }

    @GetMapping
    public ResponseEntity<${tableClass.shortClassName}> getPage(Integer pageNum,Integer pageSize,${tableClass.shortClassName} ${tableClass.variableName}){
        List<${tableClass.shortClassName}> ${tableClass.variableName}List = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            ${tableClass.variableName}List = ${tableClass.variableName}Service.select(${tableClass.variableName});
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        PageInfo page = new PageInfo(${tableClass.variableName}List);
        return ResponseEntity.build().ok().body(page);
    }

}
