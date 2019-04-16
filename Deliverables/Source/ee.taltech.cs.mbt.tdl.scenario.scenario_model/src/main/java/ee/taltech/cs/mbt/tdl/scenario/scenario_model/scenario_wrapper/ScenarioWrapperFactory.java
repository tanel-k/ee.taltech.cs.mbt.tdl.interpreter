package ee.taltech.cs.mbt.tdl.scenario.scenario_model.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
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
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.scenario_stub.ScenarioStubSystemFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.LinkedList;
import java.util.List;

public class ScenarioWrapperFactory extends ScenarioStubSystemFactory {
	public static ScenarioWrapperFactory getInstance(ScenarioWrapperParameters parameters) {
		return new ScenarioWrapperFactory(parameters);
	}

	private ScenarioWrapperParameters parameters;

	private int treeNodeCount = 0;
	private int trapsetCount = 0;

	private List<Template> quantifierTemplates = new LinkedList<>();
	private List<VariableDeclaration> trapsetArrayDeclarations = new LinkedList<>();
	private List<TemplateInstantiation> templateInstantiations = new LinkedList<>();

	private ScenarioWrapperFactory(ScenarioWrapperParameters parameters) {
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
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				TemplateInstantiation inst = TdlTerminatorChannelAdapterTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlTerminatorChannelAdapterTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex)
				);
				templateInstantiations.add(inst);
				return null;
			}

			@Override
			public Void visitConjunction(ConjunctionNode node) {
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				Integer leftChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlConjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlConjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode node) {
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				Integer leftChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlDisjunctionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlDisjunctionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitLeadsTo(LeadsToNode node) {
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				Integer leftChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode node) {
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				Integer leftChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getLeftChild());
				Integer rightChildIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getRightChild());
				TemplateInstantiation inst = TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedLeadsToRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(leftChildIndex),
						NaturalNumberLiteral.of(rightChildIndex)
				);
				templateInstantiations.add(inst);
				return visitChildren(node);
			}

			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode node) {
				treeNodeCounter.next();
				Integer treeIndex = parameters.getTreeIndexMap().get(node);
				Integer childIndex = parameters.getTreeIndexMap().get(node.getChildContainer().getChild());
				TemplateInstantiation inst = TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().createInstantiation(
						Identifier.of(TdlBoundedRepetitionRecognizerTemplateFactory.TEMPLATE_NAME + "_" + treeIndex),
						getBoundTypeExpression(node.getBound()),
						NaturalNumberLiteral.of(node.getBound().getBoundValue()),
						NaturalNumberLiteral.of(treeIndex),
						NaturalNumberLiteral.of(childIndex)
				);
				templateInstantiations.add(inst);
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
				trapsetCounter.next();
				treeNodeCounter.next();
				Integer trapsetIndex = trapsetCounter.getCurrentValue();
				AbsTrapset derivedTrapset = parameters.getDerivedTrapsetMap()
						.get(node.getChildContainer().getChild());
				trapsetArrayDeclarations.add(
						new VariableDeclaration()
								.setIdentifier(derivedTrapset.getName())
								.setType(new Type()
										.setBaseType(new BaseType().setTypeId(BaseTypeIdentifiers.BOOLEAN))
										.addArrayModifier(new SizeExpressionArrayModifier()
												.setSizeSpecifier(NaturalNumberLiteral.of(derivedTrapset.getTrapCount()))
										)
								)
				);
				// FIXME!
				// Can be used to declare trapset array.
				return super.visitUniversalQuantification(node);
			}

			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
				trapsetCounter.next();
				treeNodeCounter.next();
				Integer trapsetIndex = trapsetCounter.getCurrentValue(); // FIXME
				AbsTrapset derivedTrapset = parameters.getDerivedTrapsetMap()
						.get(node.getChildContainer().getChild());
				trapsetArrayDeclarations.add(
						new VariableDeclaration()
						.setIdentifier(derivedTrapset.getName())
						.setType(new Type()
								.setBaseType(new BaseType().setTypeId(BaseTypeIdentifiers.BOOLEAN))
								.addArrayModifier(new SizeExpressionArrayModifier()
										.setSizeSpecifier(NaturalNumberLiteral.of(derivedTrapset.getTrapCount()))
								)
						)
				);
				// FIXME!
				// Can be used to declare trapset array.
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

	@Override
	public UtaSystem newSystem() {
		populateFromExpression();

		UtaSystem wrapperSystem = super.newSystem();

		wrapperSystem.getDeclarations().addAll(trapsetArrayDeclarations);
		wrapperSystem.getTemplates().addAll(quantifierTemplates);

		return wrapperSystem;
	}
}
