package com.nokia.gmp.domain;

import javax.persistence.*;

/**
 * Created by fatih.dirlikli on 11/06/16.
 */

@Embeddable
public class ServiceConfigurationProperty {

    //@Column(name = "configuration_id")
   // private Long serviceConfigurationId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Long getServiceConfigurationId() {
//        return serviceConfigurationId;
//    }
//
//    public void setServiceConfigurationId(Long serviceConfigurationId) {
//        this.serviceConfigurationId = serviceConfigurationId;
//    }

}
