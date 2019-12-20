package com.lucky.springbootkafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: H
 * @description:
 * @program: springboot-kafka
 * @create: 2019-12-16 19:52
 **/
@Component
public class KafkaReceiver {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = {"test"},groupId = "test-consumer-group")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }

    }
}