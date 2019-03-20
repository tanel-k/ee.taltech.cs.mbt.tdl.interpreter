package ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IParseTreeConverter<ResultType, RootContextType extends ParseTree> {
	ResultType convert(RootContextType rootContext) throws ParseTreeStructureException;
	default void reset() { }
}
