package com.nokia.gmp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fatih.dirlikli on 09/06/16.
 */
//@Configuration
public class RabbitConfig {

   /* final static String WORKORDER_QUEUE = "spring-boot";
    final static String DEAD_LETTER_QUEUE = "dead-letter";
    final static String DEFAULT_EXCHANGE = "spring-boot-exchange";

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory)
    {
         RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
         rabbitTemplate.setExchange(DEFAULT_EXCHANGE);
         rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
         return rabbitTemplate;
    }

    @Bean
    Queue deadLetterQueue()
    {
        return new Queue(DEAD_LETTER_QUEUE,true);
    }

    @Bean
    Queue queue()
    {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange", DEFAULT_EXCHANGE);
        args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE);
        return new Queue(WORKORDER_QUEUE,true,false,false,args);
    }

    @Bean
    TopicExchange exchange()
    {
        return new TopicExchange(DEFAULT_EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with(WORKORDER_QUEUE);
    }

    @Bean
    Binding bindingDeadLetter(Queue deadLetterQueue, TopicExchange exchange)
    {
        return BindingBuilder.bind(deadLetterQueue).to(exchange).with(DEAD_LETTER_QUEUE);
    }

    @Bean
    SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        SimpleRabbitListenerContainerFactory container = new SimpleRabbitListenerContainerFactory();
        container.setConnectionFactory(connectionFactory);
        container.setMessageConverter(new Jackson2JsonMessageConverter());
        return container;
    }*/
}
