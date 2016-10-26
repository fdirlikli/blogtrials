package com.nokia.gmp;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.nokia.gmp.domain.notifications.OadNotification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OadServiceApplication {

	private static String newOntNotification = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"tmf854.v1\" xmlns:alu=\"alu.v1\">\n" +
			"\t<soapenv:Header>\n" +
			"\t\t<header>\n" +
			"\t\t\t<activityName>notify</activityName>\n" +
			"\t\t\t<msgName>notify</msgName>\n" +
			"\t\t\t<msgType>NOTIFICATION</msgType>\n" +
			"\t\t\t<senderURI>http://10.35.82.161</senderURI>\n" +
			"\t\t\t<destinationURI>urn:topic/Fault</destinationURI>\n" +
			"\t\t\t<communicationPattern>Notification</communicationPattern>\n" +
			"\t\t\t<communicationStyle>MSG</communicationStyle>\n" +
			"\t\t\t<timestamp>20140922091606.901+0300</timestamp>\n" +
			"\t\t</header>\n" +
			"\t</soapenv:Header>\n" +
			"\t<soapenv:Body>\n" +
			"\t\t<notify>\n" +
			"\t\t\t<topic>topic/Fault</topic>\n" +
			"\t\t\t<message>\n" +
			"\t\t\t\t<Alarm>\n" +
			"\t\t\t\t\t<eventInfo>\n" +
			"\t\t\t\t\t\t<notificationId>AMS:20770</notificationId>\n" +
			"\t\t\t\t\t\t<objectName>\n" +
			"\t\t\t\t\t\t\t<mdNm>AMS</mdNm>\n" +
			"\t\t\t\t\t\t\t<meNm>Raman-OLT1</meNm>\n" +
			"\t\t\t\t\t\t\t<ptpNm>/rack=1/shelf=1/slot=LT3/port=6</ptpNm>\n" +
			"\t\t\t\t\t\t</objectName>\n" +
			"\t\t\t\t\t\t<objectType>OT_PHYSICAL_TERMINATION_POINT</objectType>\n" +
			"\t\t\t\t\t\t<osTime>20140922091606.898+0300</osTime>\n" +
			"\t\t\t\t\t\t<neTime>20140922091604.584+0300</neTime>\n" +
			"\t\t\t\t\t</eventInfo>\n" +
			"\t\t\t\t\t<isClearable>true</isClearable>\n" +
			"\t\t\t\t\t<aliasNameList>\n" +
			"\t\t\t\t\t\t<alias>\n" +
			"\t\t\t\t\t\t\t<aliasName>REPORTING_FOR</aliasName>\n" +
			"\t\t\t\t\t\t\t<aliasValue>ONT New:Raman-OLT1:R1.S1.LT3.PON6.NEWONT1</aliasValue>\n" +
			"\t\t\t\t\t\t</alias>\n" +
			"\t\t\t\t\t\t<alias>\n" +
			"\t\t\t\t\t\t\t<aliasName>NE_ALIAS_NAME</aliasName>\n" +
			"\t\t\t\t\t\t\t<aliasValue></aliasValue>\n" +
			"\t\t\t\t\t\t</alias>\n" +
			"\t\t\t\t\t</aliasNameList>\n" +
			"\t\t\t\t\t<layerRate>PROP_UNKNOWN</layerRate>\n" +
			"\t\t\t\t\t<probableCause>\n" +
			"\t\t\t\t\t\t<ru>false</ru>\n" +
			"\t\t\t\t\t\t<contra>false</contra>\n" +
			"\t\t\t\t\t\t<type>EQPT</type>\n" +
			"\t\t\t\t\t</probableCause>\n" +
			"\t\t\t\t\t<nativeProbableCause>Configuration Or Customization Error</nativeProbableCause>\n" +
			"\t\t\t\t\t<additionalText>SERNUM = ALCLF9017954, SLID = DEFAULT, LOID = , DISIND = </additionalText>\n" +
			"\t\t\t\t\t<perceivedSeverity>PS_MINOR</perceivedSeverity>\n" +
			"\t\t\t\t\t<serviceAffecting>SA_NON_SERVICE_AFFECTING</serviceAffecting>\n" +
			"\t\t\t\t\t<rcaiIndicator>false</rcaiIndicator>\n" +
			"\t\t\t\t\t<acknowledgeIndication>AI_EVENT_UNACKNOWLEDGED</acknowledgeIndication>\n" +
			"\t\t\t\t\t<X733_EventType>equipmentAlarm</X733_EventType>\n" +
			"\t\t\t\t\t<X733_SpecificProblems>\n" +
			"\t\t\t\t\t\t<specificProblem>New ONT Discovered</specificProblem>\n" +
			"\t\t\t\t\t</X733_SpecificProblems>\n" +
			"\t\t\t\t\t<X733_ProposedRepairActions>\n" +
			"\t\t\t\t\t\t<proposedRepairAction>No repair is necessary. This alarm serves as an indication that further provisioning is required.</proposedRepairAction>\n" +
			"\t\t\t\t\t</X733_ProposedRepairActions>\n" +
			"\t\t\t\t\t<vendorExtensions>\n" +
			"\t\t\t\t\t\t<alu:package alu:name=\"ADDITIONAL_ATTRIBUTES\">\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>tl1Cause</name>\n" +
			"\t\t\t\t\t\t\t\t<value>NEWONT</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>alarmDomain</name>\n" +
			"\t\t\t\t\t\t\t\t<value>PON</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>neGroup</name>\n" +
			"\t\t\t\t\t\t\t\t<value>Network/DIYARBAKIR</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>neType</name>\n" +
			"\t\t\t\t\t\t\t\t<value>iSAM</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>probableCauseMnemonic</name>\n" +
			"\t\t\t\t\t\t\t\t<value>CFG</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>neAlarmType</name>\n" +
			"\t\t\t\t\t\t\t\t<value>45/7</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t<alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t\t\t<name>neIpAddress</name>\n" +
			"\t\t\t\t\t\t\t\t<value>10.34.252.30</value>\n" +
			"\t\t\t\t\t\t\t</alu:NameAndStringValue>\n" +
			"\t\t\t\t\t\t</alu:package>\n" +
			"\t\t\t\t\t</vendorExtensions>\n" +
			"\t\t\t\t</Alarm>\n" +
			"\t\t\t</message>\n" +
			"\t\t</notify>\n" +
			"\t</soapenv:Body>\n" +
			"</soapenv:Envelope>";

	public static void main(String[] args) {
		//SpringApplication.run(OadServiceApplication.class, args);
		XmlMapper mapper = new XmlMapper();

		//mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		//mapper.enable(JsonParser.Feature.IGNORE_UNDEFINED);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		//mapper.disable(Feature.F)
		try {
			OadNotification notification = mapper.readValue(newOntNotification, OadNotification.class);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
