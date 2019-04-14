package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.specification.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.Trapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetTransitionLabel;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.function.TrapsetLabelingFunction;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneratorStub {
	public static void generate(ScenarioSpecification specification) {
		TdlExpression expression = specification.getTdlExpression();
		UtaSystem sutModel = specification.getSutModel();
		System.out.println(expression.getRootNode().getHeight());
		System.out.println(expression.getRootNode().getDepth());
		System.out.println(expression.getRootNode().hashCode());

		Set<TrapsetNode> trapsetSymbols = extractTrapsetSymbols(expression);
		TrapsetLabelingFunction labelingFunction = extractLabelingFunction(sutModel, trapsetSymbols);

		List<AbsTrapsetOperatorNode> trapsetOperators = extractTrapsetOperators(expression);

		/*
		 * Need to create DerivedTrapset objects:
		 * API:
		 *   coversNoEdges()
		 *   coversAllEdges()
		 * We can have a Map<AbsTrapsetOperatorNode, DerivedTrapset> derivedTrapsets;
		 *
		 * Then based on which quantifier is attached to the new trapset, we can determine if:
		 * the quantifier is always FALSE;
		 * the quantifier is always TRUE.
		 * We define a map Map<AbsTrapsetQuantifierNode, Boolean> trapsetQuantifierReplacements;
		 * Logic:
		 * if (isUniversalQuantifier and derivedTrapset.coversNoEdges())
		 *    trapsetQuantifierReplacements.put(quantifier, quantifier.isNegated());
		 *
		 * if (universalQuantifier and derivedTrapset.coversAllEdges())
		 *    trapsetQuantifierReplacements.put(quantifier, !quantifier.isNegated());
		 *
		 * if (existentialQuantifier and derivedTrapset.coversNoEdges())
		 *     trapsetQuantifierReplacements.put(quantifier, quantifier.isNegated());
		 *
		 * if (existentialQuantifier and derivedTrapset.coversAllEdges())
		 *     trapsetQuantifierReplacements.put(quantifier, !quantifier.isNegated());
		 *
		 * We first push all negations to the Quantifier level (atomic level basically).
		 * We can do this with a tree visitor:
		 * visitConjunction(ConjunctionNode c) {
		 *    AbsLogicalOperatorNode currNode = c;
		 *    if (c.isNegated()) {
		 *        DisjunctionNode d = new DisjunctionNode();
		 *        d.setLeftChild(
		 *            c.getLeftChild().setNegated(!c.getLeftChild().isNegated()
		 *        );
		 *        d.setRightChild(
		 *            c.getLeftChild().setNegated(!c.getLeftChild().isNegated()
		 *        );
		 *        c.getParent().replaceChild(c, d);
		 *        currNode = d;
		 *    }
		 *    visitChildren(currNode);
		 * }
		 * We also replace implications with disjunctions etc.
		 * We will have difficulties replacing leads to:
		 * not(a ~> b)      =? not(a) or (a ~> not(b))
		 *
		 * bounded repetition:
		 * not(#a(>n))      =? #a(<=n)
		 * not(#a(<n))      =? #a(>=n)
		 * not(#a(=n))      =? #a(<n) or #a(>n)
		 * not(#a(>=n))     =? #a(<n)
		 * not(#a(<=n))     =? #a(>n)
		 *
		 * and bounded leads to:
		 * not(a ~>(>n) b)  =? a ~>(<=n) b or not(a ~> b)
		 * not(a ~>(<n) b)  =? a ~>(>=n) b or not(a ~> b)
		 * not(a ~>(=n) b)  =? (a ~>(<n) b or a ~>(>n) b) or not(a ~> b)
		 * not(a ~>(>=n) b) =? a ~>(<n) b or not(a ~> b)
		 * not(a ~>(<=n) b) =? a ~>(>n) b or not(a ~> b)
		 *
		 * Then we run a reduction based on the FALSE/TRUE literals in the adjusted TDL expression.
		 * We can use Map<AbsExpressionNode, Boolean> reductionMap;
		 * Need to traverse expression tree bottom-up, replacing known patterns as we go.
		 * Reduction rules:
		 * not(FALSE) = TRUE
		 * not(TRUE) = FALSE
		 * FALSE or x = x
		 * FALSE and x = FALSE
		 * TRUE or x = TRUE
		 * TRUE and x = FALSE
		 * (we only use and/or rules)
		 * visitDisjunction(DisjunctionNode d) {
		 *   AbsExpressionNode left = d.getLeftChild()
		 *   if (reductionMap.containsKey(left)) {
		 *       if (reductionMap.get(left) == Boolean.TRUE) {
		 *           reductionMap.put(d, true);
		 *       } else {
		 *           d.getParent().replaceChild(d, d.getRightChild());
		 *       }
		 *       d.getParent().accept(this); ?
		 *   }
		 *   AbsExpressionNode right = d.getRightChild()
		 *   if (reductionMap.containsKey(right)) {
		 *      if (reductionMap.get(right) == Boolean.TRUE) {
		 *          reductionMap.put(d, true);
		 *      } else {
		 *          d.getParent().replaceChild(d, d.getLeftChild());
		 *      }
		 *      d.getParent().accept(this); ?
		 *   }
		 * }
		 *
		 */
		// ScenarioStubSystemFactory.DECLARED_NAME_TrapsetActivatorChannels.equals(null);
		for (AbsTrapsetOperatorNode trapsetOperatorNode : trapsetOperators) {
			trapsetOperatorNode.getChildContainer().getListView();
		}
	}

	private static TrapsetLabelingFunction extractLabelingFunction(UtaSystem sutModel, Set<TrapsetNode> trapsetSymbols) {
		TrapsetLabelingFunction labelingFunction = new TrapsetLabelingFunction();

		Map<TrapsetNode, Trapset> trapsetDeclarations = new LinkedHashMap<>();
		for (AbsDeclarationStatement declarationStatement : sutModel.getDeclarations()) {
			Trapset newDecl;
			if (declarationStatement instanceof VariableDeclaration) {
				VariableDeclaration variableDeclaration = (VariableDeclaration) declarationStatement;
				Type type = variableDeclaration.getType();
				BaseType baseType = type.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				TrapsetNode trapsetCandidate = TrapsetNode.of(variableDeclaration.getIdentifier().toString());
				if (!trapsetSymbols.contains(trapsetCandidate))
					continue;
				trapsetDeclarations.put(trapsetCandidate, Trapset.of(trapsetCandidate, variableDeclaration));
			} else if (declarationStatement instanceof VariableDeclarationGroup) {
				VariableDeclarationGroup variableDeclarationGroup = (VariableDeclarationGroup) declarationStatement;
				BaseType baseType = variableDeclarationGroup.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				variableDeclarationGroup.getBaseTypeExtensionMap().streamView().forEachOrdered(ext -> {
					TrapsetNode trapsetCandidate = TrapsetNode.of(ext.getIdentifier().toString());
					if (!trapsetSymbols.contains(trapsetCandidate))
						return;
					trapsetDeclarations.put(trapsetCandidate, Trapset.of(trapsetCandidate, variableDeclarationGroup));
				});
			}
		}

		for (Trapset trapset : trapsetDeclarations.values()) {
			labelingFunction.addMapping(trapset);
		}

		Map<TrapsetNode, Trapset> usageFlags = new HashMap<>();
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
							if (!trapsetDeclarations.containsKey(trapsetCandidate))
								continue;
							boolean duplicated = labelingFunction.addMapping(
									trapsetDeclarations.get(trapsetCandidate),
									TrapsetTransitionLabel.of(transition, assgExpr)
							);
							// FIXME: Duplication is invalid.
							System.out.println(duplicated);
						}
					}
				}
			}
		}

		return labelingFunction;
	}

	private static Set<TrapsetNode> extractTrapsetSymbols(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseTdlExpressionVisitor<Set<TrapsetNode>>() {
			@Override
			public Set<TrapsetNode> visitTrapsetSymbol(TrapsetNode node) {
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

	private static List<AbsTrapsetOperatorNode> extractTrapsetOperators(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseTdlExpressionVisitor<List<AbsTrapsetOperatorNode>>() {
			@Override
			public List<AbsTrapsetOperatorNode> visitAbsoluteComplement(AbsoluteComplementNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			public List<AbsTrapsetOperatorNode> visitRelativeComplement(RelativeComplementNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			public List<AbsTrapsetOperatorNode> visitLinkedPair(LinkedPairNode node) {
				return CollectionUtils.newList(node);
			}

			@Override
			protected List<AbsTrapsetOperatorNode> mergeResults(List<AbsTrapsetOperatorNode> previousResult, List<AbsTrapsetOperatorNode> nextResult) {
				if (nextResult.isEmpty())
					return previousResult;
				previousResult.addAll(nextResult);
				return previousResult;
			}

			@Override
			protected List<AbsTrapsetOperatorNode> defaultResult() {
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
