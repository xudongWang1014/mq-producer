package com.xxddww.spring.mq.producer.rabbitMQ.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description 消息发送确认
 * <p>
 * ConfirmCallback  只确认消息是否正确到达 Exchange 中
 * ReturnCallback   消息没有正确到达队列时触发回调，如果正确到达队列不执行
 * <p>
 * 1. 如果消息没有到exchange,则confirm回调,ack=false
 * 2. 如果消息到达exchange,则confirm回调,ack=true
 * 3. exchange到queue成功,则不回调return
 * 4. exchange到queue失败,则回调return
 */
@Component
public class MQProducerAck implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private final static Logger logger = LoggerFactory.getLogger(MQProducerAck.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);            //指定 ConfirmCallback
        rabbitTemplate.setReturnCallback(this);             //指定 ReturnCallback

    }

    /**
     * 确认消息是否到达exchange
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        if(!ack){
            logger.info("【MQProducerAck】消息到达exchange失败,返回内容---》correlationData：{}，cause：{}",correlationData, cause );
        }
    }

    /**
     * exchange到queue失败,则回调
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        logger.info("【MQProducerAck】exchange到queue失败,返回内容---》message：{}，replyCode：{}，replyText：{}，exchange：{}，routingKey：{}", new String(message.getBody()), replyCode, replyText, exchange, routingKey);
    }
}


