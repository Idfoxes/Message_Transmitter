package com.Idfoxes.Service.B.controller;

import com.Idfoxes.Service.B.model.MsgB;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    @PostMapping("/send")
    public void receiveMessage(@RequestBody MsgB msgB) {
        System.out.println("Получено сообщение: " + msgB);
    }
}