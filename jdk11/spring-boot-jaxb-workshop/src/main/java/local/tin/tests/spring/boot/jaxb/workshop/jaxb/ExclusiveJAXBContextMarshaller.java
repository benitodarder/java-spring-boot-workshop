package local.tin.tests.spring.boot.jaxb.workshop.jaxb;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import org.springframework.stereotype.Component;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author benito.darder
 */
@Component
public class ExclusiveJAXBContextMarshaller {

    public static final String JAXB_XML_ENCODING = "UTF-8";


    public String toString(Object pObject) throws Exception {
        try {
            Class klass = pObject.getClass();
            JAXBContext jAXBContext = JAXBContext.newInstance(klass);
            java.io.StringWriter sw = new StringWriter();
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, JAXB_XML_ENCODING);
            marshaller.marshal(new JAXBElement(new QName(klass.getSimpleName()), klass, pObject), sw);
            return sw.toString();
        } catch (JAXBException ex) {
            throw new Exception(ex.getLocalizedMessage(), ex);
        }
    }

    public Object toObject(String xml, Class klass) throws Exception {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(klass);

            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            Document doc = getDocumentFromXMLString(xml);
            DOMSource ds = new DOMSource(doc);

            JAXBElement jAXBElement = unmarshaller.unmarshal(ds, klass);
            return jAXBElement.getValue();
        } catch (JAXBException | SAXException | IOException | ParserConfigurationException ex) {
            throw new Exception(ex.getLocalizedMessage(), ex);
        }
    }

    private Document getDocumentFromXMLString(String xml) throws SAXException, IOException, ParserConfigurationException, org.xml.sax.SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        Document doc = dBuilder.parse(is);
        return doc;
    }

    public Object toObject(String xml, String className) throws Exception {
        Class klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getLocalizedMessage(), ex);
        }
        return toObject(xml, klass);
    }
}
