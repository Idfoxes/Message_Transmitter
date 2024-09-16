package com.Idfoxes.Adapter.feign;

import com.Idfoxes.Adapter.model.MsgB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-b", url = "http://localhost:8082")
public interface ServiceBClient {
    @PostMapping("/send")
    void sendMessage(@RequestBody MsgB msgB);
}