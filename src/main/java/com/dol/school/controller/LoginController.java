package com.dol.school.controller;


import com.dol.school.common.result.MsgResult;
import com.dol.school.service.api.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static com.dol.school.common.utils.StringCheckUtils.check;


@RestController
@RequestMapping("login")
public class LoginController {


    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public MsgResult login(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        //验证验证码
        String vcode = String.valueOf(request.getSession().getAttribute("vcode"));
        check(code.equalsIgnoreCase(vcode), "验证码错误");
        MsgResult msgResult = loginService.getByLoginName(username, password, code);
        System.out.println("  成功返回："+msgResult);
        return msgResult;
    }
}
