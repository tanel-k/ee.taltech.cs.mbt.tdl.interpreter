package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.AbsSExpressionNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.streams.StreamUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.ChannelIdentifierReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.DefaultChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IChannelReferenceVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

import java.util.stream.Stream;

public class DeclarationTestTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IDeclarationVisitor<SExpressionSequenceNode> {
		private SExpressionSequenceNode wrap(SExpressionSequenceNode seqNode) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("DECL"))
					.addChild(seqNode);
		}

		@Override
		public SExpressionSequenceNode visitVariableDeclaration(VariableDeclaration decl) {
			SExpressionSequenceNode initSeq = null;
			if (decl.getInitializer() != null) {
				initSeq = (SExpressionSequenceNode) new VariableInitializerTestTransformer().transform(decl.getInitializer());
			}
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("VARDECL"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new TypeTestTransformer().transform(decl.getType()))
							.addChild(new SExpressionStringNode().setString(decl.getIdentifier().toString()))
							.addChild(ObjectUtils.defaultObject(initSeq, SExpressionSequenceNode::new))
					)
			);
		}

		@Override
		public SExpressionSequenceNode visitTypeDeclaration(TypeDeclaration decl) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TYPEDECL"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new TypeTestTransformer().transform(decl.getType()))
							.addChild(new SExpressionStringNode().setString(decl.getIdentifier().toString()))
					)
			);
		}

		@Override
		public SExpressionSequenceNode visitTemplateInstantiation(TemplateInstantiation decl) {
			SExpressionSequenceNode arguments = new SExpressionSequenceNode();
			for (AbsExpression argument : decl.getArguments()) {
				arguments.addChild((SExpressionSequenceNode) new ExpressionTestTransformer().transform(argument));
			}
			SExpressionSequenceNode parameters = new SExpressionSequenceNode();
			for (ParameterDeclaration parameter : decl.getParameters()) {
				parameters.addChild((SExpressionSequenceNode) new ParameterTestTransformer().transform(parameter));
			}
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TEMPLATEINST"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(decl.getNewTemplateName().toString()))
							.addChild(parameters)
					)
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(decl.getSourceTemplateName().toString()))
							.addChild(arguments)
			));
		}

		@Override
		public SExpressionSequenceNode visitFunctionDeclaration(FunctionDeclaration decl) {
			SExpressionSequenceNode parameters = new SExpressionSequenceNode();
			for (ParameterDeclaration parameter : decl.getParameters()) {
				parameters.addChild((SExpressionSequenceNode) new ParameterTestTransformer().transform(parameter));
			}
			AbsSExpressionNode type = (AbsSExpressionNode) (decl.getValueType() != null
					? new BaseTypeTestTransformer().transform(decl.getValueType())
					: new SExpressionStringNode().setString("VOID"));
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("FUNCDECL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(type)
							.addChild(new SExpressionStringNode().setString(decl.getName().toString()))
							.addChild(parameters)
							.addChild((SExpressionSequenceNode) new StatementTestTransformer().transform(decl.getStatementBlock()))
					)
			);
		}

		@Override
		public SExpressionSequenceNode visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
			SExpressionSequenceNode channelReferenceGrpSeq = new SExpressionSequenceNode();
			for (ChannelReferenceGroup channelReferenceGroup : decl.getPrioritySequence()) {
				for (AbsChannelReference channelReference : channelReferenceGroup) {
					channelReference.accept(new IChannelReferenceVisitor<AbsSExpressionNode>() {
						private SExpressionSequenceNode wrap(SExpressionSequenceNode seqNode) {
							return new SExpressionSequenceNode()
									.addChild(new SExpressionStringNode().setString("CHANREF"))
									.addChild(seqNode);
						}

						@Override
						public AbsSExpressionNode visitChannelArrayLookup(ChannelArrayLookup ref) {
							return wrap(new SExpressionSequenceNode()
									.addChild(new SExpressionStringNode().setString("CHANARRLOOKUP"))
									.addChild((SExpressionSequenceNode) new ExpressionTestTransformer().transform(ref))
							);
						}

						@Override
						public AbsSExpressionNode visitChannelIdentifierReference(ChannelIdentifierReference ref) {
							return wrap(new SExpressionSequenceNode()
									.addChild(new SExpressionStringNode().setString("CHANIDREF"))
									.addChild(new SExpressionStringNode().setString(ref.getIdentifier().toString()))
							);
						}

						@Override
						public AbsSExpressionNode visitDefaultChannelReference(DefaultChannelReference ref) {
							return wrap(new SExpressionSequenceNode()
									.addChild(new SExpressionStringNode().setString("DEFAULTCHANREF"))
									.addChild(new SExpressionStringNode().setString("DEFAULT"))
							);
						}
					});
				}
			}

			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("CHANPRIORITY"))
					.addChild(channelReferenceGrpSeq)
			);
		}

		@Override
		public SExpressionSequenceNode visitVariableDeclarationGroup(VariableDeclarationGroup decl) {
			SExpressionSequenceNode typeExtensionSequence = (SExpressionSequenceNode) new BaseTypeExtensionTestTransformer()
					.transform(decl.getBaseTypeExtensionMap());
			Stream<AbsSExpressionNode> typeExtStream = typeExtensionSequence.getChildren().stream();
			StreamUtils.zipConsume(// Skip s-expression qualifier
					typeExtensionSequence.getChildren().stream().sequential().skip(1),
					decl.getBaseTypeExtensionMap().streamView(),
					(node, typeExt) -> {
						SExpressionSequenceNode typeExtSeq = (SExpressionSequenceNode) node;
						AbsVariableInitializer initializer = decl.getInitializerMap().get(typeExt.getIdentifier());
						SExpressionSequenceNode initializerSeq = null;
						if (initializer != null) {
							initializerSeq = (SExpressionSequenceNode) new VariableInitializerTestTransformer()
									.transform(initializer);
						}
						typeExtSeq.addChild(new SExpressionSequenceNode()
								.addChild(new SExpressionStringNode().setString(typeExt.getIdentifier().toString()))
								.addChild(ObjectUtils.defaultObject(initializerSeq, SExpressionSequenceNode::new))
						);
					}
			);
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("VARDECLGROUP"))
					.addChild(typeExtensionSequence)
			);
		}

		@Override
		public SExpressionSequenceNode visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("TYPEDECLGROUP"))
					.addChild((SExpressionSequenceNode) new BaseTypeExtensionTestTransformer().transform(decl.getBaseTypeExtensionMap()))
			);
		}
	}

	@Override
	public Object transform(Object in) {
		AbsDeclarationStatement declarationStatement = (AbsDeclarationStatement) in;
		return declarationStatement.accept(new TransformerVisitor());
	}
}
