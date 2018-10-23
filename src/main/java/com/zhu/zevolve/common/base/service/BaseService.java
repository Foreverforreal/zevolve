package com.zhu.zevolve.common.base.service;

import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.model.BaseEntity;

public interface BaseService<T extends BaseEntity> extends BaseMapper<T> {
    int delteLogic(T record);
    int delete(T record,boolean isLogic);
}

