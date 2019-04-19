package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.construction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BaseTrapsetsExtractor {
	public static BaseTrapsetsExtractor getInstance(UtaSystem system, TdlExpression expression) {
		return new BaseTrapsetsExtractor(system, expression);
	}

	private UtaSystem system;
	private TdlExpression expression;
	private BooleanFlag completionFlag = BooleanFlag.newInstance();
	private Map<TrapsetNode, BaseTrapset> baseTrapsetMap = new LinkedHashMap<>();

	private BaseTrapsetsExtractor(UtaSystem system, TdlExpression expression) {
		this.system = system;
		this.expression = expression;
	}

	private void populateTrapsetMap(UtaSystem system, Set<TrapsetNode> trapsetSymbols) {
		for (AbsDeclarationStatement declarationStatement : system.getDeclarations()) {
			if (declarationStatement instanceof VariableDeclaration) {
				VariableDeclaration variableDeclaration = (VariableDeclaration) declarationStatement;
				Type type = variableDeclaration.getType();
				BaseType baseType = type.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;
				TrapsetNode trapsetCandidate = TrapsetNode.of(variableDeclaration.getIdentifier().toString());
				if (!trapsetSymbols.contains(trapsetCandidate))
					continue;
				baseTrapsetMap.put(
						trapsetCandidate,
						(BaseTrapset) new BaseTrapset()
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
					baseTrapsetMap.put(
							trapsetCandidate,
							(BaseTrapset) new BaseTrapset()
									.setDeclaration(variableDeclarationGroup)
									.setName(Identifier.of(trapsetCandidate.getName()))
					);
				});
			}
		}

		// FIXME: If trapset is undefined in system (cannot find decl).

		for (Template template : system.getTemplates()) {
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
							if (!baseTrapsetMap.containsKey(trapsetCandidate))
								continue;
							boolean newTransition = baseTrapsetMap.get(trapsetCandidate)
									.addTrap(BaseTrap.of(template, transition, assgExpr));
							if (!newTransition) {
								// FIXME: throw something.
							}
						}
					}
				}
			}
		}
	}

	private static Set<TrapsetNode> extractTrapsetNodes(TdlExpression expression) {
		Set<TrapsetNode> trapsetNodes = new LinkedHashSet<>();
		expression.getRootNode().accept(new BaseTdlExpressionVisitor<Void>() {
			@Override
			public Void visitTrapset(TrapsetNode node) {
				trapsetNodes.add(node);
				return null;
			}
		});
		return trapsetNodes;
	}

	public Map<TrapsetNode, BaseTrapset> extract() {
		if (completionFlag.isSet())
			return baseTrapsetMap;

		Set<TrapsetNode> trapsetNodes = extractTrapsetNodes(expression);
		populateTrapsetMap(system, trapsetNodes);

		completionFlag.set();
		return baseTrapsetMap;
	}
}
