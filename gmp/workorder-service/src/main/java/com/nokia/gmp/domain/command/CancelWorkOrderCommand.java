package com.nokia.gmp.domain.command;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
public class CancelWorkOrderCommand {
    private final Long workOrderId;

    public CancelWorkOrderCommand(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }
}
