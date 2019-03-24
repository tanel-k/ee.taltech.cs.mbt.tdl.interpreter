package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemLineContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessRefContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessRefListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessesListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line.ProcessRefs;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line.SystemLine;

public class SystemLineConverter extends UtaLanguageBaseVisitor<SystemLine>
	implements IParseTreeConverter<SystemLine, SystemLineContext>
{
	public static SystemLineConverter getInstance() {
		return INSTANCE;
	}

	private static final SystemLineConverter INSTANCE = new SystemLineConverter();

	private SystemLineConverter() { }

	@Override
	public SystemLine convert(SystemLineContext rootContext) {
		SystemProcessesListContext systemProcessesCtx = rootContext.systemProcessesList();
		SystemLine systemLine = new SystemLine();

		for (SystemProcessRefListContext refsCtx : systemProcessesCtx.systemProcessRefList()) {
			ProcessRefs processRefs = new ProcessRefs();
			for (SystemProcessRefContext processExpressionCtx : refsCtx.systemProcessRef()) {
				IdentifierName processIdentifier = new IdentifierName();
				processIdentifier.setName(processExpressionCtx.IDENTIFIER_NAME().getText());
				processRefs.getProcessIdentifiers().add(processIdentifier);
			}
			systemLine.getProcessPrioritySequence().add(processRefs);
		}

		return systemLine;
	}
}
