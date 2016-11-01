package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventCountSnapshotterTrigger;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.axonframework.eventsourcing.HybridJpaRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.jpa.JpaEventStore;
import org.axonframework.serializer.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ben on 23/02/16.
 */
@Configuration
@AnnotationDriven
public class AxonConfig {

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
    public EventSourcingRepository<WorkOrder> genericJpaRepository(EventStore eventStore){
        EventCountSnapshotterTrigger trigger = new EventCountSnapshotterTrigger();
        trigger.setTrigger(3);
        EventSourcingRepository<WorkOrder> repository = new EventSourcingRepository<WorkOrder>(new GenericAggregateFactory<WorkOrder>(WorkOrder.class),eventStore);
        repository.setEventBus(eventBus());
        repository.setSnapshotterTrigger(trigger);
        return repository;
    }

    @Bean
    public SimpleEventBus eventBus() {
        return new SimpleEventBus();
    }

    @Bean
    EventStore jpaEventStore(ContainerManagedEntityManagerProvider provider){
        return new JpaEventStore(provider,eventSerializer());
    }

    @Bean
    XStreamSerializer eventSerializer(){
        return new XStreamSerializer();
    }

    @Bean
    ContainerManagedEntityManagerProvider entityManagerProvider(){
        return new ContainerManagedEntityManagerProvider();
    }

    @Bean
    AggregateAnnotationCommandHandler<WorkOrder> workOrderAggregateCommandHandler(EventSourcingRepository repository) {
        @SuppressWarnings("deprecation")
        AggregateAnnotationCommandHandler<WorkOrder> handler = new AggregateAnnotationCommandHandler<WorkOrder>(
                WorkOrder.class,
                repository,
                commandBus());



        return handler;
    }
}