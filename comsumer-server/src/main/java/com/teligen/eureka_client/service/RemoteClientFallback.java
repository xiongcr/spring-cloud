package com.cxytiandi.eureka_client.service;

import org.springframework.stereotype.Component;

@Component
public class RemoteClientFallback implements RemoteClient{
    @Override
    public String hello() {
        return "fail";
    }
}
