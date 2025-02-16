package com.example.producer_service.service;

import com.example.producer_service.messaging.MqttPublisher;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MqttPublisher mqttPublisher;

    public void sendMessage(String topic, String message) {
        mqttPublisher.publish(topic, message);
    }
}