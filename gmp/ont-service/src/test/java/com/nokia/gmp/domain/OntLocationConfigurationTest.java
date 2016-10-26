package com.nokia.gmp.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fatih.dirlikli on 28/06/16.
 */
public class OntLocationConfigurationTest {


    @Test
    public void configure() throws Exception {
        OntLocationConfiguration testAgainst = new OntLocationConfiguration("ahmet",1,2,3);
        OntLocationConfiguration subject = OntLocationConfiguration.configure("ahmet-1-2-3");
        assertEquals(testAgainst,subject);
    }

    @Test
    public void getLocationString() throws Exception {
        OntLocationConfiguration configuration = new OntLocationConfiguration("ahmet",1,2,3);
        String locationString = configuration.getLocationString();
        assertEquals(locationString,"ahmet-1-2-3");
    }

}