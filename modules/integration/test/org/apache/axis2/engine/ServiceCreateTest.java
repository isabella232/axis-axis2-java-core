package org.apache.axis2.engine;

import junit.framework.TestCase;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.deployment.util.Utils;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.integration.UtilServer;
import org.apache.axis2.om.OMElement;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;
import java.util.ArrayList;
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
*
*/

public class ServiceCreateTest extends TestCase {

    ConfigurationContext configContext;
    ConfigurationContext clinetConfigurationctx;


    protected void setUp() throws Exception {
        UtilServer.start();
        configContext = UtilServer.getConfigurationContext();
        ConfigurationContextFactory factory = new ConfigurationContextFactory();
        clinetConfigurationctx = factory.createConfigurationContextFromFileSystem("target/test-resources/integrationRepo",null);
    }

    public void testServiceCreate() throws AxisFault {
        AxisConfiguration axisConfig = configContext.getAxisConfiguration();
        AxisService service = Utils.createService("org.apache.axis2.engine.MyService", axisConfig);
        assertNotNull(service);
        axisConfig.addService(service);
        assertEquals("MyService", service.getName());
        assertNotNull(service.getOperation(new QName("add")));
        assertNotNull(service.getOperation(new QName("putValue")));
        assertNotNull(axisConfig.getService("MyService"));
        service.printWSDL(System.out, "http://127.0.0.1:8080/axis2/services/");

        RPCServiceClient client = new RPCServiceClient(clinetConfigurationctx, null);

        EndpointReference targetEPR = new EndpointReference(
                "http://127.0.0.1:" + (UtilServer.TESTING_PORT)
                        + "/axis2/services/MyService/add");
        Options options = new Options();

        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        client.setOptions(options);
        ArrayList args = new ArrayList();
        args.add("100");
        args.add("200");

        OMElement response = client.invokeBlocking(new QName("add"), args.toArray());
        assertEquals(Integer.parseInt(response.getFirstElement().getText()), 300);
    }
}
