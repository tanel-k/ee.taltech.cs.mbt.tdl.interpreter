package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation.generic.AbsTrapsetDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Map;

public class AbsoluteComplementDeriver extends AbsTrapsetDeriver<AbsoluteComplementNode> {
	private static final String ABSOLUTE_COMPLEMENT_NAME_MODIFIER = "AbsoluteComplementOf_";

	public static AbsoluteComplementDeriver getInstance(
			UtaSystem system,
			AbsoluteComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new AbsoluteComplementDeriver(system, trapsetDerivingNode, baseTrapsetMap);
	}

	protected AbsoluteComplementDeriver(
			UtaSystem system,
			AbsoluteComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsDerivedTrapset derive(
			UtaSystem system,
			AbsoluteComplementNode absoluteComplement,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		BaseTrapset ts = baseTrapsetMap.get(absoluteComplement.getChildContainer().getChild());
		Identifier trapsetName = Identifier.of(
				ABSOLUTE_COMPLEMENT_NAME_MODIFIER + ts.getName()
		);
		AbsoluteComplementTrapset derivedTrapset = new AbsoluteComplementTrapset();
		derivedTrapset.setName(trapsetName);

		for (Template parentTemplate : system.getTemplates()) {
			for (Transition transition : parentTemplate.getLocationGraph().getEdges()) {
				if (ts.contains(transition)) {
					if (!ts.isConditional(transition))
						continue;
					AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(new NegationExpression().setChild(ts.getMarkerCondition(transition)));
					derivedTrapset.addTrap(BaseTrap.of(parentTemplate, transition, markerExpr));
				} else {
					AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(LiteralConsts.TRUE);
					derivedTrapset.addTrap(BaseTrap.of(parentTemplate, transition, markerExpr));
				}
			}
		}

		return derivedTrapset;
	}
}
