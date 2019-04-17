package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

public class BooleanFlag {
	public static BooleanFlag newInstance() {
		return newInstance(false);
	}

	public static BooleanFlag newInstance(boolean state) {
		return new BooleanFlag(state);
	}

	private boolean state;

	public BooleanFlag(boolean state) {
		this.state = state;
	}

	public boolean flip() {
		return this.state = !this.state;
	}

	public void set() {
		this.state = true;
	}

	public void unset() {
		this.state = false;
	}

	public boolean isSet() {
		return this.state;
	}

	public boolean isNotSet() {
		return !this.state;
	}
}
