package com.nokia.gmp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Created by fatih.dirlikli on 28/06/16.
 */

//TODO: Edit the class properties with the actual ones as this is implemented quickly
@Embeddable
public class OntLocationConfiguration {

    @Column(name = "oltName")
    private String oltName;

    @Column(name = "rack")
    private Integer rack;

    @Column(name = "shelf")
    private Integer shelf;

    @Column(name = "pon")
    private Integer pon;

    @JsonCreator
    public OntLocationConfiguration(@JsonProperty("oltName") String oltName,@JsonProperty("rack") Integer rack, @JsonProperty("shelf") Integer shelf,@JsonProperty("pon") Integer pon) {
        super();
        requireNonNull(oltName);
        requireNonNull(rack);
        requireNonNull(shelf);
        requireNonNull(pon);
        this.oltName = oltName;
        this.rack = rack;
        this.shelf = shelf;
        this.pon = pon;
    }

    // Just here because hibernate can not instantiate an entity without an empty constructor
    public OntLocationConfiguration() {
    }

    /**
     * Gets a location string in the form of oltname-rack-shelf-pon and generates an OntLocationConfiguration object
     *
     * @param locationString
     * @return
     */
    public static OntLocationConfiguration configure(String locationString) {

        StringTokenizer tokenizer = new StringTokenizer(locationString,"-");
        return new OntLocationConfiguration(tokenizer.nextToken() //oltname
                ,Integer.parseInt(tokenizer.nextToken()) //rack
                ,Integer.parseInt(tokenizer.nextToken()) //shelf
                ,Integer.parseInt(tokenizer.nextToken())); //pon
    }

    /**
     * Generates the locationString from a OntLocationConfiguration object.
     * @return
     */
    public String getLocationString() {
        List<String> locationList = Arrays.asList(oltName, rack.toString(), shelf.toString(),pon.toString());
        return locationList.stream().collect(Collectors.joining("-"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OntLocationConfiguration that = (OntLocationConfiguration) o;

        if (!oltName.equals(that.oltName)) return false;
        if (!rack.equals(that.rack)) return false;
        if (!shelf.equals(that.shelf)) return false;
        return pon.equals(that.pon);

    }

    @Override
    public int hashCode() {
        int result = oltName.hashCode();
        result = 31 * result + rack.hashCode();
        result = 31 * result + shelf.hashCode();
        result = 31 * result + pon.hashCode();
        return result;
    }
}
