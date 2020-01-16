package com.teligen.eureka_client.controller;

import com.teligen.eureka_client.service.UserService;
import com.xcr.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
     @Autowired
	UserService userService;

	@GetMapping("/hello")
	public List<User> hello() {
		return userService.findAll();
	}

}
