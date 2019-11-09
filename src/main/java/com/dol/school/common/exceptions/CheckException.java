package com.dol.school.common.exceptions;

/**
 * @description:
 * @author: YaoGuangXun
 * @date: 2019/6/23 17:31
 */
public class CheckException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    private String errorMsg;

    public CheckException(String code,String message){
        super(message);
        this.errorMsg=code;
    }


    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }






}
