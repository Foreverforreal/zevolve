package com.zhu.zevolve.core.controller;

import com.zhu.zevolve.common.response.ResponseEntity;
import com.zhu.zevolve.core.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Integer> login(@Valid SysUser sysUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> erroMessge = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());

            return ResponseEntity.build().body(erroMessge);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(),sysUser.getPassword());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.build().ok().msg("帐号或密码错误");
        }

        return ResponseEntity.build().ok();
    }

}
