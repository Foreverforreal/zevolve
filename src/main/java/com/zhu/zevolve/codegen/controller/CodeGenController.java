package com.zhu.zevolve.codegen.controller;

import com.zhu.zevolve.codegen.util.CodeGenUtil;
import com.zhu.zevolve.common.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codegen/table/")
@Slf4j
public class CodeGenController {
    @Autowired
    CodeGenUtil codeGenUtil;

    @PostMapping("gen")
    public ResponseEntity<String> gen(String schema ,String tableName,String module,String genItem){
        try {
            codeGenUtil.gen(schema,tableName,module,genItem);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }
}

