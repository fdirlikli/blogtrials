package com.nokia.gmp.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
public class ConfirmWorkOrderCommand {

    @TargetAggregateIdentifier
    private final Long workOrderId;

    public ConfirmWorkOrderCommand(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }
}
