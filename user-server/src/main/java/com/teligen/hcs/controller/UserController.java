package com.teligen.hcs.controller;

import com.teligen.hcs.exception.MyException;
import com.teligen.hcs.model.User;
import com.teligen.hcs.returnFormat.StatusCode;
import com.teligen.hcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserController {

/*	@Value("${name}")
	public String name;*/

	@Autowired
	public UserService userService;

	@RequestMapping("/hello")
	public User getUser() {
		return userService.getUserById(1l);
	}

	@RequestMapping("/myexception")
	public String myException() {
		throw new MyException(StatusCode.ERROR,"测试自定义异常");
	}

	@RequestMapping("/globalexception")
	public String globalException() {
		int a=1/0;
		System.out.println(a);
		return "1";
	}

/*

	@GetMapping("/name")
	public String getName(){
		return name;
	}
*/


}
