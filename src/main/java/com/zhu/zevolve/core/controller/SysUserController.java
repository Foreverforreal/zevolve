package com.zhu.zevolve.core.controller;

import com.zhu.zevolve.common.response.ResponseEntity;
import com.zhu.zevolve.core.model.SysUser;
import com.zhu.zevolve.core.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/sys/user/")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @PostMapping
    public ResponseEntity add(SysUser sysUser){
        try {
            int insert = sysUserService.insert(sysUser);
        } catch (Exception e) {
            log.error("{}",e);
        }
        return null;
    }
    @GetMapping("{id}")
    public ResponseEntity<SysUser> get(@PathVariable Integer id){
        return null;
    }

    @PutMapping
    public ResponseEntity update(SysUser sysUser){
        try {
            int insert = sysUserService.updateByPrimaryKey(sysUser);
        } catch (Exception e) {
            log.error("{}",e);
        }
        return null;
    }

    @DeleteMapping("delete")
    public ResponseEntity delete(Integer id){
        SysUser userInfo = new SysUser();
        userInfo.setId(id);

        sysUserService.delteLogic(userInfo);
        return null;
    }
}
