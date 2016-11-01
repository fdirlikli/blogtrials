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
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by ben on 23/02/16.
 */
@Configuration
public class RabbitConfig {

    final static String eventQueue = "GMP-EVENT-QUEUE";
    final static String eventExchange = "GMP-EVENT-EXCHANGE";


    @Bean
    Queue defaultStream() {
        return new Queue(eventQueue, true);
    }

    @Bean
    FanoutExchange eventBusExchange() {
        return new FanoutExchange(eventExchange, true, false);
    }

    @Bean
    Binding binding() {
        return new Binding(eventQueue, Binding.DestinationType.QUEUE, eventExchange, "*.*", null);
    }



    @Bean
    @Required
    RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
        RabbitAdmin admin = new RabbitAdmin(factory);
        admin.setAutoStartup(true);
        admin.declareExchange(eventBusExchange());
        admin.declareQueue(defaultStream());
        admin.declareBinding(binding());
        return admin;
    }

    /*@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setExchange(eventExchange);
        rabbitTemplate.setQueue(eventQueue);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }*/

  /*  @Bean(name = "rabbitTransactionManager")
    RabbitTransactionManager rabbitTransactionManager(ConnectionFactory factory){
        RabbitTransactionManager txMgr = new RabbitTransactionManager(factory);
        return txMgr;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }*/
}