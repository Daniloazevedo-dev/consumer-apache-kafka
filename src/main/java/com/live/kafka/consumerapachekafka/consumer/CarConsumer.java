package com.live.kafka.consumerapachekafka.consumer;

import com.live.kafka.consumerapachekafka.dto.CarDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarConsumer {

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "carKafkaListenerContainerFactory")
    public void listenerTopCar(ConsumerRecord<String, CarDTO> record) {
        log.info("Received message: {}", record.value());
        log.info("Partition: {}", record.partition());
    }

}
