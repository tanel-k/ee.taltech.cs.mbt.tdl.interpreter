package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScenarioWrapperConstructionContext {
	private int treeNodeCount = 0;
	private int trapsetNodeCount = 0;

	private BooleanFlag terminatorAdapterInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag disjunctionInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag conjunctionInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag leadsToInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag boundedLeadsToInclusionFlag = BooleanFlag.newInstance();
	private BooleanFlag boundedRepetitionInclusionFlag = BooleanFlag.newInstance();

	private ObjectIdentityMap<AbsExpressionNode, Integer> treeIndexMap = new ObjectIdentityMap<>();
	private ObjectIdentityMap<AbsDerivedTrapsetNode, Integer> trapsetIndexMap = new ObjectIdentityMap<>();

	private Map<Identifier, Integer> trapsetOccurrenceCountMap = new HashMap<>();
	private Map<Identifier, IntIterator> trapsetCounterMap = new HashMap<>();
	private Map<Identifier, AbsDerivedTrapset> derivedTrapsetMap = new HashMap<>();

	private List<Template> quantifierTemplates = new LinkedList<>();
	private List<VariableDeclaration> trapsetArrayDeclarations = new LinkedList<>();
	private List<TemplateInstantiation> templateInstantiations = new LinkedList<>();
	private List<Synchronization> globallyApplicableTransitionSynchs = new LinkedList<>();

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

	BooleanFlag getTerminatorAdapterInclusionFlag() {
		return terminatorAdapterInclusionFlag;
	}

	BooleanFlag getDisjunctionInclusionFlag() {
		return disjunctionInclusionFlag;
	}

	BooleanFlag getConjunctionInclusionFlag() {
		return conjunctionInclusionFlag;
	}

	BooleanFlag getLeadsToInclusionFlag() {
		return leadsToInclusionFlag;
	}

	BooleanFlag getBoundedRepetitionInclusionFlag() {
		return boundedRepetitionInclusionFlag;
	}

	BooleanFlag getBoundedLeadsToInclusionFlag() {
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

	public ObjectIdentityMap<AbsExpressionNode, Integer> getTreeIndexMap() {
		return treeIndexMap;
	}

	public ObjectIdentityMap<AbsDerivedTrapsetNode, Integer> getTrapsetIndexMap() {
		return trapsetIndexMap;
	}

	public Map<Identifier, AbsDerivedTrapset> getDerivedTrapsetMap() {
		return derivedTrapsetMap;
	}

	public List<Synchronization> getGloballyApplicableTransitionSynchs() {
		return globallyApplicableTransitionSynchs;
	}
}
