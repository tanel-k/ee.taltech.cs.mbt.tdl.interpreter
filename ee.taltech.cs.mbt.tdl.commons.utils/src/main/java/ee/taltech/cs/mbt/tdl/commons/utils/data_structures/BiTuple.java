package ee.taltech.cs.mbt.tdl.commons.utils.data_structures;

import java.util.Objects;

public class BiTuple<A, B> {
	public static <A, B> BiTuple<A, B> of(A a, B b) {
		return new BiTuple<>(a, b);
	}

	private A a;
	private B b;

	public BiTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getFirst() {
		return a;
	}

	public B getSecond() {
		return b;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "<" + a.toString() + ", " + b.toString() + ">";
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof BiTuple))
			return false;
		BiTuple other = (BiTuple) obj;
		return Objects.equals(a, other.a)
				&& Objects.equals(b, other.b);
	}
}
