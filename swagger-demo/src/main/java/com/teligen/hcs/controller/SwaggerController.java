package com.teligen.hcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class SwaggerController {

    @PostMapping("/1")
    @ApiOperation("添加用户的接口")
    public String addUser() {
        return "1";
    }

    @GetMapping("/2")
    @ApiOperation("根据id查询用户的接口")
    public String getUserById() {
        return "2";
    }

    @PutMapping("/3")
    @ApiOperation("根据id更新用户的接口")
    public String updateUserById() {
        return "3";
    }
}