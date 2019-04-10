package ee.taltech.cs.mbt.tdl.commons.utils.functions;

@FunctionalInterface
public interface ITernaryFunction<A, B, C, R> {
	R apply(A a, B b, C c);
}
