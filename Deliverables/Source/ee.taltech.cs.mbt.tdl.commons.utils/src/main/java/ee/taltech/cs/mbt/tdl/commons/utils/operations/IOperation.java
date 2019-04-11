package ee.taltech.cs.mbt.tdl.commons.utils.operations;

public interface IOperation<E extends Exception> {
	void execute() throws E;
}
