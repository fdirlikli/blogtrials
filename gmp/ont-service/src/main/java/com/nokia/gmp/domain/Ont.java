package com.nokia.gmp.domain;

import javax.persistence.*;

/**
 * Created by fatih.dirlikli on 09/06/16.
 */
@Entity
@Table(name = "ont")
public class Ont {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "type")
    private Type type;

    private Integer ontId;

    @Embedded
    private OntLocationConfiguration locationConfiguration;

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        id = id;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public enum Type
    {
        SFP,
        STANDARD
    }

    public OntLocationConfiguration getLocationConfiguration() {
        return locationConfiguration;
    }

    public void setLocationConfiguration(OntLocationConfiguration locationConfiguration) {
        this.locationConfiguration = locationConfiguration;
    }
}
