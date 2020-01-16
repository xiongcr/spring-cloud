package com.cxytiandi.eureka_client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider-server",fallback = RemoteClientFallback.class)
public interface RemoteClient {
    @GetMapping("/provider/hello")
    String hello();
}
