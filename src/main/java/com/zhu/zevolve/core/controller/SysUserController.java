package com.zhu.zevolve.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhu.zevolve.common.response.ResponseEntity;
import com.zhu.zevolve.core.model.SysUser;
import com.zhu.zevolve.core.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
* @program: zevolve
* @description: Controller
* @author: zhu
* @create: 2018-10-24 14:04:32
**/

@RestController
@Slf4j
@RequestMapping("/sys/user/")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @PostMapping
    public ResponseEntity<Integer> add(SysUser sysUser){
        try {
            String random=new SecureRandomNumberGenerator().nextBytes().toHex();
             //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
            String salt = new Md5Hash(sysUser.getPassword(),random,3).toString();
            sysUser.setSalt(salt);

            int count = sysUserService.insert(sysUser);
            if(count > 0){
                return ResponseEntity.build().createSuccess().body(count);
            }
        } catch (Exception e) {
            log.error("",e);
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }

    @DeleteMapping("delete")
    public ResponseEntity delete(Integer id){
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        try {
            int count = sysUserService.delteLogic(sysUser);
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
    public ResponseEntity update(SysUser sysUser){
        try {
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        return ResponseEntity.build().ok();
    }

    @GetMapping("{id}")
    public ResponseEntity<SysUser> get(@PathVariable Integer id){
        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        if(Objects.isNull(sysUser)){
            return ResponseEntity.build().notFound();
        }
        return ResponseEntity.build().ok().body(sysUser);
    }

    @GetMapping
    public ResponseEntity<SysUser> getPage(Integer pageNum,Integer pageSize,SysUser sysUser){
        List<SysUser> sysUserList = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            sysUserList = sysUserService.select(sysUser);
        } catch (Exception e) {
            log.error("{}",e);
            return ResponseEntity.build().error();
        }
        PageInfo page = new PageInfo(sysUserList);
        return ResponseEntity.build().ok().body(page);
    }

}
