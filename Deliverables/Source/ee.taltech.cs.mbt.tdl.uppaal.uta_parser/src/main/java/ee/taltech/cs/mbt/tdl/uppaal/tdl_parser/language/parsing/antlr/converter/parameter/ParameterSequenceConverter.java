package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.parameter;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.LinkedList;
import java.util.List;

public class ParameterSequenceConverter extends UtaLanguageBaseVisitor<List<ParameterDeclaration>>
	implements IParseTreeConverter<List<ParameterDeclaration>, ParameterSequenceContext> {

	public static ParameterSequenceConverter getInstance() {
		return INSTANCE;
	}

	private static final ParameterSequenceConverter INSTANCE = new ParameterSequenceConverter();

	private ParameterSequenceConverter() { }

	@Override
	public List<ParameterDeclaration> convert(ParameterSequenceContext ctx) {
		List<ParameterDeclaration> declarations = new LinkedList<>();

		for (ParameterContext parameterCtx : ctx.parameter()) {
			Type<?> parameterType = TypeConverter.getInstance().convert(parameterCtx.type());
			if (parameterCtx.referenceModifier() != null)
				parameterType.setReferenceType(true);

			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
				.convert(parameterCtx.identifierDeclaration());

			for (AbsArrayModifier arrayModifier : identifierData.getArrayModifiers()) {
				parameterType.getArrayModifiers().add(arrayModifier);
			}

			ParameterDeclaration declaration = new ParameterDeclaration();
			declaration.setType(parameterType);
			declaration.setIdentifier(identifierData.getIdentifier());

			declarations.add(declaration);
		}

		return declarations;
	}
}
