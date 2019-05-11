package ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter;

import org.antlr.v4.runtime.tree.ParseTree;

public interface IParseTreeConverter<ResultType, RootContextType extends ParseTree> {
	ResultType convert(RootContextType ctx);
	default void reset() { }
}
