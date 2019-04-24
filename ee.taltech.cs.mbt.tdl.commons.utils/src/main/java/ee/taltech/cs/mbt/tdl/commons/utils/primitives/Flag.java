package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

public class Flag {
	public static Flag newInstance() {
		return newInstance(false);
	}

	public static Flag newInstance(boolean initialState) {
		return new Flag(initialState);
	}

	private boolean wrappedBoolean;

	public Flag(boolean initialState) {
		this.wrappedBoolean = initialState;
	}

	public boolean xor(Flag other) {
		return wrappedBoolean ^ other.wrappedBoolean;
	}

	public boolean or(Flag other) {
		return wrappedBoolean || other.wrappedBoolean;
	}

	public boolean and(Flag other) {
		return wrappedBoolean && other.wrappedBoolean;
	}

	public boolean flip() {
		return this.wrappedBoolean = !this.wrappedBoolean;
	}

	public void set(boolean state) {
		this.wrappedBoolean = state;
	}

	public void set() {
		this.wrappedBoolean = true;
	}

	public void unset() {
		this.wrappedBoolean = false;
	}

	public boolean isSet() {
		return this.wrappedBoolean;
	}

	public boolean isNotSet() {
		return !this.wrappedBoolean;
	}
}
