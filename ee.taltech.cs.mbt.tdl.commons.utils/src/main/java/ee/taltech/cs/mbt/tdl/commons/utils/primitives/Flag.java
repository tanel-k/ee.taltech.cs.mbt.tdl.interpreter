package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

public class Flag {
	public static Flag newInstance() {
		return of(false);
	}

	public static Flag of(boolean initialState) {
		return new Flag(initialState);
	}

	private boolean wrappedBoolean;

	public Flag(boolean initialState) {
		this.wrappedBoolean = initialState;
	}

	public void xor(Flag other) {
		this.wrappedBoolean ^= other.wrappedBoolean;
	}

	public void or(Flag other) {
		this.wrappedBoolean |= other.wrappedBoolean;
	}

	public void and(Flag other) {
		this.wrappedBoolean &= other.wrappedBoolean;
	}

	public boolean negate() {
		return this.wrappedBoolean = !this.wrappedBoolean;
	}

	public boolean negatedValue() {
		return !this.wrappedBoolean;
	}

	public boolean xorValue(Flag other) {
		return wrappedBoolean ^ other.wrappedBoolean;
	}

	public boolean orValue(Flag other) {
		return wrappedBoolean || other.wrappedBoolean;
	}

	public boolean andValue(Flag other) {
		return wrappedBoolean && other.wrappedBoolean;
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
