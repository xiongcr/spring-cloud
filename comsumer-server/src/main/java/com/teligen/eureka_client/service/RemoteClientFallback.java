package com.teligen.eureka_client.service;

import com.teligen.eureka_client.service.RemoteClient;
import org.springframework.stereotype.Component;

@Component
public class RemoteClientFallback implements RemoteClient {
    @Override
    public String hello() {
        return "fail";
    }
}
