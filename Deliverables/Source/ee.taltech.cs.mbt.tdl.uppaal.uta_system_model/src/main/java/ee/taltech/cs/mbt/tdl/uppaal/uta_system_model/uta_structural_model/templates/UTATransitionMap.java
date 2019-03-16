package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.templates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.locations.UTALocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.transitions.UTATransition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UTATransitionMap {
	public static class TransitionContainer {
		private List<UTATransition> outboundTransitions;
		private List<UTATransition> inboundTransitions;

		public TransitionContainer() {
			this.outboundTransitions = new LinkedList<>();
			this.inboundTransitions = new LinkedList<>();
		}

		public List<UTATransition> getOutboundTransitions() {
			return outboundTransitions;
		}

		public List<UTATransition> getInboundTransitions() {
			return inboundTransitions;
		}
	}

	private Map<UTALocation, TransitionContainer> transitionMap;

	public UTATransitionMap() {
		this.transitionMap = new HashMap<>();
	}

	public TransitionContainer getTransitions(UTALocation forLocation) {
		return transitionMap.get(forLocation);
	}

	public void setTransitions(UTALocation forLocation, TransitionContainer transitions) {
		transitionMap.put(forLocation, transitions);
	}
}
