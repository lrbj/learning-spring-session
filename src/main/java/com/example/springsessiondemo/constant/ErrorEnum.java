package com.example.springsessiondemo.constant;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 4:38 PM 7/31/2019
 */
public enum ErrorEnum {
    LACKPARAMETER(50001, "参数缺失"),
    DATASTATUSERROR(50002, "数据已失效，刷新重试"),
    PARAS_ERROR(50003,"参数格式错误"),
    UPLOAD_ERROR(50004,"上传失败"),
    SERVER_ERROR(500, "服务器异常"),
    LOGIN_FAIL(40000, "帐号或者密码错误"),
    NO_LOGIN(40001, "用户未登录"),
    ACCOUNT_EXIST(40002, "账户已存在"),
    PARAMS_ERROR(40003, "参数错误"),
    PASSWORD_ERROR(40004, "用户名或密码错误"),
    USER_LOCKED(40005, "用户被禁用"),
    MENU_ERROR(40006, "菜单未初始化"),
    ACCOUNT_NOT_EXIST(400007, "用户不存在"),
    NOT_LOGIN(400008, "没有登录"),
    PERMISSION_NOT_EMPTY(400009, "无权限访问");
    private int code;

    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
