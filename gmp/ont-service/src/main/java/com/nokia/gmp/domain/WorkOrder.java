package com.nokia.gmp.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by fdirlikl on 5/13/2016.
 */

public class WorkOrder {
    private static final long serialVersionUID = 1L;

    private Long id;

    public WorkOrder() {
        super();
    }

    private String cpeSerialNumber;
    private String cpeMacAddress;
    private String ontSerialNumber;
    private Date creationDate;
    private String createdBy;
    private String statusMessage;



    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCpeSerialNumber()
    {
        return cpeSerialNumber;
    }

    public void setCpeSerialNumber(String cpeSerialNumber)
    {
        this.cpeSerialNumber = cpeSerialNumber;
    }

    public String getCpeMacAddress()
    {
        return cpeMacAddress;
    }

    public void setCpeMacAddress(String cpeMacAddress)
    {
        this.cpeMacAddress = cpeMacAddress;
    }

    public String getOntSerialNumber()
    {
        return ontSerialNumber;
    }

    public void setOntSerialNumber(String ontSerialNumber)
    {
        this.ontSerialNumber = ontSerialNumber;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getStatusMessage()
    {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage)
    {
        this.statusMessage = statusMessage;
    }

    public enum WorkOrderType
    {
        CREATE_CONFIG,
        REMOVE_CONFIG,
        UPDATE_CONFIG
    }



}
