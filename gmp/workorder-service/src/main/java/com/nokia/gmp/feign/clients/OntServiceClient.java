package com.nokia.gmp.feign.clients;

import com.nokia.gmp.domain.Ont;
import com.nokia.gmp.domain.WorkOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fatih.dirlikli on 15/06/16.
 */

@FeignClient("ont-service")
public interface OntServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ont/search/findBySerialNumber?serialNumber={serialNumber}")
    ResponseEntity<Ont> getOntBySerialNumber(@PathVariable("serialNumber") String serialNumber);

    @RequestMapping(method = RequestMethod.GET, value = "/ont/gatlingTest")
    ResponseEntity<String> gatlingTest();
}
