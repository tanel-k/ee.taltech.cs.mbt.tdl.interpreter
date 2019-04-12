package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.specification.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.Trapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetTransitionLabel;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.function.TrapsetLabelingFunction;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.uta_stub.ScenarioStubSystemFactory;
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

		Set<TrapsetSymbolNode> trapsetSymbols = extractTrapsetSymbols(expression);
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
		 * We first normalize the TDL expression.
		 * We can do this with a tree visitor.
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
		 *
		 * Then we run a reduction based on the FALSE/TRUE literals in the normalized TDL expression.
		 * We can use Map<AbsExpressionNode, Boolean> reductionMap;
		 * Need to traverse expression tree bottom-up, replacing known functions as we go.
		 * Reduction rules:
		 * not(FALSE) = TRUE
		 * not(TRUE) = FALSE
		 * FALSE or x = x
		 * FALSE and x = FALSE
		 * TRUE or x = TRUE
		 * TRUE and x = FALSE
		 * (we will only need and/or rules as the expression is normalized)
		 * 
		 */
		// ScenarioStubSystemFactory.DECLARED_NAME_TrapsetActivatorChannels.equals(null);
		for (AbsTrapsetOperatorNode trapsetOperatorNode : trapsetOperators) {
			trapsetOperatorNode.getOperandContainer().getListView();
		}
	}

	private static TrapsetLabelingFunction extractLabelingFunction(UtaSystem sutModel, Set<TrapsetSymbolNode> trapsetSymbols) {
		TrapsetLabelingFunction labelingFunction = new TrapsetLabelingFunction();

		Map<TrapsetSymbolNode, Trapset> trapsetDeclarations = new LinkedHashMap<>();
		for (AbsDeclarationStatement declarationStatement : sutModel.getDeclarations()) {
			Trapset newDecl;
			if (declarationStatement instanceof VariableDeclaration) {
				VariableDeclaration variableDeclaration = (VariableDeclaration) declarationStatement;
				Type type = variableDeclaration.getType();
				BaseType baseType = type.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				TrapsetSymbolNode trapsetCandidate = TrapsetSymbolNode.of(variableDeclaration.getIdentifier().toString());
				if (!trapsetSymbols.contains(trapsetCandidate))
					continue;
				trapsetDeclarations.put(trapsetCandidate, Trapset.of(trapsetCandidate, variableDeclaration));
			} else if (declarationStatement instanceof VariableDeclarationGroup) {
				VariableDeclarationGroup variableDeclarationGroup = (VariableDeclarationGroup) declarationStatement;
				BaseType baseType = variableDeclarationGroup.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				variableDeclarationGroup.getBaseTypeExtensionMap().streamView().forEachOrdered(ext -> {
					TrapsetSymbolNode trapsetCandidate = TrapsetSymbolNode.of(ext.getIdentifier().toString());
					if (!trapsetSymbols.contains(trapsetCandidate))
						return;
					trapsetDeclarations.put(trapsetCandidate, Trapset.of(trapsetCandidate, variableDeclarationGroup));
				});
			}
		}

		for (Trapset trapset : trapsetDeclarations.values()) {
			labelingFunction.addMapping(trapset);
		}

		Map<TrapsetSymbolNode, Trapset> usageFlags = new HashMap<>();
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
							TrapsetSymbolNode trapsetCandidate = TrapsetSymbolNode.of(idExpr.getIdentifier().toString());
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

	private static Set<TrapsetSymbolNode> extractTrapsetSymbols(TdlExpression expression) {
		return expression.getRootNode().accept(new BaseTdlExpressionVisitor<Set<TrapsetSymbolNode>>() {
			@Override
			public Set<TrapsetSymbolNode> visitTrapsetSymbol(TrapsetSymbolNode node) {
				return CollectionUtils.newSet(node);
			}

			@Override
			protected Set<TrapsetSymbolNode> mergeResults(Set<TrapsetSymbolNode> previousResult, Set<TrapsetSymbolNode> nextResult) {
				previousResult.addAll(nextResult);
				return previousResult;
			}

			@Override
			protected Set<TrapsetSymbolNode> defaultResult() {
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
