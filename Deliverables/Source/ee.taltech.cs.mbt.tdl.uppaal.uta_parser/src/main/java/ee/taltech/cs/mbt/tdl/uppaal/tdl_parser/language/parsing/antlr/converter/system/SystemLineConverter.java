package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SystemLineContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SystemProcessRefContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SystemProcessRefListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SystemProcessesListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line.ProcessRefs;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line.SystemLine;

public class SystemLineConverter extends UTALanguageBaseVisitor<SystemLine>
	implements IParseTreeConverter<SystemLine, SystemLineContext>
{
	@Override
	public SystemLine convert(SystemLineContext rootContext) throws ParseTreeStructureException {
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
