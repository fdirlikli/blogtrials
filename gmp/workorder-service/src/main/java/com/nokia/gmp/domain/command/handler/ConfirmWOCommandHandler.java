package com.nokia.gmp.domain.command.handler;

import com.nokia.gmp.domain.command.ConfirmWorkOrderCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
@Component
public class ConfirmWOCommandHandler {

    private static final Logger logger = LoggerFactory.getLogger(ConfirmWOCommandHandler.class);

    @CommandHandler
    public void handle(ConfirmWorkOrderCommand confirmWorkOrderCommand){

        System.out.println("I can handle the creditAccount command: "
                + "Account to credit: " + confirmWorkOrderCommand.getWorkOrderId());
    }
}
