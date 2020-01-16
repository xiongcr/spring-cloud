package com.teligen.eureka_client.controller;


import com.teligen.eureka_client.service.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comsumer")
public class ComsumerController {

	@Autowired
	private RemoteClient remoteClient;

	@GetMapping("/feign/hello")
	public String feignHello() {
		return remoteClient.hello();
	}
	
}
