package com.zhu.zevolve.common.base.service.impl;

import com.zhu.zevolve.common.base.mapper.BaseMapper;
import com.zhu.zevolve.common.base.service.BaseService;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected abstract BaseMapper<T> getMapper();

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public List<T> select(T record) {
        return getMapper().select(record);
    }

    @Override
    public T selectOne(T record) {
        return getMapper().selectOne(record);
    }

    @Override
    public int insertList(List<? extends T> recordList) {
        return getMapper().insertList(recordList);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return getMapper().existsWithPrimaryKey(key);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        return getMapper().selectCount(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByCondition(Object condition) {
        return getMapper().deleteByCondition(condition);
    }

    @Override
    public List<T> selectByCondition(Object condition) {
        return getMapper().selectByCondition(condition);
    }

    @Override
    public int selectCountByCondition(Object condition) {
        return getMapper().selectCountByCondition(condition);
    }

    @Override
    public int updateByCondition(T record, Object condition) {
        return getMapper().updateByCondition(record,condition);
    }

    @Override
    public int updateByConditionSelective(T record, Object condition) {
        return getMapper().updateByConditionSelective(record,condition);
    }

    @Override
    public int deleteByExample(Object example) {
        return getMapper().deleteByExample(example);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return getMapper().selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return getMapper().selectOneByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return getMapper().updateByExample(record,example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example) {
        return getMapper().updateByExampleSelective(record,example);
    }

    @Override
    public int deleteByIds(String ids) {
        return getMapper().deleteByIds(ids);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return getMapper().selectByIds(ids);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return getMapper().selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return getMapper().selectByRowBounds(record,rowBounds);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        return getMapper().insertUseGeneratedKeys(record);
    }
}
