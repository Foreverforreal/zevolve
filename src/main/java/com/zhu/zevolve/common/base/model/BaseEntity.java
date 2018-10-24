package com.zhu.zevolve.common.base.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class BaseEntity {
    @Id
    @Column(name = "`id`")
    @KeySql(useGeneratedKeys = true)
    protected Integer id;

    @Column(name = "`create_time`")
    protected LocalDateTime createTime;

    @Column(name = "`update_time`")
    protected LocalDateTime updateTime;

    @Column(name = "`create_user_id`")
    protected Integer createUserId;

    @Column(name = "`update_user_id`")
    protected Integer updateUserId;

    @Column(name = "`del_flag`")
    protected Boolean delFlag;

    @Column(name = "`status`")
    protected Integer status;

    @Column(name = "`remark`")
    protected String remark;

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
