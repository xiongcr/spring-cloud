package com.teligen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Eureka客户端示列
 */
//@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
public class GeneralApp {
	public static void main(String[] args) {
		SpringApplication.run(GeneralApp.class, args);
	}
}