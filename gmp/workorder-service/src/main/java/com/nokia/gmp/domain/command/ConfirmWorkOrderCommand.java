package com.nokia.gmp.domain.command;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
public class ConfirmWorkOrderCommand {

    private final int workOrderId;

    public ConfirmWorkOrderCommand(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }
}
