package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.scenario_wrapper.base.ScenarioWrapperBaseSystemFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsDerivedTrapset.TrapsetDuplicationParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
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
	public static ScenarioWrapperFactory getInstance(ScenarioParameters parameters) {
		return new ScenarioWrapperFactory(parameters);
	}

	private ScenarioParameters parameters;

	private int treeNodeCount = 0;
	private int trapsetCount = 0;

	private BooleanFlag terminatorAdapterInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag disjunctionInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag conjunctionInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag leadsToInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag boundedLeadsToInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag boundedInclusionFlag = BooleanFlag.newInstance();

	private ObjectIdentityMap<AbsBooleanInternalNode, RecognizerParameters> mapRecognizerParams = new ObjectIdentityMap<>();

	private List<Template> quantifierTemplates = new LinkedList<>();
	private List<VariableDeclaration> trapsetArrayDeclarations = new LinkedList<>();
	private List<TemplateInstantiation> templateInstantiations = new LinkedList<>();

	private ScenarioWrapperFactory(ScenarioParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	protected VariableDeclaration new_TDL_TREE_NODE_COUNTDeclaration() {
		// Adjust the value of TDL_TREE_NODE_COUNT.
		VariableDeclaration baseDeclaration = super.new_TDL_TREE_NODE_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(treeNodeCount)
		));
		return baseDeclaration;
	}

	@Override
	protected VariableDeclaration new_TRAPSET_COUNTDeclaration() {
		// Adjust the value of TRAPSET_COUNT.
		VariableDeclaration baseDeclaration = super.new_TRAPSET_COUNTDeclaration();
		baseDeclaration.setInitializer(new FlatVariableInitializer().setExpression(
				NaturalNumberLiteral.of(trapsetCount)
		));
		return baseDeclaration;
	}

	@Override
	protected Template new_TdlDisjunctionRecognizerTemplate() {
		if (disjunctionInclusionFlag.isNotSet())
			return null;

		return super.new_TdlDisjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlConjunctionRecognizerTemplate() {
		if (conjunctionInclusionFlag.isNotSet())
			return null;

		return super.new_TdlConjunctionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedRepetitionRecognizerTemplate() {
		if (boundedInclusionFlag.isNotSet())
			return null;

		return super.new_TdlBoundedRepetitionRecognizerTemplate();
	}

	@Override
	protected Template new_TdlLeadsToRecognizerTemplate() {
		if (leadsToInclusionFlag.isNotSet())
			return null;

		return super.new_TdlLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlBoundedLeadsToRecognizerTemplate() {
		if (boundedLeadsToInclusionFlag.isNotSet())
			return null;

		return super.new_TdlBoundedLeadsToRecognizerTemplate();
	}

	@Override
	protected Template new_TdlTerminatorChannelAdapterTemplate() {
		if (terminatorAdapterInclusionFlag.isNotSet())
			return null;

		return super.new_TdlTerminatorChannelAdapterTemplate();
	}

	@Override
	protected Template new_TdlQuantificationRecognizerTemplate() {
		// Prevent adding the base quantification recognizer.
		return null;
	}

	@Override
	protected SystemDefinition newSystemDefinition() {
		SystemDefinition baseDefinition = super.newSystemDefinition();
		ProcessReferenceGroup processReferences = baseDefinition.getSystemLine().getProcessPrioritySequence()
				.iterator().next();
		templateInstantiations.stream().forEachOrdered(inst -> {
				processReferences.addIdentifier(inst.getNewTemplateName());
				baseDefinition.getDeclarations().add(inst);
		});
		return baseDefinition;
	}

	protected void populateFromExpression() {
		IntIterator treeNodeCounter = IntIterator.newInstance(0);
		IntIterator trapsetCounter = IntIterator.newInstance(0);
		Map<Identifier, IntIterator> trapsetNameCounters = new HashMap<>();

		ObjectIdentityMap<AbsExpressionNode, Integer> treeIndexMap = extractTreeIndexes(parameters.getReducedExpression());
		List<AbsTrapset> remainingTrapsets = collectRemainingTrapsets(parameters.getReducedExpression(), parameters.getDerivedTrapsetMap());

		Map<Identifier, IntIterator> mapTrapsetCounters = new HashMap<>();
		for (AbsTrapset<?> trapset : remainingTrapsets) {
			mapTrapsetCounters.computeIfAbsent(trapset.getName(), k -> IntIterator.newInstance(1)).next();
		}

		Map<Identifier, Integer> mapTrapsetOccurrences = new HashMap<>();
		mapTrapsetCounters.forEach((k, v) -> mapTrapsetOccurrences.put(k, v.getCurrentValue()));

		parameters.getReducedExpression().getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
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
			public Void visitValueWrapper(BooleanValueWrapperNode node) { // FIXME.
				terminatorAdapterInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				TemplateInstantiation inst = TdlTerminatorChannelAdapterTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlTerminatorChannelAdapterTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return null;
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				conjunctionInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				Integer leftChildIndex = treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = treeIndexMap.get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlConjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlConjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				disjunctionInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				Integer leftChildIndex = treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = treeIndexMap.get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlDisjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlDisjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return visitChildren(node);
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				leadsToInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				Integer leftChildIndex = treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = treeIndexMap.get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				boundedLeadsToInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				Integer leftChildIndex = treeIndexMap.get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = treeIndexMap.get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return visitChildren(node);
			}

			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				boundedInclusionFlag.set();
				treeNodeCounter.next();

				Integer treeIndex = treeIndexMap.get(node);
				Integer childIndex = treeIndexMap.get(node.getChildContainer().getChild());
				TemplateInstantiation inst = TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedRepetitionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(childIndex)
				);
				templateInstantiations.add(inst);
				mapRecognizerParams.put(
						node,
						new RecognizerParameters<>(node).setTreeIndex(treeIndex).setProcessName(inst.getNewTemplateName())
				);

				return visitChildren(node);
			}

			/*
			 * For TrapsetQuantifiers:
			 * Quantifier: const bool universal, const bool negated, const TdlTreeIndex treeIndex, const TrapsetIndex trapsetIndex, const int trapsetSize, bool &trapset[0]
			 * Trapset trapset = derivedTrapsetMap.get(trapsetQuantifier);
			 * trapsetIndex = ++trapsetIndex;
			 * trapsetSize = trapset.getTrapCount();
			 * size(TrapsetActivatorChannels)++
			 * trapset arg size = trapsetSize
			 * createInstantiation
			 */
			/*
			 * For logical nodes:
			 * Disjunction/Conjunction/LeadsTo: const TdlTreeIndex treeIndex, const TdlTreeIndex leftOpIndex, const TdlTreeIndex rightOpIndex
			 * BoundedRepetition: const BoundType boundType, const BoundValue boundValue, const TdlTreeIndex treeIndex, const TdlTreeIndex operandIndex
			 * BoundedLeadsTo: const BoundType boundType, const BoundValue boundValue, const TdlTreeIndex treeIndex, const TdlTreeIndex leftOpIndex, const TdlTreeIndex rightOpIndex
			 */
			@Override
			public Void visitUniversalQuantification(UniversalQuantificationNode node) {
				treeNodeCounter.next();
				Integer trapsetIndex = trapsetCounter.next();

				AbsDerivedTrapset trapset = parameters.getDerivedTrapsetMap()
						.get(node.getChildContainer().getChild());
				Identifier trapsetName = trapset.getName();

				if (mapTrapsetOccurrences.get(trapsetName) > 1) {
					Integer trapsetNameQualifier = trapsetNameCounters
							.computeIfAbsent(trapset.getName(), k -> IntIterator.newInstance(1))
							.next();
					trapsetName = Identifier.of(trapsetName + "_" + trapsetNameQualifier);
				}

				trapsetArrayDeclarations.add(
						new VariableDeclaration()
								.setIdentifier(trapsetName)
								.setType(new Type()
										.setBaseType(new BaseType().setTypeId(BaseTypeIdentifiers.BOOLEAN))
										.addArrayModifier(new SizeExpressionArrayModifier()
												.setSizeSpecifier(NaturalNumberLiteral.of(trapset.getTrapCount()))
										)
								)
				);

				// FIXME!
				return null;
			}

			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
				treeNodeCounter.next();
				Integer trapsetIndex = trapsetCounter.next();

				AbsDerivedTrapset<?> trapset = parameters.getDerivedTrapsetMap()
						.get(node.getChildContainer().getChild());

				Identifier trapsetName = trapset.getName();
				if (mapTrapsetOccurrences.get(trapsetName) > 1) {
					Integer trapsetNameQualifier = trapsetNameCounters
							.computeIfAbsent(trapset.getName(), k -> IntIterator.newInstance(1))
							.next();
					trapsetName = Identifier.of(trapsetName + "_" + trapsetNameQualifier);
					trapset.getDuplications().add(
							TrapsetDuplicationParameters.of(
								trapsetName,
								new Synchronization().setActiveSync(true).setExpression(
										new ArrayLookupExpression()
												.setLeftChild(IdentifierExpression.of(DECLARED_NAME_TdlActivatorChannels))
												.setRightChild(NaturalNumberLiteral.of(trapsetIndex))
								)
							)
					);
				}

				trapsetArrayDeclarations.add(
						new VariableDeclaration()
						.setIdentifier(trapsetName)
						.setType(new Type()
								.setBaseType(new BaseType().setTypeId(BaseTypeIdentifiers.BOOLEAN))
								.addArrayModifier(new SizeExpressionArrayModifier()
										.setSizeSpecifier(NaturalNumberLiteral.of(trapset.getTrapCount()))
								)
						)
				);

				// FIXME!
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

		treeNodeCount = treeNodeCounter.getCurrentValue();
		trapsetCount = trapsetCounter.getCurrentValue();
	}

	private static List<AbsTrapset> collectRemainingTrapsets(TdlExpression expression, Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> mapDerivedTrapset) {
		List<AbsTrapset> trapsets = new LinkedList<>();

		expression.getRootNode().accept(new BaseTdlExpressionVisitor<Void>() {
			@Override
			public Void visitLinkedPair(LinkedPairNode node) {
				trapsets.add(mapDerivedTrapset.get(node));
				return null;
			}

			@Override
			public Void visitRelativeComplement(RelativeComplementNode node) {
				trapsets.add(mapDerivedTrapset.get(node));
				return null;
			}

			@Override
			public Void visitAbsoluteComplement(AbsoluteComplementNode node) {
				trapsets.add(mapDerivedTrapset.get(node));
				return null;
			}
		});

		return trapsets;
	}

	private static ObjectIdentityMap<AbsExpressionNode, Integer> extractTreeIndexes(TdlExpression expression) {
		ObjectIdentityMap<AbsExpressionNode, Integer> treeIndexMap = new ObjectIdentityMap<>();
		IntIterator treeIndexProvider = IntIterator.newInstance();
		expression.getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitEquivalence(EquivalenceNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitGroup(GroupNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return null;
			}

			@Override
			public Void visitUniversalQuantification(UniversalQuantificationNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return null;
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitImplication(ImplicationNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return visitChildren(node);
			}

			@Override
			public Void visitValueWrapper(BooleanValueWrapperNode node) {
				treeIndexMap.put(node, treeIndexProvider.next());
				return null;
			}
		});

		return treeIndexMap;
	}


	public ObjectIdentityMap<AbsBooleanInternalNode, RecognizerParameters> getRecognizerParams() {
		return mapRecognizerParams;
	}

	@Override
	public UtaSystem newSystem() {
		populateFromExpression();

		UtaSystem wrapperSystem = super.newSystem();

		wrapperSystem.getDeclarations().addAll(trapsetArrayDeclarations);
		wrapperSystem.getTemplates().addAll(quantifierTemplates);

		return wrapperSystem;
	}
}
