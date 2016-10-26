package com.nokia.gmp.domain;

import javax.persistence.*;

/**
 * Created by fatih.dirlikli on 09/06/16.
 */

public class Ont {


    private Long id;

    private String serialNumber;

    private Type type;

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
}
