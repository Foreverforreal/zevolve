package com.zhu.zevolve.core.service.serviceImpl;

import com.zhu.zevolve.core.mapper.SysUserMapper;
import com.zhu.zevolve.core.model.SysUser;
import com.zhu.zevolve.core.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @program: zevolve
* @description: ServiceImpl
* @author: zhu
* @create: 2018-10-24 13:08:25
**/

@Transactional
@Slf4j
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    protected BaseMapper getMapper() {
        return this.sysUserMapper;
    }
}
