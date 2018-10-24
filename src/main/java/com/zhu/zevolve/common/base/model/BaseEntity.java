package com.zhu.zevolve.common.base.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Data
public class BaseEntity {
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`create_time`")
    private LocalDateTime createTime;

    @Column(name = "`update_time`")
    private LocalDateTime updateTime;

    @Column(name = "`create_user_id`")
    private Integer createUserId;

    @Column(name = "`update_user_id`")
    private Integer updateUserId;

    @Column(name = "`del_flag`")
    private Boolean delFlag;

    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`remark`")
    private String remark;

    protected void preSelect(){
        setDelFlag(false);
    }

//    protected void preUpdate(SysUser user){
//        setUpdateTime(LocalDateTime.now());
//        setUpdateUserId(user.getId());
//    }
//
//    protected void preInsert(SysUser user){
//        setCreateTime(LocalDateTime.now());
//        setCreateUserId(user.getId());
//    }
}
