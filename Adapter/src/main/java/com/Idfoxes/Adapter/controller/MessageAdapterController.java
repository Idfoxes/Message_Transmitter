package com.Idfoxes.Adapter.controller;

import com.Idfoxes.Adapter.service.MessageAdapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageAdapterController {

    private final MessageAdapterService messageAdapterService;

    public MessageAdapterController(MessageAdapterService messageAdapterService) {
        this.messageAdapterService = messageAdapterService;
    }

    @GetMapping("/process")
    public void processMessage() {
        messageAdapterService.processMessage();
    }
}