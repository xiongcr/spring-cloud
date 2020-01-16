package com.teligen.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Eureka服务端示列
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
	}
}
