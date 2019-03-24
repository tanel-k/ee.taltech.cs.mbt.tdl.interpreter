package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STGroupFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtaGenerator {
	public static String generate(UtaSystem system) {
		// Use maps to set up a context tree -> feed context tree to template
		// Template to contain no logic: it should follow the expected context structure and format the code according to internal logic
		STGroup group = new STGroupFile("template-source/uta-generators/UtaLanguage.stg");
		ST st = group.getInstanceOf("testTemplate");
		//List<ParameterDeclaration> paramDecls = system.getTemplateMap().get("test").getParameters();
		Map<String, Object> map = new HashMap<>();
		map.put("prop", "value");
		map.put("nestedMap", new HashMap<>());
		((HashMap) map.get("nestedMap")).put("nestedProp", "nestedValue");
		st.add("map", map);
		return st.render(); // yields "int x = 0;"
	}
}
