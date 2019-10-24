package com.xxddww.spring.mq.producer.rabbitMQ.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 */
@Component
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @param exchangeName 交换机名称
     * @param routingKey   发送的routingKey
     * @param message      消息内容
     */
    public void send(String exchangeName, String routingKey, String message) {
        amqpTemplate.convertAndSend(exchangeName, routingKey, message);  //发送消息
    }

    /**
     * 指定队列发送消息
     *
     * @param queue 队列名称
     * @param msg   消息内容
     */
    public void send(String queue, String msg) {
        amqpTemplate.convertAndSend(queue, msg);  //发送消息
    }
}
