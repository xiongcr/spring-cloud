package com.teligen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Eureka客户端示列
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
public class ProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, args);
	}
}