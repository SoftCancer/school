package com.dol.school.service.api;

/**
 * @description:
 * @author: YaoGuangXun
 * @date: 2019/6/2316:13
 */
import com.dol.school.common.result.MsgResult;



public interface ILoginService{

    /**
     * 登录验证
     * @param username
     * @return
     */
    MsgResult getByLoginName(String username, String pwd, String code);

    /**
     * 退出登录
     * @return
     */
    String outlogin();

}
