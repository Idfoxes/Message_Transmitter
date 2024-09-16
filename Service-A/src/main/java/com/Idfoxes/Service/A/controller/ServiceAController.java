package com.Idfoxes.Service.A.controller;

import com.Idfoxes.Service.A.model.MsgA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @GetMapping("/message")
    public MsgA getMessage() {
        MsgA msgA = new MsgA();
        msgA.setMsg("Привет");
        msgA.setLng("ru");
        msgA.setCoordinates(new MsgA.Coordinates("54.35", "52.52"));
        return msgA;
    }
}