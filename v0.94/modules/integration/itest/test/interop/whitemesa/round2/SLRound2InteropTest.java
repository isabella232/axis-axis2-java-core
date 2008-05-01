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

package test.interop.whitemesa.round2;

import org.apache.axis2.AxisFault;
import org.apache.axis2.soap.SOAPEnvelope;
import test.interop.whitemesa.WhiteMesaIneterop;
import test.interop.whitemesa.round2.util.GroupbEcho2DStringArrayUtil;
import test.interop.whitemesa.round2.util.GroupbEchoNestedArrayUtil;
import test.interop.whitemesa.round2.util.GroupbEchoNestedStructUtil;
import test.interop.whitemesa.round2.util.GroupbEchoSimpleTypesAsStructUtil;
import test.interop.whitemesa.round2.util.GroupbEchoStructAsSimpleTypesUtil;
import test.interop.whitemesa.round2.util.GroupcBase64Util;
import test.interop.whitemesa.round2.util.GroupcBooleanUtil;
import test.interop.whitemesa.round2.util.GroupcEchoStringUtil;
import test.interop.whitemesa.round2.util.GroupcFloatArrayUtil;
import test.interop.whitemesa.round2.util.GroupcFloatUtil;
import test.interop.whitemesa.round2.util.GroupcHexBinaryUtil;
import test.interop.whitemesa.round2.util.GroupcIntegerArrayUtil;
import test.interop.whitemesa.round2.util.GroupcIntergerUtil;
import test.interop.whitemesa.round2.util.GroupcStringArrayUtil;
import test.interop.whitemesa.round2.util.GroupcStructArrayUtil;
import test.interop.whitemesa.round2.util.GroupcStructUtil;
import test.interop.whitemesa.round2.util.GroupcVoidUtil;
import test.interop.whitemesa.round2.util.Round2EchoBase64ClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoBooleanClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoDateClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoDecimalClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoFloatArrayClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoFloatClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoHexBinaryClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoIntegerArrayclientUtil;
import test.interop.whitemesa.round2.util.Round2EchoIntegerClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoStringArrayClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoStringclientUtil;
import test.interop.whitemesa.round2.util.Round2EchoStructArrayClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoStructClientUtil;
import test.interop.whitemesa.round2.util.Round2EchoVoidClientUtil;
import test.interop.whitemesa.round2.util.SunRound2ClientUtil;

import java.io.File;

/**
 * class SLRound2InteropTest
 * To test Interoperability Axis2 clients vs Soap:Lite Server, Round2
 * WSDL:-
 * "base"     http://services.soaplite.com/interop2.wsdl
 * "Group B"  http://services.soaplite.com/InteropTestB.wsdl
 * "Group C"  http://services.soaplite.com/InteropTestC.wsdl
 */

//todo All tests failed !!!

public class SLRound2InteropTest extends WhiteMesaIneterop {

    SOAPEnvelope retEnv = null;
    boolean success = false;
    File file = null;
    String url = "";
    String soapAction = "";
    String FS = System.getProperty("file.separator");
    String resFilePath = "interop/whitemesa/round2/";
    String tempPath = "";
    SunRound2ClientUtil util;
    boolean results;
    
    public void testChack(){
            //just addding a test case , since all the tase casea are fail
        }
    

    /**
     * Round2
     * Group Base
     * operation echoString
     */
    public void testR2BaseEchoString() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoStringclientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseStringRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoStringArray
     */
    public void testR2BaseEchoStringArray() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoStringArrayClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "SunBaseStringArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoInteger
     */
    public void testR2BaseEchoInteger() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoIntegerClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseIntegerRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoIntegerArray
     */
    public void testR2BaseEchoIntegerArray() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoIntegerArrayclientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseIntegerArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoFloat
     */
    public void testR2BaseEchoFloat()  throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoFloatClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseFloatRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoFloatArray
     */
    public void testR2BaseEchoFloatArray()  throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoFloatArrayClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseFloatArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoStruct
     */
    public void testRBaseEchoStruct() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "";

        util = new Round2EchoStructClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseStructRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoStructArray
     */
    public void testR2BaseEchoStructArray() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoStructArrayClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseStructArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoVoid
     */
    public void testR2BaseEchoVoid() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoVoidClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseVoidRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoBase64
     */
    public void testR2BaseEchoBase64() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoBase64ClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseBase64Res.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoBase64
     */
    public void testR2BaseEchoDate() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoDateClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseDateRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }


    /**
     * Round2
     * Group Base
     * operation echoHexBinary
     */
    public void testR2BaseEchoHexBinary() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoHexBinaryClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseHexBinaryRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoDecimal
     */
    public void testR2BaseEchoDecimal() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoDecimalClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseDecimalRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group Base
     * operation echoBoolean
     */
    public void testR2BaseEchoBoolean() throws AxisFault  {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new Round2EchoBooleanClientUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunBaseBooleanRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group B
     * operation echoStructAsSimpleTypes
     */
    public void testR2GBEchoStructAsSimpleTypes() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupbEchoStructAsSimpleTypesUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunGroupbStructAsSimpleTypesRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group B
     * operation echoSimpleTypesAsStruct
     */
    public void testR2GBEchoSimpleTypesAsStruct() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupbEchoSimpleTypesAsStructUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunGroupbSimpletypesAsStructRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group B
     * operation echo2DStringArray
     */
    public void testR2GBEcho2DStringArray() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupbEcho2DStringArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunGroupb2DStringArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group B
     * operation echoNestedStruct
     */
    public void testR2GBEchoNestedStruct() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupbEchoNestedStructUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunGroupbNestedStructRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group B
     * operation echoNestedArray
     */
    public void testR2GBEchoNestedArray() throws AxisFault {
        url = "http://localhost:8010/interop.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupbEchoNestedArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "sunGroupbNestedArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoString
     */
    public void testR2GCEchoString() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcEchoStringUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcEchoStringRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoInterger
     */
    public void testR2GCEchoInterger() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcIntergerUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcIntergerRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoStringArray
     */
    public void testR2GCEchoStringArray() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcStringArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcStringArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoIntergerArray
     */
    public void testR2GCEchoIntergerArray() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcIntegerArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcIntegerArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoFloat
     */
    public void testR2GCEchoFloat() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcFloatUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcFloatRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoFloatArray
     */
    public void testR2GCEchoFloatArray() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcFloatArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcFloatArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoStruct
     */
    public void testR2GCEchoStruct() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcStructUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcStructRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoStructArray
     */
    public void testR2GCEchoStructArray() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcStructArrayUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcStructArrayRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoVoid
     */
    public void testR2GCEchoVoid() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcVoidUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcVoidRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoBase64
     */
    public void testR2GCEchoBase64() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcBase64Util();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcBase64Res.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoHexBinary
     */
    public void testR2GCEchoHexBinary() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcHexBinaryUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcHexBinaryRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

    /**
     * Round2
     * Group C
     * operation echoBoolean
     */
    public void testR2GCEchoBoolean() throws AxisFault {
        url = "http://localhost:8010/interopC.cgi";
        soapAction = "http://soapinterop.org/";

        util = new GroupcBooleanUtil();
        retEnv = SunRound2Client.sendMsg(util, url, soapAction);
        tempPath = resFilePath + "GroupcBooleanRes.xml";
        results = compare(retEnv, tempPath);
        assertTrue(results);
    }

}
