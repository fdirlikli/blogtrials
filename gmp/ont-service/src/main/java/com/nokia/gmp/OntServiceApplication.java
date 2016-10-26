package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@SpringBootApplication
//@EnableRabbit
@EnableFeignClients
@EnableDiscoveryClient
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class OntServiceApplication {

	public static void main(String[] args)
    {
		SpringApplication.run(OntServiceApplication.class, args);
	}

    /*@RabbitListener(queues = RabbitConfig.WORKORDER_QUEUE)
	public void listenWorkOrder(WorkOrder test) throws Exception
    {
		System.out.println(test);
        System.out.println(test.getOntSerialNumber());
        if(test.getOntSerialNumber() == null || test.getOntSerialNumber().equals(""))
        {
            throw new AmqpRejectAndDontRequeueException("to dead-letter");
        }
	}*/




//    @Bean
//    public feign.Logger.Level feignLoggerLevel() {
//        return feign.Logger.Level.FULL;
//    }



}
