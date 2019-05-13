package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.StructuredVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IInitializerVisitor;

public class VariableInitializerTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IInitializerVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitFlatInitializer(FlatVariableInitializer init) {
			return (SExpressionSequenceNode) new ExpressionTransformer().transform(init.getExpression());
		}

		@Override
		public SExpressionSequenceNode visitStructuredInitializer(StructuredVariableInitializer init) {
			SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
			for (AbsVariableInitializer initializer : init.getInitializers()) {
				sequenceNode.addChild(initializer.accept(this));
			}
			return sequenceNode;
		}
	}

	@Override
	public Object transform(Object in) {
		return ((AbsVariableInitializer) in).accept(new TransformerVisitor());
	}
}
