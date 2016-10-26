package com.nokia.gmp.domain.notifications;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by fatih.dirlikli on 30/06/16.
 */
public class OadNotificationObjectName {

    @JacksonXmlProperty
    private String mdNm;
    @JacksonXmlProperty
    private String meNm;
    @JacksonXmlProperty
    private String ptpNm;


}
