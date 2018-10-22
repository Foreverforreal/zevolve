package com.zhu.zevolve.common.base.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private Boolean del_flag;
    private Integer status;
    private String remark;
}
