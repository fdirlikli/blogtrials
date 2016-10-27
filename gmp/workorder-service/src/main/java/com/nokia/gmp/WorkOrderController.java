package com.nokia.gmp;

import com.nokia.gmp.domain.Ont;
import com.nokia.gmp.domain.Service;
import com.nokia.gmp.domain.WorkOrder;
import com.nokia.gmp.domain.command.ConfirmWorkOrderCommand;
import com.nokia.gmp.domain.command.CancelWorkOrderCommand;
import com.nokia.gmp.domain.exception.OntInUseException;
import com.nokia.gmp.feign.clients.OntServiceClient;
import com.nokia.gmp.repository.ServiceRepository;
import com.nokia.gmp.repository.WorkOrderRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fatih.dirlikli on 03/06/16.
 */



@RepositoryRestController
public class WorkOrderController {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderController.class);
    @Autowired
    private WorkOrderRepository workOrderRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private OntServiceClient ontServiceClient;
    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public WorkOrderController() {
    }

    @RequestMapping(value = "/workorder/create", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkOrder(@RequestParam("id") Integer id)
    {
        ConfirmWorkOrderCommand command = new ConfirmWorkOrderCommand(id);
        commandGateway.send(command);
    }

    @RequestMapping(value = "/workorder/update", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateWorkOrder(@RequestParam("id") Long id)
    {
        CancelWorkOrderCommand command = new CancelWorkOrderCommand(id);
        commandGateway.send(command);
    }

    @RequestMapping(value = "/workorder/mytest", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> get() throws OntInUseException,InterruptedException
    {
        return ontServiceClient.gatlingTest();
    }

    @RequestMapping(value = "/workorder/test2", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> test2()
    {
        logger.error("My Service got the request!!");
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/workorder", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@Validated @RequestBody WorkOrder inputWorkOrder) throws OntInUseException
    {
        Ont existingOnt = ontServiceClient.getOntBySerialNumber(inputWorkOrder.getOntSerialNumber()).getBody();
        if(existingOnt != null && existingOnt.getType().equals(Ont.Type.SFP))
        {
            logger.error("Ont in questions has already configuration!");
            //return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
           throw new OntInUseException("Ont in use");
        }
        WorkOrder createdWO = workOrderRepository.save(inputWorkOrder);
        if(inputWorkOrder.getServices() != null){
            inputWorkOrder.getServices()
                    .stream()
                    .map( s -> { s.setWorkOrderId(createdWO.getId()); return s; } )
                    .forEach( s -> serviceRepository.save(s) );
        }

        rabbitTemplate.convertAndSend("spring-boot",createdWO);
        Service s = serviceRepository.findOne(1L);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}