package com.teligen.interceptor;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在程序启动后，第一时间执行的方法，可以做一些初始化操作
 */
@Component
//如果有多个runner需要指定一些顺序
@Order(1)
public class SimosApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("1");
        System.out.println(args.getOptionNames());
        System.out.println(args.getSourceArgs());
    }
}