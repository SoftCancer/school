package com.dol.school.service.impl;

import com.dol.school.service.api.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService implements IUserService{


    @Override
    public Integer getCountByNameAndPwd(Map<String, Object> map) {
        return null;
    }

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
