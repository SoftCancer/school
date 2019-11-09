package com.dol.school.service.api;


import java.util.Map;

public interface IUserService extends IBaseService {

    Integer getCountByNameAndPwd(Map<String,Object> map);
}
