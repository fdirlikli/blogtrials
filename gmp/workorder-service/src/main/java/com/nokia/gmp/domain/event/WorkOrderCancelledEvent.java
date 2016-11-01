package com.nokia.gmp.domain.event;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.axonframework.eventstore.jpa.DomainEventEntry;
import javax.persistence.Entity;
/**
 * Created by fatih.dirlikli on 27/10/16.
 */


@Entity
public class WorkOrderCancelledEvent extends DomainEventEntry {

    @TargetAggregateIdentifier
    private final Long id;

    private final String statusMessage;


    public Long getId() {
        return id;
    }

    public WorkOrderCancelledEvent(Long id, String statusMessage) {
        this.id = id;
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
