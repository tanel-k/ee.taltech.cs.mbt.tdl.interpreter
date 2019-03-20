package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.DeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaDeclarationsContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.declaration.DeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedList;
import java.util.List;

public class DeclarationsConverter extends UTALanguageBaseVisitor<List<AbsDeclarationStatement>>
	implements IParseTreeConverter<List<AbsDeclarationStatement>, UtaDeclarationsContext>
{
	@Override
	public List<AbsDeclarationStatement> convert(UtaDeclarationsContext rootContext) throws ParseTreeStructureException {
		List<AbsDeclarationStatement> declarationStatements = new LinkedList<>();
		if (rootContext.declarationSequence() != null) {
			for (DeclarationContext declCtx : rootContext.declarationSequence().declaration()) {
				declarationStatements.add(new DeclarationConverter().convert(declCtx));
			}
		}
		return declarationStatements;
	}
}
