package ee.taltech.cs.mbt.tdl.commons.utils.data_structures;

import java.util.Objects;

public class OrderedPair<FirstT, SecondT> {
	public static <FirstT, SecondT> OrderedPair<FirstT, SecondT> of(FirstT first, SecondT second) {
		return new OrderedPair<>(first, second);
	}

	private FirstT first;
	private SecondT second;

	public OrderedPair(FirstT first, SecondT second) {
		this.first = first;
		this.second = second;
	}

	public FirstT getFirst() {
		return first;
	}

	public SecondT getSecond() {
		return second;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof OrderedPair))
			return false;
		OrderedPair other = (OrderedPair) obj;
		return Objects.equals(first, other.first)
				&& Objects.equals(second, other.second);
	}
}
