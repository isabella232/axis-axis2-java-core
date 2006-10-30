/*
 * Copyright 2004,2005 The Apache Software Foundation.
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
 */

package sample.soapwithattachments.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMText;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.util.CommandLineOption;
import org.apache.axis2.util.CommandLineOptionParser;
import org.apache.axis2.util.OptionsValidator;
import org.apache.axis2.wsdl.WSDLConstants;

public class SWAClient {

	private static EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/swaSample");

	public static void main(String[] args) throws Exception {
		CommandLineOptionParser optionsParser = new CommandLineOptionParser(
				args);
		List invalidOptionsList = optionsParser
				.getInvalidOptions(new OptionsValidator() {
					public boolean isInvalid(CommandLineOption option) {
						String optionType = option.getOptionType();
						return !("dest".equalsIgnoreCase(optionType) || "file"
								.equalsIgnoreCase(optionType));
					}
				});

		if ((invalidOptionsList.size() > 0) || (args.length != 4)) {
			// printUsage();
			System.out.println("Invalid Parameters.  Usage -file <file to be send> -dest <destination file>");
			return;
		}

		Map optionsMap = optionsParser.getAllOptions();

		CommandLineOption fileOption = (CommandLineOption) optionsMap
				.get("file");
		CommandLineOption destinationOption = (CommandLineOption) optionsMap
				.get("dest");
		File file = new File(fileOption.getOptionValue());
		if (file.exists())
			transferFile(file, destinationOption.getOptionValue());
		else
			throw new FileNotFoundException();
	}

	public static void transferFile(File file, String destinationFile)
			throws Exception {

		Options options = new Options();
		options.setTo(targetEPR);
		options.setProperty(Constants.Configuration.ENABLE_SWA,
				Constants.VALUE_TRUE);
		options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
		options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
		options.setTimeOutInMilliSeconds(100000);
//		options.setAction(Constants.AXIS2_NAMESPACE_URI + "/"
//				+ operationName.getLocalPart());
		options.setTo(targetEPR);
		options.setAction("urn:uploadFile");

		ConfigurationContext configContext = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(
						"../../repository", null);

		ServiceClient sender = new ServiceClient(configContext, null);
		sender.setOptions(options);
		OperationClient mepClient = sender
				.createClient(ServiceClient.ANON_OUT_IN_OP);

		MessageContext mc = new MessageContext();
		FileDataSource fileDataSource = new FileDataSource(file);

		// Create a dataHandler using the fileDataSource. Any implementation of
		// javax.activation.DataSource interface can fit here.
		DataHandler dataHandler = new DataHandler(fileDataSource);
		String attachmentID = mc.addAttachment(dataHandler);
		
		SOAPFactory fac = OMAbstractFactory.getSOAP11Factory();
		SOAPEnvelope env = fac.getDefaultEnvelope();

		OMNamespace omNs = fac.createOMNamespace("http://service.soapwithattachments.sample/xsd","swa");
		OMElement nameEle = fac.createOMElement("param0", omNs);
		nameEle.setText(destinationFile);
		OMElement idEle = fac.createOMElement("param1", omNs);
		idEle.setText(attachmentID);
		
		env.getBody().addChild(nameEle);
		env.getBody().addChild(idEle);
		mc.setEnvelope(env);

		mepClient.addMessageContext(mc);
		mepClient.execute(true);
		MessageContext response = mepClient
				.getMessageContext(WSDLConstants.MESSAGE_LABEL_IN_VALUE);
	}
}