package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

public class Test {
	public static void main(String... args) {
		STGroupDir.verbose = true;
		STGroup group = new STGroupDir(
		"template-source/uta-generators");
		ST st = group.getInstanceOf("type");
		st.add("typePrefix", "something");
		st.add("typeIdentifier", "test");
		String result = st.render();
		System.out.println(result);
	}
}
