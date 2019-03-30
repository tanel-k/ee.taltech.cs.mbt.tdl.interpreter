package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.DeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.IGroupableDeclaration;
import org.antlr.v4.codegen.model.decl.Decl;

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
			AbsDeclarationStatement declaration = DeclarationConverter.getInstance().convert(declCtx);
			if (declaration instanceof DeclarationGroup<?>) {
				for (AbsDeclarationStatement groupedDecl : (DeclarationGroup<?>) declaration) {
					declarationStatements.add(groupedDecl);
				}
			} else {
				declarationStatements.add(declaration);
			}
		}
		return declarationStatements;
	}
}
