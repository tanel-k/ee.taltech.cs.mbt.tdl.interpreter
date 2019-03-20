package ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public interface IParseTreeConverter<ResultType, RootContextType extends ParseTree> {
	ResultType convert(RootContextType rootContext) throws ParseTreeStructureException;
	default void reset() { }
}
