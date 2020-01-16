package com.teligen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Eureka客户端示列
 */
//@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.teligen.dao")
public class YuanningApp {
	public static void main(String[] args) {
		SpringApplication.run(YuanningApp.class, args);
	}
}