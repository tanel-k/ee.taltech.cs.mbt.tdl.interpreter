package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioCompositionParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.scenario_wrapper.base.ScenarioWrapperBaseSystemFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset.TrapsetImplementationDetail;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;

import java.util.HashMap;
import java.util.Map;

public class ScenarioWrapperFactory extends ScenarioWrapperBaseSystemFactory {
	public static ScenarioWrapperFactory getInstance(ScenarioCompositionParameters parameters) {
		return new ScenarioWrapperFactory(parameters);
	}

	private static class QuantifierRecognizerFactory extends TdlQuantificationRecognizerTemplateFactory {
		private Identifier templateName;
		private boolean universal;
		private boolean negated;
		private Integer trapsetIndex;
		private Integer treeIndex;
		private Identifier trapsetArrayName;
		private Integer trapsetSize;

		private QuantifierRecognizerFactory(
				boolean universal,
				boolean negated,
				Integer treeIndex,
				Integer trapsetIndex,
				Identifier trapsetArrayName,
				Integer trapsetSize
		) {
			this.universal = universal;
			this.negated = negated;
			this.treeIndex = treeIndex;
			this.trapsetIndex = trapsetIndex;
			this.templateName = Identifier.of(
					(universal ? "UniversalQuantificationOver_" : "ExistentialQuantificationOver_") + trapsetArrayName
			);
			this.trapsetArrayName = trapsetArrayName;
			this.trapsetSize = trapsetSize;
		}

		public TemplateInstantiation createInstantiation() {
			Identifier processName = Identifier.of(templateName + "_Recognizer");
			return super.createInstantiation(
					processName,
					universal ? LiteralConsts.TRUE : LiteralConsts.FALSE,
					negated ? LiteralConsts.TRUE : LiteralConsts.FALSE,
					NaturalNumberLiteral.of(treeIndex),
					NaturalNumberLiteral.of(trapsetIndex),
					NaturalNumberLiteral.of(trapsetSize),
					IdentifierExpression.of(trapsetArrayName)
			);
		}

		@Override
		protected ParameterDeclaration new_trapsetParameterDeclaration() {
			ParameterDeclaration parameter = super.new_trapsetParameterDeclaration();
			Type parameterType = parameter.getType();
			parameterType.getArrayModifiers().clear();
			parameterType.getArrayModifiers().add(
					new SizeExpressionArrayModifier()
							.setSizeSpecifier(NaturalNumberLiteral.of(trapsetSize))
			);
			return parameter;
		}

		@Override
		public Identifier getTemplateName() {
			return templateName;
		}
	}

	private Flag completionFlag = Flag.newInstance();

	private UtaSystem wrapperSystem;
	private ScenarioCompositionParameters parameters;
	private ScenarioWrapperConstructionContext ctx;

