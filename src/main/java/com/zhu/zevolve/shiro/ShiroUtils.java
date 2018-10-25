package com.zhu.zevolve.shiro;

import com.zhu.zevolve.core.model.SysUser;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {
    public static SysUser getCurrentUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
