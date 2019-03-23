package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller.NtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNta;
import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

public class Test {
	public static void main(String... args) throws NtaMarshallingException {
		InputStream stream = Test.class.getResourceAsStream("sample-system.xml");
		XmlNodeNta node = NtaMarshaller.unmarshal(stream);
		NtaValidator.newInstance(node).validate();
	}
}
