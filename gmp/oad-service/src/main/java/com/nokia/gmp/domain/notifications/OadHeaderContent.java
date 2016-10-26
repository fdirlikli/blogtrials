package com.nokia.gmp.domain.notifications;

/**
 * Created by fatih.dirlikli on 29/06/16.
 */
public class OadHeaderContent {
    private String activityName;
    private String msgName;
    private String msgType;
    private String senderURI;
    private String destinationURI;
    private String communicationPattern;
    private String communicationStyle;
    private String timestamp;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSenderURI() {
        return senderURI;
    }

    public void setSenderURI(String senderURI) {
        this.senderURI = senderURI;
    }

    public String getDestinationURI() {
        return destinationURI;
    }

    public void setDestinationURI(String destinationURI) {
        this.destinationURI = destinationURI;
    }

    public String getCommunicationStyle() {
        return communicationStyle;
    }

    public void setCommunicationStyle(String communicationStyle) {
        this.communicationStyle = communicationStyle;
    }

    public String getCommunicationPattern() {
        return communicationPattern;
    }

    public void setCommunicationPattern(String communicationPattern) {
        this.communicationPattern = communicationPattern;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
