package com.nokia.gmp.domain.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by fatih.dirlikli on 29/06/16.
 */
@JacksonXmlRootElement(localName = "Envelope", namespace = "soapenv")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OadNotification {

    @JacksonXmlProperty(localName = "Header", namespace = "soapenv")
    private OadNotificationHeader oadNotificationHeader;

    @JacksonXmlProperty(localName = "Body", namespace = "soapenv")
    private OadNotificationBody oadNotificationBody;



    public OadNotificationHeader getOadNotificationHeader() {
        return oadNotificationHeader;
    }

    public void setOadNotificationHeader(OadNotificationHeader oadNotificationHeader) {
        this.oadNotificationHeader = oadNotificationHeader;
    }

    public OadNotificationBody getOadNotificationBody() {
        return oadNotificationBody;
    }

    public void setOadNotificationBody(OadNotificationBody oadNotificationBody) {
        this.oadNotificationBody = oadNotificationBody;
    }
}
