package com.nokia.gmp.domain.command;

/**
 * Created by fatih.dirlikli on 31/10/16.
 */
public class CreateWorkOrderCommand {
    private final Long workOrderId;

    public CreateWorkOrderCommand(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }
}
