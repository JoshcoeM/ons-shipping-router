package com.manifestcorp.onsshippingrouter;

import com.manifestcorp.onsdomain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OnsShippingRouterConsumer {

    @Value("${k.topic.producer.name}")
    String outputTopic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "${k.topic.consumer.name}")
    public void listener(Order order){
        kafkaTemplate.send(outputTopic, order);
    }



}
