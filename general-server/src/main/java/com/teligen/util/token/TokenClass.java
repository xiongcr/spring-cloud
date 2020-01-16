package com.teligen.util.token;

import lombok.Data;

/**
 * 为了方便token的存取，编写一个token类，用来存放token的字段信息
 */
@Data
public class TokenClass {
    private Long id;//用户id
    private String username;//用户登录名
    private String freshToken;//刷新过后的token，每次验证都要刷新一次token，防止过期
}
