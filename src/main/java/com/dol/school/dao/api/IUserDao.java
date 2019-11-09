package com.dol.school.dao.api;

import java.util.Map;

public interface IUserDao extends IBaseDao{

    Integer getCountByNameAndPwd(Map<String,Object> map);

    Map getByLoginName(String username);


}
