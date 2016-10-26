package com.nokia.gmp.domain;


import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by fdirlikl on 5/13/2016.
 */
@Entity
@Table(name = "Workorder")
public class WorkOrder extends AbstractAnnotatedAggregateRoot implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public WorkOrder() {
        super();
    }

    @Column(name = "CPE_serial_number")
    private String cpeSerialNumber;

    @Column(name = "CPE_mac_address")
    private String cpeMacAddress;

    @Column(name = "ONT_serial_number")
    @NotEmpty
    private String ontSerialNumber;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "status_message")
    private String statusMessage;

    @Column(name = "type")
    @NotNull
    private WorkOrderType type;

    @Transient
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
