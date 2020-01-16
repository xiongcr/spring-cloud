package com.teligen.controller;

import com.teligen.model.User;
import com.teligen.service.UserService;
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

	@GetMapping("/hello")
	public User getUser() {
		return userService.getUserById(1l);
	}
/*

	@GetMapping("/name")
	public String getName(){
		return name;
	}
*/


}
