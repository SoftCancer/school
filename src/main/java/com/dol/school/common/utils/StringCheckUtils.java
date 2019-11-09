package com.dol.school.common.utils;

import com.dol.school.common.exceptions.CheckException;
import com.dol.school.common.result.MsgConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 字符串检查工具类
 * @author: YaoGuangXun
 * @date: 2019/6/23 16:45
 */
public class StringCheckUtils {


    /**
     * 条件检查
     *
     * @param condition 检查条件，如果为false则抛异常
     * @param errMsg    错误信息
     * @param args      参数列表
     */
    public static void check(boolean condition, String errMsg, Object... args) {
        if (!condition) {
            failDeal(errMsg, args);
        }
    }


    /**
     * 检查字符串是否为空
     * @Param str
     * @return 
     * @Author YaoGuangXun
     * @Date 16:52 2019/6/23
     **/
    public static boolean notBlack(String str){

        if (null == str || "".equals(str)){
            return true;
        }
        if (str.isEmpty()){
            return str.length() == 0;
        }
        return false;
    }

    /**
     * 判断字符串是否为空，为空进行空字符串处理。
     * @Param
     * @return 
     * @Author YaoGuangXun
     * @Date 17:02 2019/6/23
     **/
    public static void isBlack(String str,String errorMsg,Object... obj){
        // 字符串为空时，进行为空处理
        if (StringUtils.isBlank(str)){
            failDeal(errorMsg,obj);
        }
    }

    /**
     * 不能为empty
     *
     * @param str    待检查字符串
     * @param errMsg 错误信息
     * @param args   参数列表
     */
    public static void isEmpty(String str, String errMsg, Object... args) {
        if (str == null || str.isEmpty()) {
            failDeal(errMsg, args);
        }
    }

    /**
     * 不能为Null
     *
     * @param obj    待检查对象
     * @param errMsg 错误信息
     * @param args   参数列表
     */
    public static void notNull(Object obj, String errMsg, Object... args) {
        if (obj == null) {
            failDeal(errMsg, args);
        }
    }

    private static void failDeal(String errorMsg,Object... objs){
        StringBuilder sb = new StringBuilder();
        // 如果为null ，抛出错误异常
        if (objs == null || objs.length <= 0){
            throw  new CheckException(MsgConstant.CHECK_FAIL,errorMsg);
        }

        sb.append(errorMsg + ",");
        for (Object object:objs) {
            sb.append(object.toString() + "");
        }

        throw  new CheckException(MsgConstant.CHECK_FAIL,sb.toString());
    }





}
