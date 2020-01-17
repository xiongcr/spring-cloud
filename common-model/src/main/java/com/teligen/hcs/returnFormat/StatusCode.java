package com.teligen.hcs.returnFormat;

public class StatusCode {
    public static final int SUCCESS=20000;//成功
    public static final int ERROR =20001;//失败
    public static final int LOGINERROR =20002;//登录错误
    public static final int USERNOTEXIST =20003;//用户不存在
    public static final int ACCESSERROR =20004;//权限不足
    public static final int REMOTEERROR =20005;//远程调用失败
    public static final int REPERROR =20006;//重复操作
}