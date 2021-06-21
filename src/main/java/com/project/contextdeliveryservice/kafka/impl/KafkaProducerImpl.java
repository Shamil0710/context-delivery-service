package com.project.contextdeliveryservice.kafka.impl;

import com.project.contextdeliveryservice.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class KafkaProducerImpl implements KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String key, String msg) {
        log.info("Получено KEY = {} Value = {} ", key, msg);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("${from_source_topic}", key, msg);
        log.info("Записано в топик " + "${from_source_topic}" + "  " + future);
    }
}
