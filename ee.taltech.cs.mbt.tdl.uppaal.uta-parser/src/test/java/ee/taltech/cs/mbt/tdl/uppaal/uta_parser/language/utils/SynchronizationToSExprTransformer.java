package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.ExpressionTransformer;

public class SynchronizationToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		Synchronization synchronization = (Synchronization) in;
		return new SExpression().setRoot(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("SYNCH"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(synchronization.isActiveSync() ? "INPUT" : "OUTPUT"))
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(synchronization.getExpression()))
					)
		);
	}
}
