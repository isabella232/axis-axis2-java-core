package org.apache.axis2;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.Handler;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.namespace.QName;
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

public class ModuleHandler1  extends AbstractHandler implements Handler {
    private static final long serialVersionUID = 8180024686236178934L;
	private Log log = LogFactory.getLog(getClass());
    private String message;
    private QName name;
    public ModuleHandler1() {
       this.message = "inside invalid module";
    }
    public QName getName() {
        return name;
    }

    public void invoke(MessageContext msgContext) throws AxisFault {
        log.info("I am " + message + " Handler Running :)");
    }

    public void revoke(MessageContext msgContext) {
        log.info("I am " + message + " Handler Running :)");
    }

    public void setName(QName name) {
        this.name = name;
    }

}
