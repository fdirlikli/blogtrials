package com.nokia.gmp.domain;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import java.util.Date;
import java.util.List;

/**
 * Created by fatih.dirlikli on 26/10/16.
 */
public class WorkOrderAggregate extends AbstractAnnotatedAggregateRoot {
    private static final long serialVersionUID = 1L;


    @AggregateIdentifier
    private Long id;

    public WorkOrderAggregate() {
        super();
    }

    private String cpeSerialNumber;

    private String cpeMacAddress;

    private String ontSerialNumber;

    private Date creationDate;

    private String createdBy;

    private String statusMessage;


    private WorkOrderType type;

    private List<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpeSerialNumber() {
        return cpeSerialNumber;
    }

    public void setCpeSerialNumber(String cpeSerialNumber) {
        this.cpeSerialNumber = cpeSerialNumber;
    }

    public String getCpeMacAddress() {
        return cpeMacAddress;
    }

    public void setCpeMacAddress(String cpeMacAddress) {
        this.cpeMacAddress = cpeMacAddress;
    }

    public String getOntSerialNumber() {
        return ontSerialNumber;
    }

    public void setOntSerialNumber(String ontSerialNumber) {
        this.ontSerialNumber = ontSerialNumber;
    }



    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public WorkOrderType getType() {
        return type;
    }

    public void setType(WorkOrderType type) {
        this.type = type;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public enum WorkOrderType
    {

        ADD_SUBSCRIPTION,
        REMOVE_SUBSCIPTION,
        ADD_SERVICE,
        UPDATE_SERVICE,
        REMOVE_SERVICE
    }

}
