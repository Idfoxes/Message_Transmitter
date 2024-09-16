package com.Idfoxes.Adapter.feign;

import com.Idfoxes.Adapter.model.MsgA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-a", url = "http://localhost:8081")
public interface ServiceAClient {
    @GetMapping("/message")
    MsgA getMessage();
}