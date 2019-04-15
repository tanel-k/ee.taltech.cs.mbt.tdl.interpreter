package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils.CollectionBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.specification.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.ETrapsetType;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.Trapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.math.BigInteger;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneratorStub {
	public static void generate(ScenarioSpecification specification) {
		TdlExpression expression = specification.getTdlExpression();
		UtaSystem sutModel = specification.getSutModel();

		int systemTransitionCount = sutModel.getTemplates().stream()
				.map(Template::getLocationGraph)
				.mapToInt(DirectedMultigraph::edgeCount)
				.sum();

		Set<TrapsetNode> trapsetSymbols = extractTrapsetSymbols(expression);
		Map<TrapsetNode, Trapset> baseTrapsets = extractTrapsets(sutModel, trapsetSymbols);

		List<AbsDerivedTrapsetNode> trapsetOperators = extractTrapsetOperators(expression);
		Map<AbsDerivedTrapsetNode, Trapset> mapDerivedTrapsets = extractDerivedTrapsets(sutModel, trapsetOperators, baseTrapsets);

		List<AbsTrapsetQuantifierNode> trapsetQuantifiers = extractTrapsetQuantifiers(expression);
		for (AbsTrapsetQuantifierNode trapsetQuantifier : trapsetQuantifiers) {
			AbsDerivedTrapsetNode trapsetDerivingNode = trapsetQuantifier.getChildContainer().getChild();
			Trapset derivedTrapset = mapDerivedTrapsets.get(trapsetDerivingNode);

			Boolean replacementValue = trapsetQuantifier.accept(new IDerivedTrapsetQuantifierVisitor<Boolean>() {
				@Override
				public Boolean visitExistential(ExistentialQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				@Override
				public Boolean visitUniversal(UniversalQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				private Boolean visitAny(AbsTrapsetQuantifierNode quantifier) {
					if (derivedTrapset.isEmpty()) // Empty trapset.
						return quantifier.isNegated();
					if (derivedTrapset.getTrapCount() == systemTransitionCount) // Trapset that covers the entire system.
						return !quantifier.isNegated();
					return null;
				}
			});

			if (replacementValue != null) {
				BooleanValueWrapperNode wrapper = BooleanValueWrapperNode.of(replacementValue);
				expression.replaceDescendant(trapsetQuantifier, wrapper);
			}
		}


		Deque<BooleanValueWrapperNode> booleanLeaves = normalizeExpressionSubtree(expression);
		reduceBooleanValues(booleanLeaves, expression);
		// TODO p v p = p, p && p = p, ...

		System.out.println(expression.getRootNode());
		/*
		 * TODO:
		 * Create the result system based on normalized and reduced expression.
		 * int treeIndex;
		 * int trapsetIndex;
		 */

		// ScenarioStubSystemFactory.DECLARED_NAME_TrapsetActivatorChannels.equals(null);
	}

	private static void reduceBooleanValues(Deque<BooleanValueWrapperNode> booleanLeafNodeDeque, TdlExpression normalizedExpression) {
		while (!booleanLeafNodeDeque.isEmpty()) {
			BooleanValueWrapperNode booleanChildNode = booleanLeafNodeDeque.pollFirst();

			// Nothing left to reduce:
			if (booleanChildNode == normalizedExpression.getRootNode())
				return;

			AbsBooleanInternalNode parentNode = (AbsBooleanInternalNode) booleanChildNode.getParentNode();
			parentNode.accept(new IBooleanNodeVisitor<Void>() {
				private void renormalizeSubtree(AbsBooleanInternalNode subtreeRoot) {
					Deque<BooleanValueWrapperNode> newLeaves = normalizeExpressionSubtree(normalizedExpression, subtreeRoot);
					// Reprocess the subtree starting form its Boolean leaves:
					while (!newLeaves.isEmpty()) {
						booleanLeafNodeDeque.addFirst(newLeaves.pollLast());
					}
				}

				@Override
				public Void visitBoundedLeadsTo(BoundedLeadsToNode parentNode) { // TODO.
					// p ~> true == true
					// p ~> false == not(p)
					// true ~> p == p
					// false ~> p == true

					/*
					 * true <n ~> a = true
					 * true >n ~> a = true
					 * true <=n ~> a =
					 * true >=n ~> a
					 * true =n ~> a
					 *
					 * false <n ~> a
					 * false >n ~> a
					 * false <=n ~> a
					 * false >=n ~> a
					 * false =n ~> a
					 *
					 * a <n ~> true
					 * a >n ~> true
					 * a <=n ~> true
					 * a >=n ~> true
					 * a =n ~> true
					 *
					 * a <n ~> false
					 * a >n ~> false
					 * a <=n ~> false
					 * a >=n ~> false
					 * a =n ~> false
					 *
					 * true <n ~> a
					 * true >n ~> a
					 * true <=n ~> a
					 * true >=n ~> a
					 * true =n ~> a
					 *
					 * false <n ~> a
					 * false >n ~> a
					 * false <=n ~> a
					 * false >=n ~> a
					 * false =n ~> a
					 */
					return visitLeadsTo(parentNode);
				}

				@Override
				public Void visitBoundedRepetition(BoundedRepetitionNode parentNode) { // TODO.
					Bound bound = parentNode.getBound();
					boolean boundGreaterThanZero = bound.getBoundValue().compareTo(BigInteger.ZERO) > 0;

					BooleanValueWrapperNode replacement = null;
					if (booleanChildNode.isTrue()) {
						/*
						 * #[* n](False) (* in {<, <=, =, >, >=}).
						 * Since the repeat condition is always True in any trace t,
						 * it will always occur length(t) times (total).
						 * The assumption below is that length(t) > 0 for any trace t.
						 */
						switch (bound.getBoundType()) {
						case GREATER_THAN: // #[>n](True) ==> True.
							replacement = BooleanValueWrapperNode.trueWrapper();
							break;
						case LESS_THAN_OR_EQUAL_TO: // #[<=n](True) ==> BooleanNode(n > 0) (will occur at least 1 time).
						case GREATER_THAN_OR_EQUAL_TO: // #[>=n](True) ==> BooleanNode(n > 0) (will occur at least 1 time).
						case LESS_THAN: // #[<n](True) ==> BooleanNode(n > 0) (will occur at least 1 time).
						case EQUALS: // #[=n](True) ==> BooleanNode(n > 0) (will occur at least 1 time).
							replacement = BooleanValueWrapperNode.of(boundGreaterThanZero);
							break;
						}
					} else {
						/*
						 * #[* n](False) (* in {<, <=, =, >, >=}).
						 * Since the repeat condition is always False in any trace t,
						 * it will always occur 0 times.
						 */
						switch (bound.getBoundType()) {
						case EQUALS: // #[=n](False) ==> Boolean(n == 0).
						case GREATER_THAN_OR_EQUAL_TO: // #[>=n](False) ==> Boolean(n == 0).
							replacement = BooleanValueWrapperNode.of(!boundGreaterThanZero);
							break;
						case LESS_THAN: // #[<n](False) ==> Boolean(n > 0).
							replacement = BooleanValueWrapperNode.of(boundGreaterThanZero);
							break;
						case LESS_THAN_OR_EQUAL_TO: // #[<=n](False) ==> True (occurs exactly 0 times and n is at least 0).
							replacement = BooleanValueWrapperNode.trueWrapper();
							break;
						case GREATER_THAN: // #[>n](False) = False (never occurs more than 0 times and n is at least 0).
							replacement = BooleanValueWrapperNode.falseWrapper();
							break;
						}
					}

					if (replacement != null) {
						normalizedExpression.replaceDescendant(parentNode, replacement);
						booleanLeafNodeDeque.addFirst(replacement);
					}

					return null;
				}

				@Override
				public Void visitLeadsTo(LeadsToNode parentNode) {
					AbsBooleanInternalNode rightChild = parentNode.getChildContainer().getRightChild();
					AbsBooleanInternalNode leftChild = parentNode.getChildContainer().getLeftChild();
					boolean rightChildIsBoolValue = rightChild == booleanChildNode;

					if (booleanChildNode.isTrue()) {
						if (rightChildIsBoolValue) { // p ~> True ==> True.
							BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.trueWrapper();
							normalizedExpression.replaceDescendant(parentNode, replacementNode);
							booleanLeafNodeDeque.addFirst(replacementNode);
						} else { // True ~> p ==> p.
							normalizedExpression.replaceDescendant(parentNode, rightChild);
						}
					} else {
						if (rightChildIsBoolValue) { // p ~> False ==> not(p).
							normalizedExpression.replaceDescendant(parentNode, leftChild);
							leftChild.setNegated(true);
							// Get rid of the new negation:
							renormalizeSubtree(leftChild);
						} else { // False ~> p ==> True.
							BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.trueWrapper();
							normalizedExpression.replaceDescendant(parentNode, replacementNode);
							booleanLeafNodeDeque.addFirst(replacementNode);
						}
					}

					return null;
				}

				@Override
				public Void visitConjunction(ConjunctionNode parentNode) {
					AbsBooleanInternalNode rightChild = parentNode.getChildContainer().getRightChild();
					AbsBooleanInternalNode leftChild = parentNode.getChildContainer().getLeftChild();
					boolean rightChildIsBoolValue = rightChild == booleanChildNode;

					if (booleanChildNode.isTrue()) { // True and x ==> x.
						normalizedExpression.replaceDescendant(parentNode, rightChildIsBoolValue ? leftChild : rightChild);
					} else { // False and x ==> False.
						BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.falseWrapper();
						normalizedExpression.replaceDescendant(parentNode, replacementNode);
						booleanLeafNodeDeque.addFirst(replacementNode);
					}

					return null;
				}

				@Override
				public Void visitDisjunction(DisjunctionNode parentNode) {
					AbsBooleanInternalNode rightChild = parentNode.getChildContainer().getRightChild();
					AbsBooleanInternalNode leftChild = parentNode.getChildContainer().getLeftChild();
					boolean rightChildIsBoolValue = rightChild == booleanChildNode;

					if (booleanChildNode.isTrue()) { // True or x ==> True.
						BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.trueWrapper();
						normalizedExpression.replaceDescendant(parentNode, replacementNode);
						booleanLeafNodeDeque.addFirst(replacementNode);
					} else { // False or x ==> x.
						normalizedExpression.replaceDescendant(parentNode, rightChildIsBoolValue ? leftChild : rightChild);
					}

					return null;
				}

				@Override
				public Void visitEquivalence(EquivalenceNode node) {
					// Not possible in a normalized expression.
					// p <-> q ==> p -> q and q -> p ==> (...).
					return null;
				}

				@Override
				public Void visitGroup(GroupNode node) {
					// Not possible in a normalized expression.
					// (p) ==> p.
					return null;
				}

				@Override
				public Void visitImplication(ImplicationNode node) {
					// Not possible in a normalized expression.
					// p -> q ==> not(p) or q.
					return null;
				}

				@Override
				public Void visitUniversalQuantification(UniversalQuantificationNode node) {
					// Not possible in a normalized expression.
					// quantifier(Boolean) -> new Boolean.
					return null;
				}

				@Override
				public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
					// Not possible in a normalized expression.
					// quantifier(Boolean) -> new Boolean.
					return null;
				}

				@Override
				public Void visitValueWrapper(BooleanValueWrapperNode node) {
					// Not possible in context: BooleanValueWrapperNode cannot have BooleanValueWrapperNode as its parent.
					return null;
				}
			});
		}
	}

	private static Deque<BooleanValueWrapperNode> normalizeExpressionSubtree(TdlExpression expression, AbsBooleanInternalNode subtreeRoot) {
		CollectionBuilder<BooleanValueWrapperNode, LinkedList<BooleanValueWrapperNode>> dequeBuilder = CollectionUtils
				.collectionBuilder(new LinkedList<BooleanValueWrapperNode>());
		subtreeRoot.accept(new BaseBooleanNodeVisitor<Void>() {
			@Override
			public Void visitValueWrapper(BooleanValueWrapperNode valueWrapper) {
				dequeBuilder.add(valueWrapper);
				return null;
			}

			@Override
			public Void visitGroup(GroupNode group) {
				AbsBooleanInternalNode<?, ?> child = group.getChildContainer().getChild();
				expression.replaceDescendant(group, child);
				child.setNegated(child.isNegated() ^ group.isNegated());
				return child.accept(this);
			}

			@Override
			public Void visitConjunction(ConjunctionNode conjunction) {
				if (!conjunction.isNegated())
					return visitChildren(conjunction);

				DisjunctionNode disjunction = new DisjunctionNode();
				expression.replaceDescendant(conjunction, disjunction);

				AbsBooleanInternalNode leftChild = conjunction.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = conjunction.getChildContainer().getRightChild();

				leftChild.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());

				disjunction.getChildContainer()
						.setLeftChild(leftChild)
						.setRightChild(rightChild);

				return visitChildren(disjunction);
			}

			@Override
			public Void visitDisjunction(DisjunctionNode disjunction) {
				if (!disjunction.isNegated())
					return visitChildren(disjunction);

				ConjunctionNode conjunction = new ConjunctionNode();
				expression.replaceDescendant(disjunction, conjunction);

				AbsBooleanInternalNode leftChild = disjunction.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = disjunction.getChildContainer().getRightChild();
				leftChild.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());

				conjunction.getChildContainer()
						.setLeftChild(leftChild)
						.setRightChild(rightChild);

				return visitChildren(conjunction);
			}

			@Override
			public Void visitImplication(ImplicationNode implication) {
				DisjunctionNode disjunction = new DisjunctionNode();
				expression.replaceDescendant(implication, disjunction);

				AbsBooleanInternalNode leftChild = implication.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = implication.getChildContainer().getRightChild();
				leftChild.setNegated(!leftChild.isNegated());

				disjunction.setNegated(implication.isNegated());
				disjunction.getChildContainer().setLeftChild(leftChild);
				disjunction.getChildContainer().setRightChild(rightChild);

				return visitDisjunction(disjunction);
			}

			@Override
			public Void visitEquivalence(EquivalenceNode equivalence) {
				ImplicationNode implyLTR = new ImplicationNode();
				implyLTR.getChildContainer()
						.setLeftChild(equivalence.getChildContainer().getLeftChild())
						.setRightChild(equivalence.getChildContainer().getRightChild());

				ImplicationNode implyRTL = new ImplicationNode();
				implyRTL.getChildContainer()
						.setLeftChild(equivalence.getChildContainer().getRightChild().deepClone())
						.setRightChild(equivalence.getChildContainer().getLeftChild().deepClone());

				ConjunctionNode conjunction = new ConjunctionNode();
				conjunction.setNegated(equivalence.isNegated());
				conjunction.getChildContainer()
						.setLeftChild(implyLTR)
						.setRightChild(implyRTL);

				expression.replaceDescendant(equivalence, conjunction);
				return visitConjunction(conjunction);
			}

			@Override
			public Void visitBoundedRepetition(BoundedRepetitionNode boundedRepetition) {
				if (!boundedRepetition.isNegated())
					return visitChildren(boundedRepetition);
				/*
				 * not(#a(>n))      ==> #a(<=n)
				 * not(#a(<n))      ==> #a(>=n)
				 * not(#a(>=n))     ==> #a(<n)
				 * not(#a(<=n))     ==> #a(>n)
				 * not(#a(=n))      ==> #a(<n) or #a(>n)
				 */
				Bound bound = boundedRepetition.getBound();
				switch (bound.getBoundType()) {
					case GREATER_THAN:
						bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
						boundedRepetition.setNegated(false);
						return visitChildren(boundedRepetition);
					case LESS_THAN:
						bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
						boundedRepetition.setNegated(false);
						return visitChildren(boundedRepetition);
					case GREATER_THAN_OR_EQUAL_TO:
						bound.setBoundType(EBoundType.LESS_THAN);
						boundedRepetition.setNegated(false);
						return visitChildren(boundedRepetition);
					case LESS_THAN_OR_EQUAL_TO:
						bound.setBoundType(EBoundType.GREATER_THAN);
						boundedRepetition.setNegated(false);
						return visitChildren(boundedRepetition);
					case EQUALS:
						DisjunctionNode disjunction = new DisjunctionNode();
						expression.replaceDescendant(boundedRepetition, disjunction);

						bound.setBoundType(EBoundType.LESS_THAN);
						boundedRepetition.setNegated(false);
						BoundedRepetitionNode boundedRepetitionClone = boundedRepetition.deepClone();
						boundedRepetitionClone.getBound().setBoundType(EBoundType.GREATER_THAN);

						disjunction.getChildContainer().setLeftChild(boundedRepetition);
						disjunction.getChildContainer().setRightChild(boundedRepetitionClone);

						return visitChildren(disjunction);
				}

				return visitChildren(boundedRepetition);
			}

			@Override
			public Void visitLeadsTo(LeadsToNode leadsTo) {
				if (!leadsTo.isNegated())
					return visitChildren(leadsTo);
				// not(a ~> b) ==> not(a) or (a ~> not(b)).
				DisjunctionNode disjunction = new DisjunctionNode();
				expression.replaceDescendant(leadsTo, disjunction);

				AbsBooleanInternalNode leftChild = leadsTo.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = leadsTo.getChildContainer().getRightChild();

				AbsBooleanInternalNode leftChildClone = leftChild.deepClone();
				leftChildClone.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());
				leadsTo.setNegated(false);

				disjunction.getChildContainer().setLeftChild(leftChildClone);
				disjunction.getChildContainer().setRightChild(leadsTo);

				return visitDisjunction(disjunction);
			}

			@Override
			public Void visitBoundedLeadsTo(BoundedLeadsToNode boundedLeadsTo) {
				if (!boundedLeadsTo.isNegated())
					return visitChildren(boundedLeadsTo);
				/*
				 * not(a ~>(>n) b)  ==> a ~>(<=n) b or not(a ~> b)
				 * not(a ~>(<n) b)  ==> a ~>(>=n) b or not(a ~> b)
				 * not(a ~>(>=n) b) ==> a ~>(<n) b or not(a ~> b)
				 * not(a ~>(<=n) b) ==> a ~>(>n) b or not(a ~> b)
				 * not(a ~>(=n) b)  ==> (a ~>(<n) b or a ~>(>n) b) or not(a ~> b)
				 */
				AbsBooleanInternalNode leftChild = boundedLeadsTo.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = boundedLeadsTo.getChildContainer().getRightChild();

				DisjunctionNode disjunction = new DisjunctionNode();
				LeadsToNode negatedLeadsTo = new LeadsToNode();
				negatedLeadsTo.setNegated(true);
				negatedLeadsTo.getChildContainer().setLeftChild(leftChild.deepClone());
				negatedLeadsTo.getChildContainer().setRightChild(rightChild.deepClone());

				disjunction.getChildContainer().setLeftChild(boundedLeadsTo);
				disjunction.getChildContainer().setRightChild(negatedLeadsTo);

				Bound bound = boundedLeadsTo.getBound();
				switch (bound.getBoundType()) {
					case GREATER_THAN:
						expression.replaceDescendant(boundedLeadsTo, disjunction);
						bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
						break;
					case LESS_THAN:
						expression.replaceDescendant(boundedLeadsTo, disjunction);
						bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
						break;
					case GREATER_THAN_OR_EQUAL_TO:
						expression.replaceDescendant(boundedLeadsTo, disjunction);
						bound.setBoundType(EBoundType.LESS_THAN);
						break;
					case LESS_THAN_OR_EQUAL_TO:
						expression.replaceDescendant(boundedLeadsTo, disjunction);
						bound.setBoundType(EBoundType.GREATER_THAN);
						break;
					case EQUALS:
						expression.replaceDescendant(boundedLeadsTo, disjunction);
						bound.setBoundType(EBoundType.GREATER_THAN);
						BoundedLeadsToNode boundedLeadsToClone = boundedLeadsTo.deepClone();
						boundedLeadsToClone.getBound().setBoundType(EBoundType.LESS_THAN);
						DisjunctionNode boundDisjunction = new DisjunctionNode();
						boundDisjunction.getChildContainer().setLeftChild(boundedLeadsToClone);
						boundDisjunction.getChildContainer().setRightChild(boundedLeadsTo);
						disjunction.getChildContainer().setLeftChild(boundDisjunction);
						disjunction.getChildContainer().setRightChild(negatedLeadsTo);
						break;
				}

				return visitDisjunction(disjunction);
			}
		});
		return dequeBuilder.build();
	}

	private static Deque<BooleanValueWrapperNode> normalizeExpressionSubtree(TdlExpression expression) {
		return normalizeExpressionSubtree(expression, expression.getRootNode());
	}

	private static List<AbsTrapsetQuantifierNode> extractTrapsetQuantifiers(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseBooleanNodeVisitor<List<AbsTrapsetQuantifierNode>>() {
			@Override
			protected List<AbsTrapsetQuantifierNode> defaultResult() {
				return CollectionUtils.newList();
			}

			@Override
			protected List<AbsTrapsetQuantifierNode> mergeResults(List<AbsTrapsetQuantifierNode> previousResult, List<AbsTrapsetQuantifierNode> nextResult) {
				if (nextResult.isEmpty())
					return previousResult;
				previousResult.addAll(nextResult);
				return previousResult;
			}

			@Override
			public List<AbsTrapsetQuantifierNode> visitExistentialQuantification(ExistentialQuantificationNode operator) {
				return CollectionUtils.newList(operator);
			}

			@Override
			public List<AbsTrapsetQuantifierNode> visitUniversalQuantification(UniversalQuantificationNode operator) {
				return CollectionUtils.newList(operator);
			}
		});
	}

	private static Map<TrapsetNode, Trapset> extractTrapsets(UtaSystem sutModel, Set<TrapsetNode> trapsetSymbols) {
		Map<TrapsetNode, Trapset> trapsetMap = new LinkedHashMap<>();

		for (AbsDeclarationStatement declarationStatement : sutModel.getDeclarations()) {
			if (declarationStatement instanceof VariableDeclaration) {
				VariableDeclaration variableDeclaration = (VariableDeclaration) declarationStatement;
				Type type = variableDeclaration.getType();
				BaseType baseType = type.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				TrapsetNode trapsetCandidate = TrapsetNode.of(variableDeclaration.getIdentifier().toString());
				if (!trapsetSymbols.contains(trapsetCandidate))
					continue;
				trapsetMap.put(
						trapsetCandidate,
						new Trapset()
								.setDeclaration(variableDeclaration)
								.setName(Identifier.of(trapsetCandidate.getName()))
				);
			} else if (declarationStatement instanceof VariableDeclarationGroup) {
				VariableDeclarationGroup variableDeclarationGroup = (VariableDeclarationGroup) declarationStatement;
				BaseType baseType = variableDeclarationGroup.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				variableDeclarationGroup.getBaseTypeExtensionMap().streamView().forEachOrdered(ext -> {
					TrapsetNode trapsetCandidate = TrapsetNode.of(ext.getIdentifier().toString());
					if (!trapsetSymbols.contains(trapsetCandidate))
						return;
					trapsetMap.put(
							trapsetCandidate,
							new Trapset()
									.setDeclaration(variableDeclarationGroup)
									.setName(Identifier.of(trapsetCandidate.getName()))
					);
				});
			}
		}

		for (Template template : sutModel.getTemplates()) {
			Set<Transition> edges = template.getLocationGraph().getEdges();
			for (Transition transition : edges) {
				TransitionLabels labels;
				if ((labels = transition.getLabels()) != null && labels.getAssignmentsLabel() != null) {
					AssignmentsLabel label = labels.getAssignmentsLabel();
					for (AbsExpression expr : label.getContent()) {
						if (expr instanceof AssignmentExpression) {
							// We will only accept basic BoolVar = (expr) updates, not chains like BoolVar1=Boolvar2=(expr) etc.
							AssignmentExpression assgExpr = (AssignmentExpression) expr;
							AbsExpression leftExpr = assgExpr.getLeftChild();
							if (!(leftExpr instanceof IdentifierExpression))
								continue;
							IdentifierExpression idExpr = (IdentifierExpression) leftExpr;
							TrapsetNode trapsetCandidate = TrapsetNode.of(idExpr.getIdentifier().toString());
							if (!trapsetMap.containsKey(trapsetCandidate))
								continue;
							boolean newTransition = trapsetMap.get(trapsetCandidate).addTrap(template, transition, assgExpr);
							// FIXME: Duplication is invalid.
						}
					}
				}
			}
		}

		return trapsetMap;
	}

	private static Map<AbsDerivedTrapsetNode, Trapset> extractDerivedTrapsets(
			UtaSystem system,
			List<AbsDerivedTrapsetNode> trapsetOperators,
			Map<TrapsetNode, Trapset> baseTrapsets
	) {
		Map<AbsDerivedTrapsetNode, Trapset> derivedTrapsets = new LinkedHashMap<>();
		for (AbsDerivedTrapsetNode<?> trapsetOperator : trapsetOperators) {
			derivedTrapsets.put(trapsetOperator, trapsetOperator.accept(new IDerivedTrapsetVisitor<Trapset>() {
				@Override
				public Trapset visitAbsoluteComplement(AbsoluteComplementNode absoluteComplement) {
					Trapset ts = baseTrapsets.get(absoluteComplement.getChildContainer().getChild());
					Identifier trapsetName = Identifier.of("AbsoluteComplementOf_" + ts.getName());
					Trapset derivedTrapset = new Trapset().setType(ETrapsetType.ABSOLUTE_COMPLEMENT).setName(trapsetName);

					for (Template tpl : system.getTemplates()) {
						for (Transition tr : tpl.getLocationGraph().getEdges()) {
							if (ts.contains(tr)) {
								if (!ts.isConditional(tr))
									continue;
								AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
										.setLeftChild(IdentifierExpression.of(trapsetName))
										.setRightChild(new NegationExpression().setChild(ts.getMarkerCondition(tr)));
								derivedTrapset.addTrap(tpl, tr, markerExpr);
							} else {
								AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
										.setLeftChild(IdentifierExpression.of(trapsetName))
										.setRightChild(LiteralConsts.TRUE);
								derivedTrapset.addTrap(tpl, tr, markerExpr);
							}
						}
					}
					return derivedTrapset;
				}

				@Override
				public Trapset visitLinkedPair(LinkedPairNode linkedPair) {
					Trapset tsA = baseTrapsets.get(linkedPair.getChildContainer().getLeftChild());
					Trapset tsB = baseTrapsets.get(linkedPair.getChildContainer().getRightChild());
					Identifier trapsetName = Identifier.of(tsA.getName() + "_LinkedPair_" + tsB.getName());
					Trapset derivedTrapset = new Trapset().setType(ETrapsetType.LINKED_PAIR).setName(trapsetName);

					for (Transition tA : tsA) {
						Template tplA = tsA.getParentTemplate(tA);
						for (Transition tB : tsB) {
							Template tpl = tsB.getParentTemplate(tB);
							if (tplA != tpl)
								continue;
							if (tpl.getLocationGraph().getTargetVertex(tA) != tpl.getLocationGraph().getSourceVertex(tB))
								continue;
							AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
									.setLeftChild(IdentifierExpression.of(trapsetName))
									.setRightChild(tsA.getMarkerCondition(tB));
							derivedTrapset.addTrap(tpl, tB, markerExpr);
						}
					}

					return derivedTrapset;
				}

				@Override
				public Trapset visitRelativeComplement(RelativeComplementNode relativeComplement) {
					Trapset tsA = baseTrapsets.get(relativeComplement.getChildContainer().getLeftChild());
					Trapset tsB = baseTrapsets.get(relativeComplement.getChildContainer().getRightChild());
					Identifier trapsetName = Identifier.of(tsA.getName() + "_RelativeComplement_" + tsB.getName());
					Trapset derivedTrapset = new Trapset().setType(ETrapsetType.RELATIVE_COMPLEMENT).setName(trapsetName);

					MAIN: for (Transition tA : tsA) {
						Template tplA = tsA.getParentTemplate(tA);
						AbsExpression conditionExpr = tsA.getMarkerCondition(tA);
						for (Transition tB : tsB) {
							if (tA == tB) {
								if (!tsB.isConditional(tB))
									continue MAIN;
								conditionExpr = new ConjunctionExpression()
										.setLeftChild(conditionExpr)
										.setRightChild(new NegationExpression().setChild(tsB.getMarkerCondition(tB)));
							}
						}
						AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
								.setLeftChild(IdentifierExpression.of(trapsetName))
								.setRightChild(conditionExpr);
						derivedTrapset.addTrap(tplA, tA, markerExpr);
					}

					return derivedTrapset;
				}
			}));
		}
		return derivedTrapsets;
	}

	private static Set<TrapsetNode> extractTrapsetSymbols(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseTdlExpressionVisitor<Set<TrapsetNode>>() {
			@Override
			public Set<TrapsetNode> visitTrapset(TrapsetNode node) {
				return CollectionUtils.newSet(node);
			}

			@Override
			protected Set<TrapsetNode> mergeResults(Set<TrapsetNode> previousResult, Set<TrapsetNode> nextResult) {
				previousResult.addAll(nextResult);
				return previousResult;
			}

			@Override
			protected Set<TrapsetNode> defaultResult() {
				return new HashSet<>();
			}
		});
	}

	private static List<AbsDerivedTrapsetNode> extractTrapsetOperators(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseTdlExpressionVisitor<List<AbsDerivedTrapsetNode>>() {
			@Override
			public List<AbsDerivedTrapsetNode> visitAbsoluteComplement(AbsoluteComplementNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			public List<AbsDerivedTrapsetNode> visitRelativeComplement(RelativeComplementNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			public List<AbsDerivedTrapsetNode> visitLinkedPair(LinkedPairNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			protected List<AbsDerivedTrapsetNode> mergeResults(List<AbsDerivedTrapsetNode> previousResult, List<AbsDerivedTrapsetNode> nextResult) {
				if (nextResult.isEmpty())
					return previousResult;
				previousResult.addAll(nextResult);
				return previousResult;
			}

			@Override
			protected List<AbsDerivedTrapsetNode> defaultResult() {
				return CollectionUtils.newList();
			}
		});
	}

	public static void main(String... args) throws ParseException, MarshallingException, InvalidSystemStructureException, EmbeddedCodeSyntaxException {
		TdlExpression expression = TdlExpressionParser.getInstance().parseInput("E(TS1; TS2) | E(!TS3)");
		UtaSystem system = UtaParser.newInstance().parse(GeneratorStub.class.getResourceAsStream("/SampleSystem.xml"));
		generate(ScenarioSpecification.of(system, expression));
	}
}
