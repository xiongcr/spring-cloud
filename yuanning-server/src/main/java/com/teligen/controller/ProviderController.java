package com.teligen.controller;

import com.teligen.model.User;
import com.teligen.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

	@Value("${name}")
	public String name;

	@Autowired
	public ProviderService providerService;

	@GetMapping("/hello")
	public User getUser() {
		return providerService.getUser(1l);
	}

	@GetMapping("/name")
	public String getName(){
		return name;
	}


}
