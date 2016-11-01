package com.nokia.gmp.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
public class CancelWorkOrderCommand {

    @TargetAggregateIdentifier
    private final Long workOrderId;

    private final String message;

    public CancelWorkOrderCommand(Long workOrderId,String message) {
        this.workOrderId = workOrderId;
        this.message = message;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public String getMessage() {
        return message;
    }
}
