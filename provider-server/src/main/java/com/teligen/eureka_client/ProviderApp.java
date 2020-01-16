package com.teligen.eureka_client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Eureka客户端示列
 * 
 * @author yinjihuan
 * 
 * @about http://teligen.com/about
 * 
 * @date 2018-12-22
 * 
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.teligen.mybatis.mapper")
public class ProviderApp {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, args);
	}
}