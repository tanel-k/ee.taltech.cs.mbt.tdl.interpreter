package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNta;
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

public class NtaMarshaller {
	private static final String SAX_FEATURE_LOAD_DTD_GRAMMAR = "http://apache.org/xml/features/nonvalidating/load-dtd-grammar";
	private static final String SAX_FEATURE_LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";

	public static class NtaMarshallingException extends Exception {
		public NtaMarshallingException(String msg, Throwable t) {
			super(msg, t);
		}

		public NtaMarshallingException(Throwable t) {
			super(t);
		}
	}

	private static SAXSource getSaxSource(InputStream in) throws SAXException, ParserConfigurationException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setFeature(SAX_FEATURE_LOAD_DTD_GRAMMAR, false);
		parserFactory.setFeature(SAX_FEATURE_LOAD_EXTERNAL_DTD, false);
		XMLReader reader = parserFactory.newSAXParser().getXMLReader();
		return new SAXSource(reader, new InputSource(in));
	}

	public static XmlNodeNta unmarshal(InputStream in) throws NtaMarshallingException {
		try {
			SAXSource saxSource = getSaxSource(in);
			JAXBContext jaxbCtx = JAXBContext.newInstance(XmlNodeNta.class);
			Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
			return (XmlNodeNta) unmarshaller.unmarshal(saxSource);
		} catch (JAXBException ex) {
			throw new NtaMarshallingException("Unmarshalling failed.", ex);
		} catch (SAXException ex) {
			throw new NtaMarshallingException("Unexpected SAX-related error.", ex);
		} catch (ParserConfigurationException ex) {
			throw new NtaMarshallingException("Unexpected SAX configuration error.", ex);
		} catch (Throwable t) {
			throw new NtaMarshallingException(t);
		}
	}

	public static void marshal(XmlNodeNta ntaSystem, OutputStream out) throws NtaMarshallingException {
		try {
			JAXBContext jaxbCtx = JAXBContext.newInstance(XmlNodeNta.class);
			Marshaller marshaller = jaxbCtx.createMarshaller();
			marshaller.marshal(ntaSystem, out);
		} catch (JAXBException ex) {
			throw new NtaMarshallingException("Marshalling failed.", ex);
		} catch (Throwable t) {
			throw new NtaMarshallingException(t);
		}
	}
}
