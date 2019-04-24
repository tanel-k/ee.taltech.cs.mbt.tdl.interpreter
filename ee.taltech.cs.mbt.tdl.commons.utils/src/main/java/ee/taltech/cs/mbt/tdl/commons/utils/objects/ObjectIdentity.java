package ee.taltech.cs.mbt.tdl.commons.utils.objects;

import java.util.Objects;

public class ObjectIdentity<T> {
	public static <T> ObjectIdentity<T> wrap(T wrappedInstance) {
		return new ObjectIdentity<>(wrappedInstance);
	}

	private T wrappedInstance;

	private ObjectIdentity(T wrappedInstance) {
		this.wrappedInstance = wrappedInstance;
	}

	public T getWrappedInstance() {
		return wrappedInstance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), wrappedInstance);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof ObjectIdentity))
			return false;
		ObjectIdentity other = (ObjectIdentity) obj;
		// Reduce to referential equality.
		return this.wrappedInstance == other.wrappedInstance;
	}
}
