package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;

public class SystemDefinitionToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		SystemDefinition systemDefinition = (SystemDefinition) in;
		systemDefinition.getDeclarations();
		systemDefinition.getProgressMeasureExpressions();
		systemDefinition.getSystemLine();
		// FIXME.
		throw new UnsupportedOperationException();
	}
}
