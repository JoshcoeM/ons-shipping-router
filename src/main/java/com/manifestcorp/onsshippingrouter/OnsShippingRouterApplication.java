package com.manifestcorp.onsshippingrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnsShippingRouterApplication {

    public static void main(String args[]){
        SpringApplication.run(OnsShippingRouterConsumer.class,args);
    }

}
