package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScenarioWrapperConstructionContext {
	private int treeNodeCount = 0;
	private int trapsetNodeCount = 0;

	private Flag trivialTrueInclusionFlag = Flag.newInstance();
	private Flag trivialFalseInclusionFlag = Flag.newInstance();
	private Flag disjunctionInclusionFlag = Flag.newInstance();
	private Flag conjunctionInclusionFlag = Flag.newInstance();
	private Flag leadsToInclusionFlag = Flag.newInstance();
	private Flag boundedLeadsToInclusionFlag = Flag.newInstance();
	private Flag boundedRepetitionInclusionFlag = Flag.newInstance();

	private Map<AbsExpressionNode, Integer> treeIndexMap = new ObjectIdentityMap<>();
	private Map<AbsTrapsetExpressionNode, Integer> trapsetIndexMap = new ObjectIdentityMap<>();

	private Map<Identifier, Integer> trapsetOccurrenceCountMap = new HashMap<>();
	private Map<Identifier, IntIterator> trapsetCounterMap = new HashMap<>();
	private Map<Identifier, AbsEvaluatedTrapset> trapsetEvaluationMap = new HashMap<>();

	private List<Template> quantifierTemplates = new LinkedList<>();
	private List<VariableDeclaration> trapsetArrayDeclarations = new LinkedList<>();
	private List<TemplateInstantiation> templateInstantiations = new LinkedList<>();
	private List<Synchronization> globallyApplicableTransitionSynchs = new LinkedList<>();

	ScenarioWrapperConstructionContext() { }

	int getTreeNodeCount() {
		return treeNodeCount;
	}

	void setTreeNodeCount(int treeNodeCount) {
		this.treeNodeCount = treeNodeCount;
	}

	int getTrapsetNodeCount() {
		return trapsetNodeCount;
	}

	void setTrapsetNodeCount(int trapsetNodeCount) {
		this.trapsetNodeCount = trapsetNodeCount;
	}

	Flag getTrivialTrueInclusionFlag() {
		return trivialTrueInclusionFlag;
	}

	Flag getTrivialFalseInclusionFlag() {
		return trivialFalseInclusionFlag;
	}

	Flag getDisjunctionInclusionFlag() {
		return disjunctionInclusionFlag;
	}

	Flag getConjunctionInclusionFlag() {
		return conjunctionInclusionFlag;
	}

	Flag getLeadsToInclusionFlag() {
		return leadsToInclusionFlag;
	}

	Flag getBoundedRepetitionInclusionFlag() {
		return boundedRepetitionInclusionFlag;
	}

	Flag getBoundedLeadsToInclusionFlag() {
		return boundedLeadsToInclusionFlag;
	}

	List<Template> getQuantifierTemplates() {
		return quantifierTemplates;
	}

	List<VariableDeclaration> getTrapsetArrayDeclarations() {
		return trapsetArrayDeclarations;
	}

	List<TemplateInstantiation> getTemplateInstantiations() {
		return templateInstantiations;
	}

	Map<Identifier, IntIterator> getTrapsetCounterMap() {
		return trapsetCounterMap;
	}

	Map<Identifier, Integer> getTrapsetOccurrenceCountMap() {
		return trapsetOccurrenceCountMap;
	}

	public Map<AbsExpressionNode, Integer> getTreeIndexMap() {
		return treeIndexMap;
	}

	public Map<AbsTrapsetExpressionNode, Integer> getTrapsetIndexMap() {
		return trapsetIndexMap;
	}

	public Map<Identifier, AbsEvaluatedTrapset> getTrapsetEvaluationMap() {
		return trapsetEvaluationMap;
	}

	public List<Synchronization> getGloballyApplicableTransitionSynchs() {
		return globallyApplicableTransitionSynchs;
	}
}
