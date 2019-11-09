package com.dol.school.controller;

import com.dol.school.service.api.IVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: YaoGuangXun
 * @date: 2019/6/29 17:47
 */
@RestController
@RequestMapping("/code")
public class VerificationController {

    @Autowired
    private IVerificationService verificationService;

    static {
        //防止二维码显示不了
        System.setProperty("java.awt.headless","true");
    }

    @RequestMapping(value = "/getVCode" ,method = RequestMethod.GET)
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
            verificationService.getVerificationCode(request,response);
    }


}
