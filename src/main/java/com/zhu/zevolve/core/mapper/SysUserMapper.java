package com.zhu.zevolve.core.mapper;

import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.core.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: zevolve
 * @description: Mapper
 * @author: zhu
 * @create: 2018-10-24 14:04:32
 **/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