	private ScenarioWrapperFactory(ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	protected VariableDeclaration new_TDL_TREE_NODE_COUNTDeclaration() {
		VariableDeclaration baseDeclaration = super.new_TDL_TREE_NODE_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(ctx.getTreeNodeCount())
		));
		return baseDeclaration;
	}

	@Override
	protected VariableDeclaration new_TRAPSET_COUNTDeclaration() {
		VariableDeclaration baseDeclaration = super.new_TRAPSET_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(ctx.getTrapsetNodeCount())
		));
		return baseDeclaration;
	}

	@Override
	protected Template new_TdlDisjunctionRecognizerTemplate() {
		if (ctx.getDisjunctionInclusionFlag().isNotSet())
			return null;

		return super.new_TdlDisjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlConjunctionRecognizerTemplate() {
		if (ctx.getConjunctionInclusionFlag().isNotSet())
			return null;

		return super.new_TdlConjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedRepetitionRecognizerTemplate() {
		if (ctx.getBoundedRepetitionInclusionFlag().isNotSet())
			return null;

		return super.new_TdlBoundedRepetitionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlLeadsToRecognizerTemplate() {
		if (ctx.getLeadsToInclusionFlag().isNotSet())
			return null;

		return super.new_TdlLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedLeadsToRecognizerTemplate() {
		if (ctx.getBoundedLeadsToInclusionFlag().isNotSet())
			return null;

		return super.new_TdlBoundedLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlTrivialTrueRecognizerTemplate() {
		if (ctx.getTrivialTrueInclusionFlag().isNotSet())
			return null;

		return super.new_TdlTrivialTrueRecognizerTemplate();
	}

	@Override
	protected Template new_TdlTrivialFalseRecognizerTemplate() {
		if (ctx.getTrivialFalseInclusionFlag().isNotSet())
			return null;

		return super.new_TdlTrivialFalseRecognizerTemplate();
	}

	@Override
	protected Template new_TdlQuantificationRecognizerTemplate() {
		// Prevent adding the base quantification recognizer template.
		return null;
	}

	@Override
	protected SystemDefinition newSystemDefinition() {
		SystemDefinition baseDefinition = super.newSystemDefinition();
		ProcessReferenceGroup processReferences = baseDefinition.getSystemLine().getProcessPrioritySequence()
				.iterator().next();
		getConstructionContext().getTemplateInstantiations().stream().forEachOrdered(inst -> {
				processReferences.addIdentifier(inst.getNewTemplateName());
				baseDefinition.getDeclarations().add(inst);
		});
		return baseDefinition;
	}

	private void prepareConstructionContext() {
		ctx = new ScenarioWrapperConstructionContext();

		IntIterator treeNodeCounter = IntIterator.newInstance();
		IntIterator trapsetNodeCounter = IntIterator.newInstance();
		parameters.getTdlExpression().getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitEquivalence(EquivalenceNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitGroup(GroupNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
				return visitQuantification(node);
			}

			@Override
			public Void visitUniversalQuantification(UniversalQuantificationNode node) {
				return visitQuantification(node);
			}

			private Void visitQuantification(AbsTrapsetQuantifierNode node) {
				AbsTrapsetExpressionNode trapsetExpressionNode = node.getChildContainer().getChild();
				AbsEvaluatedTrapset evaluatedTrapset = parameters.getTrapsetEvaluationMap().get(trapsetExpressionNode);
				ctx.getTrapsetCounterMap().computeIfAbsent(evaluatedTrapset.getName(), k -> IntIterator.newInstance(1)).next();

				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				ctx.getTrapsetIndexMap().put(node.getChildContainer().getChild(), trapsetNodeCounter.next());
				return null;
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitImplication(ImplicationNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitValueWrapper(BooleanValueWrapperNode node) {
				ctx.getTreeIndexMap().put(node, treeNodeCounter.next());
				return null;
			}
		});

		ctx.setTreeNodeCount(treeNodeCounter.getCurrentValue());
		ctx.setTrapsetNodeCount(trapsetNodeCounter.getCurrentValue());
		ctx.getTrapsetCounterMap().forEach(
				(k, v) -> ctx.getTrapsetOccurrenceCountMap().put(k, v.getCurrentValue() - 1)
		);

		Map<Identifier, IntIterator> trapsetQualifierCounters = new HashMap<>();
		parameters.getTdlExpression().getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
			private AbsExpression getBoundTypeExpression(Bound bound) {
				Identifier boundTypeName = null;

				switch (bound.getBoundType()) {
					case GREATER_THAN:
						boundTypeName = DECLARED_NAME_BOUND_GT;
						break;
					case EQUALS:
						boundTypeName = DECLARED_NAME_BOUND_EQ;
						break;
					case LESS_THAN_OR_EQUAL_TO:
						boundTypeName = DECLARED_NAME_BOUND_LTE;
						break;
					case GREATER_THAN_OR_EQUAL_TO:
						boundTypeName = DECLARED_NAME_BOUND_GTE;
						break;
					case LESS_THAN:
						boundTypeName = DECLARED_NAME_BOUND_LT;
						break;
				}

				return IdentifierExpression.of(boundTypeName);
			}

			@Override
			public Void visitValueWrapper(BooleanValueWrapperNode node) {
				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				TemplateInstantiation instantiation;

				if (node.wrapsTrue()) {
					ctx.getTrivialTrueInclusionFlag().set();
					instantiation = TdlTrivialTrueRecognizerTemplateFactory.getInstance().createInstantiation(
							Identifier.of(TdlTrivialTrueRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
							NaturalNumberLiteral.of(treeIndex)
					);
				} else {
					ctx.getTrivialFalseInclusionFlag().set();
					instantiation = TdlTrivialFalseRecognizerTemplateFactory.getInstance().createInstantiation(
							Identifier.of(TdlTrivialFalseRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
							NaturalNumberLiteral.of(treeIndex)
					);
				}
				ctx.getTemplateInstantiations().add(instantiation);

				/*
				// Note: This represents a condition that holds on every transition in the SUT.
				ctx.getGloballyApplicableTransitionSynchs().add(
						new Synchronization()
								.setExpression(new ArrayLookupExpression()
										.setLeftChild(IdentifierExpression.of(DECLARED_NAME_TdlTerminatorChannels))
										.setRightChild(NaturalNumberLiteral.of(treeIndex))
								)
								.setActiveSync(true)
				);
				*/

				return null;
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				ctx.getConjunctionInclusionFlag().set();

				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer leftChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlConjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlConjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				ctx.getTemplateInstantiations().add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				ctx.getDisjunctionInclusionFlag().set();

				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer leftChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlDisjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlDisjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				ctx.getTemplateInstantiations().add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				ctx.getLeadsToInclusionFlag().set();

				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer leftChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				ctx.getTemplateInstantiations().add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				ctx.getBoundedLeadsToInclusionFlag().set();

				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer leftChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				ctx.getTemplateInstantiations().add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				ctx.getBoundedRepetitionInclusionFlag().set();

				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer childIndex = ctx.getTreeIndexMap().get(node.getChildContainer().getChild());

				TemplateInstantiation inst = TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedRepetitionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(childIndex)
				);

				ctx.getTemplateInstantiations().add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitUniversalQuantification(UniversalQuantificationNode node) {
				return visitQuantification(true, node);
			}

			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
				return visitQuantification(false, node);
			}

			private Void visitQuantification(boolean universal, AbsTrapsetQuantifierNode node) {
				Integer treeIndex = ctx.getTreeIndexMap().get(node);
				Integer trapsetIndex = ctx.getTrapsetIndexMap().get(node.getChildContainer().getChild());

				AbsEvaluatedTrapset<?> trapset = parameters.getTrapsetEvaluationMap()
						.get(node.getChildContainer().getChild());

				Identifier trapsetName = trapset.getName();
				if (ctx.getTrapsetOccurrenceCountMap().get(trapsetName) > 1) {
					Integer trapsetNameQualifier = trapsetQualifierCounters
							.computeIfAbsent(trapset.getName(), k -> IntIterator.newInstance(1))
							.next();
					trapsetName = Identifier.of(trapsetName + "_" + trapsetNameQualifier);
				}

				trapset.getTrapsetImplementationDetails().add(
						TrapsetImplementationDetail.of(
								trapsetName,
								new Synchronization().setActiveSync(true).setExpression(
										new ArrayLookupExpression()
												.setLeftChild(IdentifierExpression.of(DECLARED_NAME_TrapsetActivatorChannels))
												.setRightChild(NaturalNumberLiteral.of(trapsetIndex))
								)
						)
				);

				ctx.getTrapsetArrayDeclarations().add(
						new VariableDeclaration()
								.setIdentifier(trapsetName)
								.setType(new Type()
										.setBaseType(new BaseType().setTypeId(BaseTypeIdentifiers.BOOLEAN))
										.addArrayModifier(new SizeExpressionArrayModifier()
												.setSizeSpecifier(NaturalNumberLiteral.of(trapset.getTrapCount()))
										)
								)
				);

				QuantifierRecognizerFactory recognizerFactory = new QuantifierRecognizerFactory(
						universal,
						node.isNegated(),
						treeIndex,
						trapsetIndex,
						trapsetName,
						trapset.getTrapCount()
				);

				Template template = recognizerFactory.newTemplate();
				TemplateInstantiation inst = recognizerFactory.createInstantiation();

				ctx.getTrapsetEvaluationMap().putIfAbsent(trapset.getName(), trapset);
				ctx.getQuantifierTemplates().add(template);
				ctx.getTemplateInstantiations().add(inst);

				return null;
			}

			@Override
			public Void visitEquivalence(EquivalenceNode node) {
				throw new UnsupportedOperationException("No scenario wrapper template exists for " + node.getClass().getName());
			}

			@Override
			public Void visitGroup(GroupNode node) {
				throw new UnsupportedOperationException("No scenario wrapper template exists for " + node.getClass().getName());
			}

			@Override
			public Void visitImplication(ImplicationNode node) {
				throw new UnsupportedOperationException("No scenario wrapper template exists for " + node.getClass().getName());
			}
		});
	}

	public ScenarioWrapperConstructionContext getConstructionContext() {
		return ctx;
	}

	@Override
	public UtaSystem constructSystem() {
		if (completionFlag.isSet())
			return wrapperSystem;

		prepareConstructionContext();

		wrapperSystem = super.constructSystem();
		wrapperSystem.getDeclarations()
				.addAll(ctx.getTrapsetArrayDeclarations());
		wrapperSystem.getTemplates()
				.addAll(ctx.getQuantifierTemplates());

		completionFlag.set();
		return wrapperSystem;
	}
}
