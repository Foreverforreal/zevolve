package com.zhu.zevolve.core.mapper;

import com.zhu.zevolve.core.model.SysUser;
import com.zhu.zevolve.common.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @program: zevolve
* @description: Mapper
* @author: zhu
* @create: 2018-10-24 13:06:08
**/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
