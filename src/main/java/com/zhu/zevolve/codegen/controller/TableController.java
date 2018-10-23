package com.zhu.zevolve.codegen.controller;

import com.zhu.zevolve.codegen.service.TablesService;
import com.zhu.zevolve.codegen.util.CodeGenUtil;
import com.zhu.zevolve.common.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codegen/table/")
@Slf4j
public class TableController {
    @Autowired
    TablesService tablesService;
    @Autowired
    CodeGenUtil codeGenUtil;

    @GetMapping("list")
    public ResponseEntity list(){
        return ResponseEntity.build().ok().body(tablesService.selectAll());
    }

    @PostMapping("gen")
    public ResponseEntity<String> gen(String schema ,String tableName,String module){
        try {
            codeGenUtil.gen(schema,tableName,module);
        } catch (Exception e) {
            return ResponseEntity.build().fail();
        }

        return ResponseEntity.build().ok();
    }
}
