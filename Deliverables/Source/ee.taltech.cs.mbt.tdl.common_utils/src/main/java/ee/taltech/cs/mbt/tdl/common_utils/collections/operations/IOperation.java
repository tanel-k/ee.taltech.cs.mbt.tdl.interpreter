package ee.taltech.cs.mbt.tdl.common_utils.collections.operations;

public interface IOperation<E extends Exception> {
	void execute() throws E;
}
