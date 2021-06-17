package com.project.contextdeliveryservice.kafka;

public interface KafkaProducer {
    void send(String key, String msg);
}
