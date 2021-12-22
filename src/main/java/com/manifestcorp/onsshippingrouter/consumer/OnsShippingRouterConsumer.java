package com.manifestcorp.onsshippingrouter.consumer;

import com.manifestcorp.onsdomain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OnsShippingRouterConsumer {

    @Value("${k.topic.mainDc.producer.name}")
    String mainDcTopic;

    @Value("${k.topic.ohioDc.producer.name}")
    String ohioDcTopic;


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "${k.topic.consumer.name}")

    public void listener(@Payload Order order, @Header("DistributionCenter") String distributionCenter){
        if(distributionCenter.equals("ohio-dc")){
            kafkaTemplate.send(ohioDcTopic, order);
        }else if(distributionCenter.equals("main-dc")){
            kafkaTemplate.send(mainDcTopic, order);
        }
    }

}
