package com.xxddww.spring.mq.producer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 加载MQ资源文件
 */
@Configuration
@PropertySource({"classpath:mq.properties"} )
public class MQConfig {

}
