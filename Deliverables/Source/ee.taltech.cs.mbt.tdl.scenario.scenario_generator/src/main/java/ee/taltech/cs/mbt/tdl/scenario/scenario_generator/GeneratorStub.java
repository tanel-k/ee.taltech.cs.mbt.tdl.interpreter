package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneratorStub {
	public static void generate(ScenarioSpecification specification) {
		TdlExpression expression = specification.getTdlExpression();
		UtaSystem sutModel = specification.getSutModel();

		int transitionCount = sutModel.getTemplates().stream()
				.map(Template::getLocationGraph)
				.mapToInt(DirectedMultigraph::edgeCount)
				.sum();

		Set<TrapsetNode> trapsetSymbols = extractTrapsetSymbols(expression);
		Map<TrapsetNode, Trapset> baseTrapsets = extractTrapsets(sutModel, trapsetSymbols);

		List<AbsDerivedTrapsetNode> trapsetOperators = extractTrapsetOperators(expression);
		Map<AbsDerivedTrapsetNode, Trapset> derivedTrapsets = extractDerivedTrapsets(sutModel, trapsetOperators, baseTrapsets);
		List<AbsTrapsetQuantifierNode> trapsetQuantifiers = extractTrapsetQuantifiers(expression);
		for (AbsTrapsetQuantifierNode trapsetQuantifier : trapsetQuantifiers) {
			Trapset derivedTrapset = derivedTrapsets.get(trapsetQuantifier.getChildContainer().getChild());

			Boolean replacement = trapsetQuantifier.accept(new IDerivedTrapsetQuantifierVisitor<Boolean>() {
				@Override
				public Boolean visitExistential(ExistentialQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				@Override
				public Boolean visitUniversal(UniversalQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				private Boolean visitAny(AbsTrapsetQuantifierNode quantifier) {
					if (derivedTrapset.isEmpty())
						return quantifier.isNegated();
					if (derivedTrapset.getTrapCount() == transitionCount)
						return !quantifier.isNegated();
					return null;
				}
			});

			if (replacement != null) {
				BooleanValueWrapperNode wrapper = BooleanValueWrapperNode.wrap(
						replacement
								? TrueNode.getInstance()
								: FalseNode.getInstance()
				);
				expression.replaceDescendant(trapsetQuantifier, wrapper);
			}
		}

		List<BooleanValueWrapperNode> booleanLeaves = pushNegationsToGroundLevel(expression);
		trimBooleanValues(booleanLeaves, expression);

		/*
		 * TODO:
		 * Create the result system.
		 * int treeIndex;
		 * int trapsetIndex;
		 */

		// ScenarioStubSystemFactory.DECLARED_NAME_TrapsetActivatorChannels.equals(null);
	}

	private static void trimBooleanValues(List<BooleanValueWrapperNode> booleanLeaves, TdlExpression expression) {
		// TODO

		/*
		 * List<AbsExpressionNode> leaves = extractLeafNodes(expression);
		 * Then we run a reduction based on the FALSE/TRUE literals in the adjusted TDL expression.
		 * We can use Map<AbsExpressionNode, Boolean> reductionMap;
		 * Need to traverse expression tree bottom-up, replacing known patterns as we go.
		 * Reduction rules:
		 * not(FALSE) = TRUE
		 * not(TRUE) = FALSE
		 * FALSE or x = x
		 * TRUE and x = x
		 * FALSE and x = FALSE
		 * TRUE or x = TRUE
		 *
		 * (we only use and/or rules)
		 * visitDisjunction(DisjunctionNode d) {
		 *   AbsExpressionNode left = d.getLeftChild()
		 *   Boolean reductionResult = reductionMap.get(left);
		 *   if (reductionResult != null) {
		 *       if (reductionResult) {
		 *           reductionMap.put(d, true);
		 *       } else {
		 *           d.getParent().replaceChild(d, d.getRightChild());
		 *       }
		 *       return d.getParent().accept(this); ?
		 *   }
		 *   AbsExpressionNode right = d.getRightChild();
		 *   Boolean reductionResult = reductionMap.get(right);
		 *   ...
		 *   // Else stop traversing up the tree.
		 * }
		 */
	}

	private static List<BooleanValueWrapperNode> pushNegationsToGroundLevel(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseBooleanNodeVisitor<List<BooleanValueWrapperNode>>() {
			@Override
			public List<BooleanValueWrapperNode> visitValueWrapper(BooleanValueWrapperNode valueWrapper) {
				return CollectionUtils.newList(valueWrapper);
			}

			@Override
			public List<BooleanValueWrapperNode> visitGroup(GroupNode group) {
				AbsBooleanInternalNode<?, ?> child = group.getChildContainer().getChild();
				child.setNegated(child.isNegated() ^ group.isNegated());

				expression.replaceDescendant(group, child);
				return child.accept(this);
			}

			@Override
			public List<BooleanValueWrapperNode> visitConjunction(ConjunctionNode conjunction) {
				if (!conjunction.isNegated())
					return visitChildren(conjunction);

				AbsBooleanInternalNode leftChild = conjunction.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = conjunction.getChildContainer().getRightChild();
				leftChild.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());

				DisjunctionNode disjunction = new DisjunctionNode();
				disjunction.getChildContainer()
						.setLeftChild(leftChild)
						.setRightChild(rightChild);

				expression.replaceDescendant(conjunction, disjunction);
				return visitChildren(disjunction);
			}

			@Override
			public List<BooleanValueWrapperNode> visitDisjunction(DisjunctionNode disjunction) {
				if (!disjunction.isNegated())
					return visitChildren(disjunction);

				AbsBooleanInternalNode leftChild = disjunction.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = disjunction.getChildContainer().getRightChild();
				leftChild.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());

				ConjunctionNode conjunction = new ConjunctionNode();
				conjunction.getChildContainer()
						.setLeftChild(leftChild)
						.setRightChild(rightChild);

				expression.replaceDescendant(disjunction, conjunction);
				return visitChildren(conjunction);
			}

			@Override
			public List<BooleanValueWrapperNode> visitImplication(ImplicationNode implication) {
				AbsBooleanInternalNode leftChild = implication.getChildContainer().getLeftChild();
				AbsBooleanInternalNode rightChild = implication.getChildContainer().getRightChild();
				leftChild.setNegated(!leftChild.isNegated());

				DisjunctionNode disjunction = new DisjunctionNode();
				disjunction.setNegated(implication.isNegated());
				disjunction.getChildContainer().setLeftChild(leftChild);
				disjunction.getChildContainer().setRightChild(rightChild);

				expression.replaceDescendant(implication, disjunction);
				return visitDisjunction(disjunction);
			}

			@Override
			public List<BooleanValueWrapperNode> visitEquivalence(EquivalenceNode equivalence) {
				ImplicationNode implyLTR = new ImplicationNode();
				implyLTR.getChildContainer()
						.setLeftChild(equivalence.getChildContainer().getLeftChild().deepClone())
						.setRightChild(equivalence.getChildContainer().getRightChild().deepClone());

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
			public List<BooleanValueWrapperNode> visitLeadsTo(LeadsToNode leadsTo) {
				if (!leadsTo.isNegated())
					return visitChildren(leadsTo);
				/*
				 * not(a ~> b)      =? not(a) or (a ~> not(b))
				 */
				 AbsBooleanInternalNode<?, ?> leftChild = leadsTo.getChildContainer().getLeftChild();
				 AbsBooleanInternalNode<?, ?> rightChild = leadsTo.getChildContainer().getRightChild();

				AbsBooleanInternalNode<?, ?> leftChildClone = leftChild.deepClone();
				leftChildClone.setNegated(!leftChild.isNegated());
				rightChild.setNegated(!rightChild.isNegated());
				leadsTo.setNegated(false);

				DisjunctionNode disjunction = new DisjunctionNode();
				disjunction.getChildContainer().setLeftChild(leftChildClone);
				disjunction.getChildContainer().setRightChild(leadsTo);

				return visitDisjunction(disjunction);
			}

			@Override
			public List<BooleanValueWrapperNode> visitBoundedRepetition(BoundedRepetitionNode boundedRepetition) {
				if (!boundedRepetition.isNegated())
					return visitChildren(boundedRepetition);
				/*
				 * not(#a(>n))      =? #a(<=n)
				 * not(#a(<n))      =? #a(>=n)
				 * not(#a(>=n))     =? #a(<n)
				 * not(#a(<=n))     =? #a(>n)
				 * not(#a(=n))      =? #a(<n) or #a(>n)
				 */
				Bound bound = boundedRepetition.getBound();
				boundedRepetition.setNegated(false);
				switch (bound.getBoundType()) {
				case GREATER_THAN:
					bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
					return visitChildren(boundedRepetition);
				case LESS_THAN:
					bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
					return visitChildren(boundedRepetition);
				case GREATER_THAN_OR_EQUAL_TO:
					bound.setBoundType(EBoundType.LESS_THAN);
					return visitChildren(boundedRepetition);
				case LESS_THAN_OR_EQUAL_TO:
					bound.setBoundType(EBoundType.GREATER_THAN);
					return visitChildren(boundedRepetition);
				case EQUALS:
					bound.setBoundType(EBoundType.LESS_THAN);
					BoundedRepetitionNode boundedRepetitionClone = boundedRepetition.deepClone();
					boundedRepetitionClone.getBound().setBoundType(EBoundType.GREATER_THAN);
					DisjunctionNode disjunction = new DisjunctionNode();
					disjunction.getChildContainer().setLeftChild(boundedRepetition);
					disjunction.getChildContainer().setRightChild(boundedRepetitionClone);

					expression.replaceDescendant(boundedRepetition, disjunction);
					return visitChildren(disjunction);
				}

				return visitChildren(boundedRepetition);
			}

			@Override
			public List<BooleanValueWrapperNode> visitBoundedLeadsTo(BoundedLeadsToNode boundedLeadsTo) {
				if (!boundedLeadsTo.isNegated())
					return visitChildren(boundedLeadsTo);
				/*
				 * not(a ~>(>n) b)  =? a ~>(<=n) b or not(a ~> b)
				 * not(a ~>(<n) b)  =? a ~>(>=n) b or not(a ~> b)
				 * not(a ~>(>=n) b) =? a ~>(<n) b or not(a ~> b)
				 * not(a ~>(<=n) b) =? a ~>(>n) b or not(a ~> b)
				 * not(a ~>(=n) b)  =? (a ~>(<n) b or a ~>(>n) b) or not(a ~> b)
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
					bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
					break;
				case LESS_THAN:
					bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
					break;
				case GREATER_THAN_OR_EQUAL_TO:
					bound.setBoundType(EBoundType.LESS_THAN);
					break;
				case LESS_THAN_OR_EQUAL_TO:
					bound.setBoundType(EBoundType.GREATER_THAN);
					break;
				case EQUALS:
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

				expression.replaceDescendant(boundedLeadsTo, disjunction);
				return visitDisjunction(disjunction);
			}

			@Override
			protected List<BooleanValueWrapperNode> defaultResult() {
				return CollectionUtils.newList();
			}

			@Override
			protected List<BooleanValueWrapperNode> mergeResults(List<BooleanValueWrapperNode> previousResult, List<BooleanValueWrapperNode> nextResult) {
				if (nextResult.isEmpty())
					return previousResult;
				previousResult.addAll(nextResult);
				return previousResult;
			}
		});
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
								// TODO: If literal.
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
							// TODO: If literal.
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
						AbsExpression conditionExpr = tsA.getMarkerCondition(tA); // TODO: If literal.
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
		TdlExpression expression = TdlExpressionParser.getInstance().parseInput("U(!TS3) & (E(!TS1) -> U(TS1; TS2))");
		UtaSystem system = UtaParser.newInstance().parse(GeneratorStub.class.getResourceAsStream("/SampleSystem.xml"));
		generate(ScenarioSpecification.of(system, expression));
	}
}
