package com.nokia.gmp.domain.notifications;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by fatih.dirlikli on 30/06/16.
 */
public class OadNotificationMessage {

    @JacksonXmlProperty(localName = "Alarm")
    private OadNotificationAlarm alarm;
}
