package ee.taltech.cs.mbt.tdl.commons.utils.functions;

@FunctionalInterface
public interface IBinaryConsumer<A, B> {
	void accept(A a, B b);
}
