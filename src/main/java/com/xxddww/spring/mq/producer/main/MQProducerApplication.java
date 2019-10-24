package com.xxddww.spring.mq.producer.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xxddww.spring"})
public class MQProducerApplication {

    private final static Logger logger = LoggerFactory.getLogger(MQProducerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MQProducerApplication.class, args);

        logger.info("【MQProducerApplication】启动完成");
    }

}
