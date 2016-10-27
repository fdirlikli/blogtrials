package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.HybridJpaRepository;
import org.axonframework.repository.GenericJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * Created by ben on 23/02/16.
 */
@Configuration
@AnnotationDriven
public class AxonConfig {

    @Autowired
    EntityManager entityManager;

    @Bean
    public SimpleCommandBus commandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus();
        return simpleCommandBus;
    }


   /* @Bean
    AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
        *//**
         * The AnnotationCommandHandlerBeanPostProcessor
         * finds all beans that has @CommandHandler
         * and subscribed them to the commandBus with the
         * first argument of the method being the
         * the command type the method will be subscribed to.
         *//*
        AnnotationCommandHandlerBeanPostProcessor handler = new AnnotationCommandHandlerBeanPostProcessor();
        handler.setCommandBus(commandBus());
        return handler;
    }*/

    @Bean
    public DefaultCommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }

    @Bean
    public HybridJpaRepository genericJpaRepository() {
        SimpleEntityManagerProvider entityManagerProvider = new SimpleEntityManagerProvider(entityManager);
        return new HybridJpaRepository(entityManagerProvider, WorkOrder.class);
    }

    @Bean
    public SimpleEventBus eventBus() {
        return new SimpleEventBus();
    }
}