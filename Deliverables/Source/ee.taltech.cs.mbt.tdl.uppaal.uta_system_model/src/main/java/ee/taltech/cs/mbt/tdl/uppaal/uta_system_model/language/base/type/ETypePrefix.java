package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type;

/**
 * Types can be modified with a prefix that changes the behavior of variables using
 * the type.<br/>
 */
public enum ETypePrefix {
	/**
	 * Default prefix.<br/>
	 * Means "no prefix".<br/>
	 */
	NONE,
	/**
	 * Channels can be declared "urgent".<br/>
	 * Adapted from UPPAAL documentation:<br/>
	 * <i>
	 * Urgent channels are similar to regular channels,
	 * except that it is not possible to delay in the source state
	 * if it is possible to trigger a synchronization over an urgent channel.<br/>
	 * Clock guards are not allowed on edges synchronizing over urgent channels.
	 * </i>
	 */
	URGENT,
	/**
	 * Channels can be marked as "broadcast".<br/>
	 * Adapted from UPPAAL documentation:<br/>
	 * <i>
	 * Broadcast channels allow 1-to-many synchronizations.<br/>
	 * The intuition is that an edge with synchronization label e!
	 * emits a broadcast on the channel e that any enabled edge with synchronization
	 * label e? will synchronize with the emitting process.<br/>
	 * An edge with an emit-synch on a broadcast channel can always fire
	 * provided that the guard is satisfied.<br/>
	 * (Regardless of the number of enabled receiving edges.)<br/>
	 * Enabled receiving edges must synchronize.
	 * The update on receiving edges is performed left-to-right
	 * according to the order of processes given in the system definition.
	 * </i>
	 */
	BROADCAST,
	/**
	 * Integers, booleans, and arrays/records over integers and booleans
	 * can be marked as meta variables.<br/>
	 * Adapted from UPPAAL documentation:<br/>
	 * <i>
	 * Meta variables are stored in the state vector but are not
	 * considered a part of the state semantically.<br/>
	 * Two states that only differ in meta variables are considered equal.<br/>
	 * </i>
	 */
	META,
	/**
	 * Integers, booleans, and arrays/records over integers and booleans
	 * can be marked constant.
	 */
	CONSTANT;
}
