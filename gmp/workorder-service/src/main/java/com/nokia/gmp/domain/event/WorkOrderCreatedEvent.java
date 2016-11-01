package com.nokia.gmp.domain.event;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.axonframework.eventstore.jpa.DomainEventEntry;

import javax.persistence.Entity;

/**
 * Created by fatih.dirlikli on 31/10/16.
 */

@Entity
public class WorkOrderCreatedEvent extends DomainEventEntry {

    @TargetAggregateIdentifier
    private final Long workOrderId;


    public WorkOrderCreatedEvent(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }
}
