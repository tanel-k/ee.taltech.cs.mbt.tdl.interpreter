package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemLineContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessRefContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessRefListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessesListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line.ProcessReferenceGroup;
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
			ProcessReferenceGroup processReferenceGroup = new ProcessReferenceGroup();
			for (SystemProcessRefContext processExpressionCtx : refsCtx.systemProcessRef()) {
				IdentifierName processIdentifier = new IdentifierName();
				processIdentifier.setName(processExpressionCtx.IDENTIFIER_NAME().getText());
				processReferenceGroup.getProcessIdentifiers().add(processIdentifier);
			}
			systemLine.getProcessPrioritySequence().add(processReferenceGroup);
		}

		return systemLine;
	}
}
