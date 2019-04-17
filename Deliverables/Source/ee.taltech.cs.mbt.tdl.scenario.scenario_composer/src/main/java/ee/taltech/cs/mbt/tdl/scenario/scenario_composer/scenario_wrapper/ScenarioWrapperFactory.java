package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioCompositionParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.base.ScenarioWrapperBaseSystemFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsDerivedTrapset.TrapsetImplementationDetail;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

		public QuantifierRecognizerFactory(
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

	public static class ScenarioWrapperConstructionContext {
		protected int treeNodeCount = 0;
		protected int trapsetNodeCount = 0;

		protected BooleanFlag terminatorAdapterInclusionFlag = BooleanFlag.newInstance();
		protected BooleanFlag disjunctionInclusionFlag = BooleanFlag.newInstance();
		protected BooleanFlag conjunctionInclusionFlag = BooleanFlag.newInstance();
		protected BooleanFlag leadsToInclusionFlag = BooleanFlag.newInstance();
		protected BooleanFlag boundedLeadsToInclusionFlag = BooleanFlag.newInstance();
		protected BooleanFlag boundedInclusionFlag = BooleanFlag.newInstance();

		protected List<Template> quantifierTemplates = new LinkedList<>();
		protected List<VariableDeclaration> trapsetArrayDeclarations = new LinkedList<>();
		protected List<TemplateInstantiation> templateInstantiations = new LinkedList<>();
		protected Map<Identifier, Integer> mapTrapsetOccurrenceCounts = new HashMap<>();
		protected Map<Identifier, AbsDerivedTrapset> derivedTrapsetMap = new HashMap<>();
		protected List<Synchronization> globallyApplicableTransitionSynchs = new LinkedList<>();

		protected ObjectIdentityMap<AbsExpressionNode, Integer> treeIndexMap = new ObjectIdentityMap<>();
		protected ObjectIdentityMap<AbsDerivedTrapsetNode, Integer> trapsetIndexMap = new ObjectIdentityMap<>();

		public List<Synchronization> getGloballyApplicableTransitionSynchs() {
			return globallyApplicableTransitionSynchs;
		}

		public Map<Identifier, AbsDerivedTrapset> getDerivedTrapsetMap() {
			return derivedTrapsetMap;
		}
	}

	private ScenarioCompositionParameters parameters;
	private ScenarioWrapperConstructionContext constructionCtx;

	private ScenarioWrapperFactory(ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	protected VariableDeclaration new_TDL_TREE_NODE_COUNTDeclaration() {
		// Adjust the value of TDL_TREE_NODE_COUNT.
		VariableDeclaration baseDeclaration = super.new_TDL_TREE_NODE_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(constructionCtx.treeNodeCount)
		));
		return baseDeclaration;
	}

	@Override
	protected VariableDeclaration new_TRAPSET_COUNTDeclaration() {
		// Adjust the value of TRAPSET_COUNT.
		VariableDeclaration baseDeclaration = super.new_TRAPSET_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(constructionCtx.trapsetNodeCount)
		));
		return baseDeclaration;
	}

	@Override
	protected Template new_TdlDisjunctionRecognizerTemplate() {
		if (constructionCtx.disjunctionInclusionFlag.isNotSet())
			return null;

		return super.new_TdlDisjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlConjunctionRecognizerTemplate() {
		if (constructionCtx.conjunctionInclusionFlag.isNotSet())
			return null;

		return super.new_TdlConjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedRepetitionRecognizerTemplate() {
		if (constructionCtx.boundedInclusionFlag.isNotSet())
			return null;

		return super.new_TdlBoundedRepetitionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlLeadsToRecognizerTemplate() {
		if (constructionCtx.leadsToInclusionFlag.isNotSet())
			return null;

		return super.new_TdlLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedLeadsToRecognizerTemplate() {
		if (constructionCtx.boundedLeadsToInclusionFlag.isNotSet())
			return null;

		return super.new_TdlBoundedLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlTerminatorChannelAdapterTemplate() {
		if (constructionCtx.terminatorAdapterInclusionFlag.isNotSet())
			return null;

		return super.new_TdlTerminatorChannelAdapterTemplate();
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
		constructionCtx.templateInstantiations.stream().forEachOrdered(inst -> {
				processReferences.addIdentifier(inst.getNewTemplateName());
				baseDefinition.getDeclarations().add(inst);
		});
		return baseDefinition;
	}

	protected void resetConstructionContext() {
		this.constructionCtx = new ScenarioWrapperConstructionContext();
	}

	protected void prepareContext() {
		preprocessExpressionTree();

		Map<Identifier, IntIterator> trapsetNameCounters = new HashMap<>();
		parameters.getExpression().getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
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
				constructionCtx.terminatorAdapterInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				TemplateInstantiation inst = TdlTerminatorChannelAdapterTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlTerminatorChannelAdapterTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex)
				);

				constructionCtx.globallyApplicableTransitionSynchs.add(
						new Synchronization()
								.setExpression(new ArrayLookupExpression()
										.setLeftChild(IdentifierExpression.of(DECLARED_NAME_TdlTerminatorChannels))
										.setRightChild(NaturalNumberLiteral.of(treeIndex))
								)
								.setActiveSync(true)
				);
				constructionCtx.templateInstantiations.add(inst);

				return null;
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				constructionCtx.conjunctionInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer leftChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlConjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlConjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				constructionCtx.templateInstantiations.add(inst);

				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				constructionCtx.disjunctionInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer leftChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlDisjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlDisjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				constructionCtx.templateInstantiations.add(inst);

				return visitChildren(node);
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				constructionCtx.leadsToInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer leftChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				constructionCtx.templateInstantiations.add(inst);

				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				constructionCtx.boundedLeadsToInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer leftChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getRightChild());

				TemplateInstantiation inst = TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);

				constructionCtx.templateInstantiations.add(inst);

				return visitChildren(node);
			}

			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				constructionCtx.boundedInclusionFlag.set();

				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer childIndex = constructionCtx.treeIndexMap.get(node.getChildContainer().getChild());

				TemplateInstantiation inst = TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedRepetitionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(childIndex)
				);

				constructionCtx.templateInstantiations.add(inst);

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
				Integer treeIndex = constructionCtx.treeIndexMap.get(node);
				Integer trapsetIndex = constructionCtx.trapsetIndexMap.get(node.getChildContainer().getChild());

				AbsDerivedTrapset<?> trapset = parameters.getDerivedTrapsetMap()
						.get(node.getChildContainer().getChild());

				Identifier trapsetName = trapset.getName();
				if (constructionCtx.mapTrapsetOccurrenceCounts.get(trapsetName) > 1) {
					Integer trapsetNameQualifier = trapsetNameCounters
							.computeIfAbsent(trapset.getName(), k -> IntIterator.newInstance())
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

				constructionCtx.trapsetArrayDeclarations.add(
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

				constructionCtx.derivedTrapsetMap.putIfAbsent(trapset.getName(), trapset);
				constructionCtx.quantifierTemplates.add(template);
				constructionCtx.templateInstantiations.add(inst);

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

	private void preprocessExpressionTree() {
		Map<Identifier, IntIterator> mapTrapsetCounters = new HashMap<>();

		IntIterator treeNodeCounter = IntIterator.newInstance();
		IntIterator trapsetNodeCounter = IntIterator.newInstance();
		parameters.getExpression().getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitEquivalence(EquivalenceNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitGroup(GroupNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
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
				AbsDerivedTrapsetNode derivedTrapsetNode = node.getChildContainer().getChild();
				AbsDerivedTrapset derivedTrapset = parameters.getDerivedTrapsetMap().get(derivedTrapsetNode);
				mapTrapsetCounters.computeIfAbsent(derivedTrapset.getName(), k -> IntIterator.newInstance(1)).next();

				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				constructionCtx.trapsetIndexMap.put(node.getChildContainer().getChild(), trapsetNodeCounter.next());
				return null;
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitImplication(ImplicationNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return visitChildren(node);
			}

			@Override
			public Void visitValueWrapper(BooleanValueWrapperNode node) {
				constructionCtx.treeIndexMap.put(node, treeNodeCounter.next());
				return null;
			}
		});

		constructionCtx.treeNodeCount = treeNodeCounter.getCurrentValue();
		constructionCtx.trapsetNodeCount = trapsetNodeCounter.getCurrentValue();
		mapTrapsetCounters.forEach((k, v) -> constructionCtx.mapTrapsetOccurrenceCounts.put(k, v.getCurrentValue()));
	}

	public ScenarioWrapperConstructionContext getConstructionContext() {
		return constructionCtx;
	}

	@Override
	public UtaSystem newSystem() {
		resetConstructionContext();
		prepareContext();

		UtaSystem wrapperSystem = super.newSystem();
		wrapperSystem.getDeclarations()
				.addAll(constructionCtx.trapsetArrayDeclarations);
		wrapperSystem.getTemplates()
				.addAll(constructionCtx.quantifierTemplates);

		return wrapperSystem;
	}
}
