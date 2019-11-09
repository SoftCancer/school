package com.dol.school.service.impl;

import com.dol.school.common.exceptions.CheckException;
import com.dol.school.common.result.MsgConstant;
import com.dol.school.common.result.MsgResult;
import com.dol.school.common.utils.StringCheckUtils;
import com.dol.school.dao.api.IUserDao;
import com.dol.school.service.api.ILoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YaoGuangXun
 * @date: 2019/6/23 16:13
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IUserDao userDao;

    @Override
    public MsgResult getByLoginName(String username, String pwd, String code) {

        if (StringUtils.isBlank(username)){
            throw new CheckException(MsgConstant.SYSTEM_FAIL,"用户名为空");
        }

       StringCheckUtils.isBlack(pwd,"密码为空！");
       StringCheckUtils.isBlack(code,"验证码为空！");

        Map map = userDao.getByLoginName(username);
        if (map.isEmpty()){
            return MsgResult.error("该用户不存在！");
        }

        String loginName = String.valueOf(map.get("loginName"));
        String password = String.valueOf(map.get("password"));
        if (!username.equals(loginName) || !pwd.equals(password)){
            return MsgResult.error("用户名或密码不正确！");
    }
        // 获取当前用户
//        Subject currentUser = SecurityUtils.getSubject();

        String id = String.valueOf(map.get("id"));
        Map resultMap = new HashMap();
        resultMap.put("userId",id);
        resultMap.put("username",loginName);

       return MsgResult.ok(resultMap);

    }

    @Override
    public String outlogin() {
        return null;
    }
}
