package com.zhu.zevolve.codegen.controller;

import com.zhu.zevolve.codegen.model.Table;
import com.zhu.zevolve.codegen.service.TableService;
import com.zhu.zevolve.common.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codegen/table/")
public class TableController {
    @Autowired
    TableService tableService;

    @GetMapping("list")
    public ResponseEntity<Table> list(){
        ResponseEntity response = new ResponseEntity();
        response.setData(tableService.getAllTable());
        return response;
    }
}
