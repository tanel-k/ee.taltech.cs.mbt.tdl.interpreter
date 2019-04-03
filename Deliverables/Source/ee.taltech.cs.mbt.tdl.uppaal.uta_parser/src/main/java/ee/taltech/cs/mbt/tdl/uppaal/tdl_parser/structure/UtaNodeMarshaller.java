package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.internal.bind.marshaller.DumbEscapeHandler;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.InputStream;
import java.io.OutputStream;

public class UtaNodeMarshaller {
	private static final String SAX_FEATURE_LOAD_DTD_GRAMMAR = "http://apache.org/xml/features/nonvalidating/load-dtd-grammar";
	private static final String SAX_FEATURE_LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";

	public static class MarshallingException extends Exception {
		public MarshallingException(String msg, Throwable t) {
			super(msg, t);
		}
	}

	private static SAXSource getSaxSource(InputStream in) throws SAXException, ParserConfigurationException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setFeature(SAX_FEATURE_LOAD_DTD_GRAMMAR, false);
		parserFactory.setFeature(SAX_FEATURE_LOAD_EXTERNAL_DTD, false);
		XMLReader reader = parserFactory.newSAXParser().getXMLReader();
		return new SAXSource(reader, new InputSource(in));
	}

	public static UtaNode unmarshal(InputStream in) throws MarshallingException {
		try {
			SAXSource saxSource = getSaxSource(in);
			JAXBContext jaxbCtx = JAXBContext.newInstance(UtaNode.class);
			Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
			return (UtaNode) unmarshaller.unmarshal(saxSource);
		} catch (JAXBException ex) {
			throw new MarshallingException("Unmarshalling failed: JAXB exception.", ex);
		} catch (SAXException ex) {
			throw new MarshallingException("Unmarshalling failed: SAX-related exception.", ex);
		} catch (ParserConfigurationException ex) {
			throw new MarshallingException("Unmarshalling failed: SAX configuration exception.", ex);
		} catch (Throwable t) {
			throw new MarshallingException("Unmarshalling failed: unexpected exception.", t);
		}
	}

	public static void marshal(UtaNode utaNode, OutputStream out) throws MarshallingException {
		try {
			JAXBContext jaxbCtx = JAXBContext.newInstance(UtaNode.class);
			Marshaller marshaller = jaxbCtx.createMarshaller();
			// Prevent escaping \r:
			marshaller.setProperty(CharacterEscapeHandler.class.getName(), DumbEscapeHandler.theInstance);
			marshaller.marshal(utaNode, out);
		} catch (JAXBException ex) {
			throw new MarshallingException("Marshalling failed: JAXB exception.", ex);
		} catch (Throwable t) {
			throw new MarshallingException("Marshalling failed: unexpected exception", t);
		}
	}
}
