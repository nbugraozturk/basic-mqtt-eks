package com.example.producer_service.controller;

import com.example.producer_service.service.MessageService;
import com.example.producer_service.model.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MqttController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody MessageRequest request) {
        messageService.sendMessage(request.getTopic(), request.getMessage());
        return ResponseEntity.ok("Message published successfully");
    }
}