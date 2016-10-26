package com.nokia.gmp.domain;

import javax.persistence.*;

/**
 * Created by fatih.dirlikli on 10/06/16.
 */
@Entity
@Table(name = "workorder_service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" )
    private Long id;

    @Column(name = "type")
    private Type type;

    @Embedded
    private ServiceConfiguration configuration;

    @Column(name = "workOrderId")
    private Long workOrderId;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ServiceConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public enum Type
    {
        HSI,
        VoIP,
        IPTV
    }
}
