package ee.taltech.cs.mbt.tdl.commons.utils.collections.operations;

public interface IOperation<E extends Exception> {
	void execute() throws E;
}
