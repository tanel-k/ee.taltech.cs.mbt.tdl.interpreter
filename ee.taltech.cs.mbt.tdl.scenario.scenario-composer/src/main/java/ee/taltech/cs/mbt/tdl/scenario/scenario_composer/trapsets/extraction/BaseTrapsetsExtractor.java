package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.TransitionLabels;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseTrapsetsExtractor {
	public static class InvalidBaseTrapsetDefinitionException extends Exception {
		private static final String MSG_FORMAT = "Invalid trapset definition %s: %s.";

		private static String formattedMessage(TrapsetNode node, String errMsg) {
			return String.format(MSG_FORMAT, node.getName(), errMsg);
		}

		InvalidBaseTrapsetDefinitionException(TrapsetNode node, String errMsg) {
			super(formattedMessage(node, errMsg));
		}

		InvalidBaseTrapsetDefinitionException(String msg) {
			super(msg);
		}
	}

	public static class DuplicateLabelingException extends InvalidBaseTrapsetDefinitionException {
		public static final String MSG_FORMAT = "System/%s/%s->%s has been labeled more than once";

		private static String formattedMessage(Template template, Transition transition) {
			String locSrc = transition.getSource().getName() != null
					? transition.getSource().getName().getName()
					: transition.getSource().getId();
			String locTgt = transition.getTarget().getName() != null
					? transition.getTarget().getName().getName()
					: transition.getTarget().getId();
			return String.format(MSG_FORMAT, template.getName(), locSrc, locTgt);
		}

		DuplicateLabelingException(TrapsetNode node, Template template, Transition transition) {
			super(node, formattedMessage(template, transition));
		}
	}

	public static class MissingTrapsetDeclarationException extends InvalidBaseTrapsetDefinitionException {
		MissingTrapsetDeclarationException(TrapsetNode node) {
			super(node, "missing global declaration");
		}
	}

	public static BaseTrapsetsExtractor getInstance(UtaSystem system, TdlExpression expression) {
		return new BaseTrapsetsExtractor(system, expression);
	}

	private static void removeTrapsetMarkers(UtaSystem system, Collection<BaseTrapset> baseTrapsets) {
		Map<Identifier, Boolean> cleanupFlags = new HashMap<>();
		List<AbsDeclarationStatement> globalDeclarations = system.getDeclarations();
		for (BaseTrapset trapset : baseTrapsets) {
			if (cleanupFlags.getOrDefault(trapset.getName(), Boolean.FALSE))
				continue;

			// Remove trapset marker variable declaration:
			AbsDeclarationStatement trapsetArrayDeclaration = trapset.getDeclaration();
			if (trapsetArrayDeclaration instanceof VariableDeclarationGroup) {
				VariableDeclarationGroup group = (VariableDeclarationGroup) trapsetArrayDeclaration;
				group.removeItem(trapset.getName());

				// Retain group as until it's empty (may contain unrelated variable decls):
				if (group.getBaseTypeExtensionMap().isEmpty()) {
					globalDeclarations.remove(group);
				}
			} else {
				globalDeclarations.remove(trapsetArrayDeclaration);
			}

			// Remove marker assignments from transitions:
			for (Transition transition : trapset) {
				Collection<AbsExpression> transitionAssignments = transition
						.getLabels()
						.getAssignmentsLabel()
						.getContent();
				AssignmentExpression transitionAssignment = trapset.getMarkerAssignment(transition);
				transitionAssignments.remove(transitionAssignment);
			}

			cleanupFlags.put(trapset.getName(), Boolean.TRUE);
		}
	}

	private static Set<TrapsetNode> collectTrapsetNodes(TdlExpression expression) {
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

	private final Flag completionFlag = Flag.newInstance();

	private final UtaSystem system;
	private final TdlExpression expression;
	private final Map<TrapsetNode, BaseTrapset> baseTrapsetMap = new LinkedHashMap<>();

	private BaseTrapsetsExtractor(UtaSystem system, TdlExpression expression) {
		this.system = system;
		this.expression = expression;
	}

	private void populateTrapsetMap() throws InvalidBaseTrapsetDefinitionException {
		Set<TrapsetNode> trapsetNodes = collectTrapsetNodes(expression);
		for (AbsDeclarationStatement declarationStatement : system.getDeclarations()) {
			if (declarationStatement instanceof VariableDeclaration) {
				VariableDeclaration variableDeclaration = (VariableDeclaration) declarationStatement;
				Type type = variableDeclaration.getType();
				BaseType baseType = type.getBaseType();
				if (!BaseTypeIdentifiers.BOOLEAN.equals(baseType.getTypeId()))
					continue;

				TrapsetNode trapsetCandidate = TrapsetNode.of(variableDeclaration.getIdentifier().toString());
				if (!trapsetNodes.contains(trapsetCandidate))
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
					if (!trapsetNodes.contains(trapsetCandidate))
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

		for (TrapsetNode trapsetNode : trapsetNodes) {
			if (!baseTrapsetMap.containsKey(trapsetNode)) {
				throw new MissingTrapsetDeclarationException(trapsetNode);
			}
		}

		for (Template template : system.getTemplates()) {
			Set<Transition> transitions = template.getLocationGraph().getEdges();
			for (Transition transition : transitions) {
				TransitionLabels labels;
				if ((labels = transition.getLabels()) != null && labels.getAssignmentsLabel() != null) {
					AssignmentsLabel label = labels.getAssignmentsLabel();
					for (AbsExpression expr : label.getContent()) {
						// We will only accept basic BoolVar=<expr> markers, not chains like Var1=Var2=<expr> etc.
						if (!(expr instanceof AssignmentExpression))
							continue;

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
							throw new DuplicateLabelingException(trapsetCandidate, template, transition);
						}
					}
				}
			}
		}
	}

	public Map<TrapsetNode, BaseTrapset> extract() throws InvalidBaseTrapsetDefinitionException {
		if (completionFlag.isSet())
			return baseTrapsetMap;

		populateTrapsetMap();
		// Markers just clutter the result-system, remove them after consumption:
		removeTrapsetMarkers(system, baseTrapsetMap.values());

		completionFlag.set();
		return baseTrapsetMap;
	}
}
