package com.dol.school.service.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 获取验证码接口
 * @author: YaoGuangXun
 * @date: 2019/6/29 16:41
 */
public interface IVerificationService {

    void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
