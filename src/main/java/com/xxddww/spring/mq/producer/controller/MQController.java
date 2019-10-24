package com.xxddww.spring.mq.producer.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxddww.spring.mq.producer.pojo.dto.RabbitMQDto;
import com.xxddww.spring.mq.producer.rabbitMQ.producer.RabbitMQProducer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/producer")
public class MQController {

    private static final Logger logger = LoggerFactory.getLogger(MQController.class);


    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping(value = "/send")
    public Object send(@RequestBody RabbitMQDto rabbitMQDto) throws Exception {

        System.out.println("MQ-Producer --- 请求参数----》" + JSONObject.toJSONString(rabbitMQDto));

        if(StringUtils.isBlank(rabbitMQDto.getExchangeName())){
            rabbitMQProducer.send(rabbitMQDto.getQueue(), rabbitMQDto.getMessage());
        }else{
            rabbitMQProducer.send(rabbitMQDto.getExchangeName(), rabbitMQDto.getRoutingKey(), rabbitMQDto.getMessage());
        }

        return "MQ-Producer  测试成功";
    }

}
