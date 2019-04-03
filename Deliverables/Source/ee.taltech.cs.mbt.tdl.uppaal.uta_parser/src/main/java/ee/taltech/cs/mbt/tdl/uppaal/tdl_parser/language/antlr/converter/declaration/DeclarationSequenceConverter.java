package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;

import java.util.LinkedList;
import java.util.List;

public class DeclarationSequenceConverter extends UtaLanguageBaseVisitor<List<AbsDeclarationStatement>>
		implements IParseTreeConverter<List<AbsDeclarationStatement>, DeclarationSequenceContext> {
	public static DeclarationSequenceConverter getInstance() {
		return INSTANCE;
	}

	private static final DeclarationSequenceConverter INSTANCE = new DeclarationSequenceConverter();

	private DeclarationSequenceConverter() { }

	@Override
	public List<AbsDeclarationStatement> convert(DeclarationSequenceContext ctx) {
		List<AbsDeclarationStatement> declarationStatements = new LinkedList<>();
		for (DeclarationContext declCtx : ctx.declaration()) {
			declarationStatements.add(DeclarationConverter.getInstance().convert(declCtx));
		}
		return declarationStatements;
	}
}
