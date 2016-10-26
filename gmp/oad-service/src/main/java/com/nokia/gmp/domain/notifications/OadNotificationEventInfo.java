package com.nokia.gmp.domain.notifications;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by fatih.dirlikli on 30/06/16.
 */
public class OadNotificationEventInfo {

    @JacksonXmlProperty
    private String notificationId;
    @JacksonXmlProperty
    private OadNotificationObjectName objectName;
    @JacksonXmlProperty
    private String objectType;
    @JacksonXmlProperty
    private String osTime;
    @JacksonXmlProperty
    private String neTime;




}
