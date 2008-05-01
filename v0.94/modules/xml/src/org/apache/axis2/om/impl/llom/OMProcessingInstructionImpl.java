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

package org.apache.axis2.om.impl.llom;

import org.apache.axis2.om.OMContainer;
import org.apache.axis2.om.OMElement;
import org.apache.axis2.om.OMException;
import org.apache.axis2.om.OMNode;
import org.apache.axis2.om.OMProcessingInstruction;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class OMProcessingInstructionImpl extends OMNodeImpl implements OMProcessingInstruction {
    protected String target;
    protected String value;

    /**
     * Constructor OMProcessingInstructionImpl.
     *
     * @param parentNode
     * @param target
     * @param value
     */
    public OMProcessingInstructionImpl(OMContainer parentNode, String target, String value) {
        super(parentNode);
        this.target = (target == null) ? null : target.trim();
        this.value = (value == null) ? null : value.trim();
        nodeType = OMNode.PI_NODE;
    }

    /**
     * Constructor OMProcessingInstructionImpl.
     *
     * @param parentNode
     */
    public OMProcessingInstructionImpl(OMContainer parentNode) {
        this(parentNode, null, null);
    }

    /**
     * Serializes the node with caching.
     *
     * @param omOutput
     * @throws XMLStreamException
     * @see #serialize(org.apache.axis2.om.impl.OMOutputImpl)
     */
    public void serialize(org.apache.axis2.om.impl.OMOutputImpl omOutput) throws XMLStreamException {
        XMLStreamWriter writer = omOutput.getXmlStreamWriter();
        writer.writeProcessingInstruction(this.target+" ", this.value);
    }

    /**
     * Serializes the node without caching.
     *
     * @param omOutput
     * @throws XMLStreamException
     * @see #serializeAndConsume(org.apache.axis2.om.impl.OMOutputImpl)
     */
    public void serializeAndConsume(org.apache.axis2.om.impl.OMOutputImpl omOutput) throws XMLStreamException {
        serialize(omOutput);
    }

    /**
     * Gets the value of this Processing Instruction.
     *
     * @return string
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the target of this Processing Instruction.
     *
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Gets the target of this Processing Instruction.
     *
     * @return Returns String.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of this Processing Instruction.
     *
     * @param text
     */
    public void setValue(String text) {
        this.value = text;
    }

    /**
     * Discards this node.
     *
     * @throws OMException
     */
    public void discard() throws OMException {
        if (done) {
            this.detach();
        } else {
            builder.discard((OMElement) this.parent);
        }
    }
}