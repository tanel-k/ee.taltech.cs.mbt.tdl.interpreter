package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.AbsSExpressionNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

public class DeclarationTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IDeclarationVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitVariableDeclaration(VariableDeclaration decl) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("VarDecl"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new TypeTransformer().transform(decl.getType()))
							.addChild(new SExpressionStringNode().setString(decl.getIdentifier().toString()))
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(decl.getInitializer()))
					);
		}

		@Override
		public SExpressionSequenceNode visitTypeDeclaration(TypeDeclaration decl) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TypeDecl"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new TypeTransformer().transform(decl.getType()))
							.addChild(new SExpressionStringNode().setString(decl.getIdentifier().toString()))
					);
		}

		@Override
		public SExpressionSequenceNode visitTemplateInstantiation(TemplateInstantiation decl) {
			SExpressionSequenceNode arguments = new SExpressionSequenceNode();
			for (AbsExpression argument : decl.getArguments()) {
				arguments.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(argument));
			}
			SExpressionSequenceNode parameters = new SExpressionSequenceNode();
			for (ParameterDeclaration parameter : decl.getParameters()) {
				parameters.addChild((SExpressionSequenceNode) new ParameterTransformer().transform(parameter));
			}
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TemplateInst"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(decl.getNewTemplateName().toString()))
							.addChild(parameters)
					)
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(decl.getSourceTemplateName().toString()))
							.addChild(arguments)
					);
		}

		@Override
		public SExpressionSequenceNode visitFunctionDeclaration(FunctionDeclaration decl) {
			SExpressionSequenceNode parameters = new SExpressionSequenceNode();
			for (ParameterDeclaration parameter : decl.getParameters()) {
				parameters.addChild((SExpressionSequenceNode) new ParameterTransformer().transform(parameter));
			}
			AbsSExpressionNode type = (AbsSExpressionNode) (decl.getValueType() != null
					? new BaseTypeTransformer().transform(decl.getValueType())
					: new SExpressionStringNode().setString("void"));
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("FuncDecl"))
					.addChild(new SExpressionSequenceNode()
							.addChild(type)
							.addChild(new SExpressionStringNode().setString(decl.getName().toString()))
							.addChild(parameters)
							.addChild((SExpressionSequenceNode) new StatementTransformer().transform(decl.getStatementBlock()))
					);
		}

		@Override
		public SExpressionSequenceNode visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("ChannelPriorityDecl"));
			// TODO
			/*
			decl.getPrioritySequence();
			return null;
			*/
		}

		@Override
		public SExpressionSequenceNode visitVariableDeclarationGroup(VariableDeclarationGroup decl) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("VariableDecl"));
			// TODO
			/*
			decl.getBaseTypeExtensionMap();
			decl.getInitializerMap();
			return null;
			*/
		}

		@Override
		public SExpressionSequenceNode visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TypeDeclGroup"));
			// TODO
			/*
			decl.getBaseTypeExtensionMap();
			return null;
			*/
		}
	}

	@Override
	public Object transform(Object in) {
		AbsDeclarationStatement declarationStatement = (AbsDeclarationStatement) in;
		return declarationStatement.accept(new TransformerVisitor());
	}
}
