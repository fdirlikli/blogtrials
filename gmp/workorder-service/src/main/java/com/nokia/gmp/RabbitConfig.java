package com.nokia.gmp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ben on 23/02/16.
 */
//@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String hostname;

   /* @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;*/

    @Value("${spring.application.exchange}")
    private String exchangeName;

    @Value("${spring.application.queue}")
    private String queueName;

    @Bean
    Queue defaultStream() {
        return new Queue(queueName, true);
    }

    @Bean
    FanoutExchange eventBusExchange() {
        return new FanoutExchange(exchangeName, true, false);
    }

    @Bean
    Binding binding() {
        return new Binding(queueName, Binding.DestinationType.QUEUE, exchangeName, "*.*", null);
    }

    @Bean
    ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(hostname);
    }

    /*@Bean
    @Required
    RabbitAdmin rabbitAdmin() {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory());
        admin.setAutoStartup(true);
        admin.declareExchange(eventBusExchange());
        admin.declareQueue(defaultStream());
        admin.declareBinding(binding());
        return admin;
    }*/

    @Bean
    public RabbitTemplate rabbitTemplate()
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange(exchangeName);
        rabbitTemplate.setQueue(queueName);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    RabbitTransactionManager transactionManager(){
        RabbitTransactionManager txMgr = new RabbitTransactionManager(connectionFactory());
        return txMgr;
    }
}