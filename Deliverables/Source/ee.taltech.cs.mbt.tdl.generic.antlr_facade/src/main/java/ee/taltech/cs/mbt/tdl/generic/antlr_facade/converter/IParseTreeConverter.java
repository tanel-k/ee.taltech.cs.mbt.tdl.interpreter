package ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter;

import org.antlr.v4.runtime.tree.ParseTree;

public interface IParseTreeConverter<ResultType, RootContextType extends ParseTree> {
	public static class ConversionException extends Exception {
		public ConversionException(String msg) {
			super(msg);
		}

		public ConversionException(String msg, Throwable t) {
			super(msg, t);
		}
	}

	ResultType convert(RootContextType ctx) throws ConversionException;
	default void reset() { }
}
