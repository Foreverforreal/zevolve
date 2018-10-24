package com.zhu.zevolve.shiro;

import com.zhu.zevolve.core.model.SysUser;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {
    private SysUser getCurrentUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
