package com.dol.school.dao.impl;

import com.dol.school.dao.api.IUserDao;

import java.util.List;
import java.util.Map;

public class UserDao extends BaseDao implements IUserDao {

    private IUserDao getInstance(){
        return getSqlSession().getMapper(IUserDao.class);
    }

    @Override
    public List<Map<String, Object>> getAll(Map<String, Object> map) {
        return getInstance().getAll(map);
    }

    @Override
    public Map<String, Object> getById(String id) {
        return getInstance().getById(id);
    }

    @Override
    public Integer add(Map<String, Object> map) {
        return getInstance().add(map);
    }

    @Override
    public Integer edit(Map<String, Object> map) {
        return getInstance().edit(map);
    }

    @Override
    public Integer delete(String id) {
        return getInstance().delete(id);
    }

    @Override
    public Integer getCountByNameAndPwd(Map<String, Object> map) {
        return getInstance().getCountByNameAndPwd(map);
    }

    @Override
    public Map getByLoginName(String username) {
        return getInstance().getByLoginName(username);
    }
}
