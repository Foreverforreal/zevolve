package com.zhu.zevolve.codegen.controller;

import com.zhu.zevolve.codegen.service.ColumnsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("")
@RestController
public class ColumnsController {
    @Autowired
    ColumnsService columnsService;
}



