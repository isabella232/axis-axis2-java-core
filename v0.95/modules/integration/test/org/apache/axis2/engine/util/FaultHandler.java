package org.apache.axis2.engine.util;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.ws.commons.om.OMAbstractFactory;
import org.apache.ws.commons.om.OMElement;
import org.apache.ws.commons.soap.SOAP12Constants;
import org.apache.ws.commons.soap.SOAPFactory;
import org.apache.ws.commons.soap.SOAPFaultCode;
import org.apache.ws.commons.soap.SOAPFaultDetail;
import org.apache.ws.commons.soap.SOAPFaultReason;
import org.apache.ws.commons.soap.SOAPFaultText;
import org.apache.ws.commons.soap.SOAPFaultValue;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

public class FaultHandler extends AbstractHandler {
    public static final String FAULT_REASON = "This is a test fault message which happened suddenly";
    public static final String DETAIL_MORE_INFO = "This error is a result due to a fake problem in Axis2 engine. Do not worry ;)";
    public static final String M_FAULT_EXCEPTION = "m:FaultException";

    public void invoke(MessageContext msgContext) throws AxisFault {
        // this handler will be used to check the fault handling of Axis2.
        // this will create some dummy faults and send

        SOAPFactory soapFac = msgContext.isSOAP11() ? OMAbstractFactory.getSOAP11Factory() : OMAbstractFactory.getSOAP12Factory();

        // I have a sudden fake error ;)

        SOAPFaultCode soapFaultCode = soapFac.createSOAPFaultCode();
        soapFaultCode.declareNamespace("http://someuri.org", "m");
        SOAPFaultValue soapFaultValue = soapFac.createSOAPFaultValue(soapFaultCode);
        soapFaultValue.setText(M_FAULT_EXCEPTION);

        SOAPFaultText soapFaultText = soapFac.createSOAPFaultText();
        soapFaultText.setLang("en");
        soapFaultText.setText(FAULT_REASON);
        SOAPFaultReason soapFaultReason = soapFac.createSOAPFaultReason();
        soapFaultReason.setSOAPText(soapFaultText);

        OMElement detailEntry = soapFac.createOMElement("MoreInfo", null);
        detailEntry.setText(DETAIL_MORE_INFO);
        SOAPFaultDetail faultDetail = soapFac.createSOAPFaultDetail();
        faultDetail.addDetailEntry(detailEntry);

        msgContext.setProperty(SOAP12Constants.SOAP_FAULT_CODE_LOCAL_NAME, soapFaultCode);
        msgContext.setProperty(SOAP12Constants.SOAP_FAULT_REASON_LOCAL_NAME, soapFaultReason);
        msgContext.setProperty(SOAP12Constants.SOAP_FAULT_DETAIL_LOCAL_NAME, faultDetail);

        throw new AxisFault("A dummy exception has occurred");

    }
}