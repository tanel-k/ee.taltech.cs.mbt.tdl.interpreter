package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.ProcessReferenceGroup;

public class SystemDefinitionToSExprTestTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		SystemDefinition systemDefinition = (SystemDefinition) in;
		SExpressionSequenceNode systemLineSeq = new SExpressionSequenceNode();
		for (ProcessReferenceGroup group : systemDefinition.getSystemLine()) {
			SExpressionSequenceNode groupNode = new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("GROUP"));
			SExpressionSequenceNode groupSeq = new SExpressionSequenceNode();
			groupNode.addChild(groupSeq);
			for (Identifier identifier : group) {
				groupSeq.addChild(new SExpressionStringNode().setString(identifier.toString()));
			}
			systemLineSeq.addChild(groupNode);
		}
		return new SExpression().setRoot(new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("SYSDEF"))
				.addChild(new SExpressionSequenceNode()
						.addChild((SExpression) new DeclarationListToSExprTestTransformer().transform(systemDefinition.getDeclarations()))
						.addChild((SExpression) new ExpressionListToSExprTestTransformer().transform(systemDefinition.getProgressMeasureExpressions()))
						.addChild(new SExpressionSequenceNode()
								.addChild(new SExpressionStringNode().setString("SYSLINE"))
								.addChild(systemLineSeq)
						)
				)
		);
	}
}
