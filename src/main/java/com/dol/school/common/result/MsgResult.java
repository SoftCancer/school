package com.dol.school.common.result;

public class MsgResult {

    private String code= "0";

    private String msg;

    private Long count; //总条数

    private Object data;


    public MsgResult(Object data) {
        this.data = data;
    }

    public MsgResult(long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public MsgResult(String msg, String code, long count, Object data) {
        this.msg = msg;
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static MsgResult ok(Object data){
        return ok(MsgConstant.SUCCESS_COUNT,data);
    }

    public static MsgResult ok(long count , Object data){
        return new MsgResult(MsgConstant.SUCCESS_MSG,MsgConstant.SUCCESS_CODE,count,data);
    }

    public static MsgResult error(String errorMsg){
        return new MsgResult(errorMsg,MsgConstant.ERROR_CODE,0L,null);
    }

    public static MsgResult error(long count , Object data){
        return new MsgResult(MsgConstant.SUCCESS_MSG,MsgConstant.SUCCESS_CODE,count,data);
    }
}
