package com.dol.school.dao.impl;

import com.dol.school.dao.api.IBaseDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class BaseDao extends SqlSessionDaoSupport implements IBaseDao {

    @Override
    public List<Map<String, Object>> getAll(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getById(String id) {
        return null;
    }

    @Override
    public Integer add(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer edit(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer delete(String id) {
        return null;
    }
}
