package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.*;
import org.axonframework.eventhandling.amqp.spring.ListenerContainerLifecycleManager;
import org.axonframework.eventhandling.amqp.spring.SpringAMQPConsumerConfiguration;
import org.axonframework.eventhandling.amqp.spring.SpringAMQPTerminal;
import org.axonframework.eventhandling.async.AsynchronousCluster;
import org.axonframework.eventsourcing.EventCountSnapshotterTrigger;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.jpa.JpaEventStore;
import org.axonframework.serializer.json.JacksonSerializer;
import org.axonframework.serializer.xml.XStreamSerializer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ben on 23/02/16.
 */
@Configuration
@AnnotationDriven
public class AxonConfig {

    private static final String AMQP_CONFIG_KEY = "AMQP.Config";
    private final static String eventQueue = "GMP-EVENT-QUEUE";
    private final static String eventExchange = "GMP-EVENT-EXCHANGE";

    @Bean
    public SimpleCommandBus commandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus();
        return simpleCommandBus;
    }

    @Bean
    public DefaultCommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }


    @Bean
    public EventSourcingRepository<WorkOrder> genericJpaRepository(EventStore eventStore,EventBus eventBus){
        EventCountSnapshotterTrigger trigger = new EventCountSnapshotterTrigger();
        trigger.setTrigger(3);
        EventSourcingRepository<WorkOrder> repository = new EventSourcingRepository<WorkOrder>(new GenericAggregateFactory<WorkOrder>(WorkOrder.class),eventStore);
        repository.setEventBus(eventBus);
        repository.setSnapshotterTrigger(trigger);
        return repository;
    }

    @Bean
    SpringAMQPConsumerConfiguration springAMQPConsumerConfiguration() {
        SpringAMQPConsumerConfiguration cfg = new SpringAMQPConsumerConfiguration();
        //cfg.setTransactionManager(transactionManager);
        cfg.setQueueName(eventQueue);
        cfg.setTxSize(10);
        return cfg;
    }
    @Bean
    AsynchronousCluster simpleCluster(SpringAMQPConsumerConfiguration springAMQPConsumerConfiguration) {
        AsynchronousCluster cluster = new AsynchronousCluster(eventQueue);
        cluster.getMetaData().setProperty(AMQP_CONFIG_KEY, springAMQPConsumerConfiguration);
        return cluster;
    }

    @Bean
    ListenerContainerLifecycleManager listenerContainerLifecycleManager(ConnectionFactory connectionFactory) {
        ListenerContainerLifecycleManager mgr = new ListenerContainerLifecycleManager();
        mgr.setConnectionFactory(connectionFactory);
        return mgr;
    }

    @Bean
    JacksonSerializer axonJsonSerializer() {
        return new JacksonSerializer();
    }

    @Bean
    EventBusTerminal terminal(ConnectionFactory connectionFactory,ListenerContainerLifecycleManager listenerContainerLifecycleManager) {
        SpringAMQPTerminal terminal = new SpringAMQPTerminal();
        terminal.setConnectionFactory(connectionFactory);
        terminal.setExchangeName(eventExchange);
        terminal.setDurable(true);
        //terminal.setTransactional(true);
        terminal.setSerializer(eventSerializer());
        //terminal.setSerializer(xmlSerializer());
        terminal.setListenerContainerLifecycleManager(listenerContainerLifecycleManager);
        return terminal;
    }

    @Bean
    public EventBus eventBus(EventBusTerminal terminal,SimpleCluster simpleCluster) {
        return new ClusteringEventBus(new DefaultClusterSelector(simpleCluster), terminal);
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