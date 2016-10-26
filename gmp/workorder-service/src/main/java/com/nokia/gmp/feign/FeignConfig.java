package com.nokia.gmp.feign;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.hystrix.HystrixFeign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.config.EnableHypermediaSupport;

/**
 * Created by fatih.dirlikli on 24/06/16.
 */
@Configuration
@EnableFeignClients
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class FeignConfig {
   /* @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }*/

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return HystrixFeign.builder().decode404().logLevel(Logger.Level.FULL).options(new Request.Options(20000,20000));
    }
}
