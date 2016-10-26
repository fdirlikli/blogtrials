package com.nokia.gmp.domain.notifications;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by fatih.dirlikli on 29/06/16.
 */
public class OadNotificationHeader {

    @JacksonXmlProperty(localName = "header")
    private OadHeaderContent headerContent;

    public OadHeaderContent getHeaderContent() {
        return headerContent;
    }

    public void setHeaderContent(OadHeaderContent headerContent) {
        this.headerContent = headerContent;
    }
}
