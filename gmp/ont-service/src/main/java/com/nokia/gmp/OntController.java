package com.nokia.gmp;

import com.nokia.gmp.domain.WorkOrder;
import com.nokia.gmp.repository.OntRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by fatih.dirlikli on 03/06/16.
 */



@RepositoryRestController
public class OntController {

    @Autowired
    private OntRepository ontRepository;

    @Autowired
    private WorkOrderServiceClient workOrderServiceClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OntController() {
    }

    @RequestMapping(value = "/ont/getWorkOrders", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void getWorkOrders()
    {

        Resources<WorkOrder> workOrders = workOrderServiceClient.getWorkOrders();

        System.out.println();
    }


    @RequestMapping(value = "/ont/gatlingTest", method = RequestMethod.GET)
    public ResponseEntity<String> gatlingTest() throws InterruptedException{
        //Thread.sleep(1000);
        return new ResponseEntity<String>("From Ont Service",HttpStatus.ACCEPTED) ;
    }
}