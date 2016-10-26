package com.nokia.gmp.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fatih.dirlikli on 10/06/16.
 */
@Embeddable
public class ServiceConfiguration {


    //@Column(name = "configuration_id", unique = true)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long configurationId;

    @ElementCollection
    @CollectionTable(name="service_configuration_properties", joinColumns=@JoinColumn(name="configuration_id"))
    private List<ServiceConfigurationProperty> propertyMap;

//    public Long getConfigurationId() {
//        return configurationId;
//    }
//
//    public void setConfigurationId(Long configurationId) {
//        this.configurationId = configurationId;
//    }

    public List<ServiceConfigurationProperty> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(List<ServiceConfigurationProperty> propertyMap) {
        this.propertyMap = propertyMap;
    }
}
