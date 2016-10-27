package com.nokia.gmp.domain.command.handler;

import com.nokia.gmp.domain.WorkOrder;
import com.nokia.gmp.domain.command.CancelWorkOrderCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
@Component
public class CancelWOCommandHandler {

    @Autowired
    private Repository repository;



    private static final Logger logger = LoggerFactory.getLogger(ConfirmWOCommandHandler.class);

    @CommandHandler
    public void handle(CancelWorkOrderCommand cancelWorkOrderCommand){
        WorkOrder wo = (WorkOrder) repository.load(cancelWorkOrderCommand.getWorkOrderId());
        wo.cancel();
        System.out.println("I can handle the creditAccount command: "
                + "Account to credit: " + cancelWorkOrderCommand.getWorkOrderId());
    }
}
