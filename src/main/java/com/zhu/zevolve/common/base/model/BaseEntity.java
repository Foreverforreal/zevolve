package com.zhu.zevolve.common.base.model;

import com.zhu.zevolve.core.model.SysUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private Boolean delFlag;
    private Integer status;
    private String remark;

    protected void preSelect(){
        setDelFlag(false);
    }

    protected void preUpdate(SysUser user){
        setUpdateTime(LocalDateTime.now());
        setUpdateUserId(user.getId());
    }

    protected void preInsert(SysUser user){
        setCreateTime(LocalDateTime.now());
        setCreateUserId(user.getId());
    }
}
