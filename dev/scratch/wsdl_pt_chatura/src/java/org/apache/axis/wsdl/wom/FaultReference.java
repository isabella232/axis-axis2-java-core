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
 */
package org.apache.axis.wsdl.wom;

/**
 * @author chathura@opensource.lk
 *
 */
public interface FaultReference {
    /**
     * Returns the direction of the Fault according the MEP
     * @return
     */
    public String getDirection();

    /**
     * Sets the direction of the Fault.
     * @param direction
     */
    public void setDirection(String direction);

    public String getMessageLabel();

    public void setMessageLabel(String messageLabel);

    /**
     * Returns the Fault reference.
     * @return
     */
    public String getRef();

    /**
     * Sets the Fault reference.
     * @param ref
     */
    public void setRef(String ref);
}
