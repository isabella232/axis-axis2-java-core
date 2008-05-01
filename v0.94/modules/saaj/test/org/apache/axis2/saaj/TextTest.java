package org.apache.axis2.saaj;

import junit.framework.TestCase;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.Text;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TextTest extends TestCase {

    public TextTest(String name) {
        super(name);
    }

    //Test SAAJ addTextNode performance
    public void testAddTextNode() throws Exception {
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage();
        SOAPBody body = message.getSOAPBody();

        // Create the base element
        Name bodyName = soapFactory.createName("VBGenReceiver", "xsi",
                                               "http://www.w3.org/2001/XMLSchema-instance");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        // Create the MetaData Tag
        Name name = soapFactory.createName("MetaData");
        SOAPElement metaData = bodyElement.addChildElement(name);

        //Create the SKey Tag
        name = soapFactory.createName("SKey");
        SOAPElement sKey = metaData.addChildElement(name);
        sKey.addTextNode("SKEY001");

        //Create Object Tag
        name = soapFactory.createName("Object");
        SOAPElement object = bodyElement.addChildElement(name);

        //Create Book ID Tag
        name = soapFactory.createName("BookID");
        SOAPElement bookID = object.addChildElement(name);
        bookID.addTextNode("BookID002");

        //Create OrderID tag
        name = soapFactory.createName("OrderID");
        SOAPElement orderID = object.addChildElement(name);
        orderID.addTextNode("OrderID003");

        //create PurchaseID tage
        name = soapFactory.createName("PurchaseID");
        SOAPElement purchaseID = object.addChildElement(name);
        purchaseID.addTextNode("PurchaseID005");

        //create LanguageID Tag
        name = soapFactory.createName("LanguageID");
        SOAPElement languageID = object.addChildElement(name);
        languageID.addTextNode("LanguageID004");

        //create LanguageID Tag
        name = soapFactory.createName("LanguageName");
        SOAPElement languageName = object.addChildElement(name);
        languageName.addTextNode("LanguageName006");

        //create LanguageID Tag
        name = soapFactory.createName("Title");
        SOAPElement title = object.addChildElement(name);
        title.addTextNode("Title007");

        //create LanguageID Tag
        name = soapFactory.createName("Author");
        SOAPElement author = object.addChildElement(name);
        author.addTextNode("Author008");

        //create LanguageID Tag
        name = soapFactory.createName("Format");
        SOAPElement format = bodyElement.addChildElement(name);

        //create LanguageID Tag
        name = soapFactory.createName("Type");
        SOAPElement formatType = format.addChildElement(name);
        formatType.addTextNode("Type009");

        //create LanguageID Tag
        name = soapFactory.createName("Delivery");
        SOAPElement delivery = bodyElement.addChildElement(name);

        //create LanguageID Tag
        name = soapFactory.createName("Name");
        SOAPElement delName = delivery.addChildElement(name);
        delName.addTextNode("Name010");

        //create LanguageID Tag
        name = soapFactory.createName("Address1");
        SOAPElement address1 = delivery.addChildElement(name);
        address1.addTextNode("Address1011");

        //create LanguageID Tag
        name = soapFactory.createName("Address2");
        SOAPElement address2 = delivery.addChildElement(name);
        address2.addTextNode("Address2012");

        //create LanguageID Tag
        name = soapFactory.createName("City");
        SOAPElement city = delivery.addChildElement(name);
        city.addTextNode("City013");

        //create LanguageID Tag
        name = soapFactory.createName("State");
        SOAPElement state = delivery.addChildElement(name);
        state.addTextNode("State014");

        //create LanguageID Tag
        name = soapFactory.createName("PostalCode");
        SOAPElement postalCode = delivery.addChildElement(name);
        postalCode.addTextNode("PostalCode015");

        System.out.println("The message is:\n");
        message.writeTo(System.out);
        System.out.flush();
    }

    public void testComment() throws SOAPException, IOException {

        String xmlString = "<?xml version='1.0' encoding='utf-8'?> " +
                           "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                           "<soapenv:Header></soapenv:Header>" +
                           "<soapenv:Body>" +
                           "<Node:abc xmlns:Node=\"http://www.simpletest.org\">" +
                           "This is some text" +
                           "<!--This is comment-->This is other text" +
                           "<!--This is another comment-->This is some other text" +
                           "</Node:abc>" +
                           "</soapenv:Body>" +
                           "</soapenv:Envelope>";

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage message =
                mf.createMessage(new MimeHeaders(), new ByteArrayInputStream(xmlString.getBytes()));

        SOAPBody body = message.getSOAPBody();
        Node bodyElement = body.getFirstChild();
        NodeList textNodes = bodyElement.getChildNodes();

        assertEquals(5, textNodes.getLength());

        for (int i = 0; i < textNodes.getLength(); i++) {
            Node nde = textNodes.item(i);
            boolean isComment;
            if (nde instanceof Text) {
                isComment = ((Text) nde).isComment();
                if (i == 1)
                    assertEquals(true, isComment);
                else
                    assertEquals(false, isComment);
            }
        }
    }
}