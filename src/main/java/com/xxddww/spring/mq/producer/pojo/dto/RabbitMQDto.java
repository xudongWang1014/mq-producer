package com.xxddww.spring.mq.producer.pojo.dto;

import java.io.Serializable;

/**
 * rabbitMQ实体类
 */
public class RabbitMQDto implements Serializable {

    private static final long serialVersionUID = 2099384816245399110L;

    private String exchangeName;
    private String routingKey;
    private String queue;
    private String message;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
