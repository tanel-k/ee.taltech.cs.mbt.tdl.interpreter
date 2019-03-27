package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemLineContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessGroupContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemProcessSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SystemLineConverter extends UtaLanguageBaseVisitor<SystemLine>
	implements IParseTreeConverter<SystemLine, SystemLineContext> {
	public static SystemLineConverter getInstance() {
		return INSTANCE;
	}

	private static final SystemLineConverter INSTANCE = new SystemLineConverter();

	private SystemLineConverter() { }

	@Override
	public SystemLine convert(SystemLineContext ctx) {
		SystemProcessSequenceContext processSeqCtx = ctx.systemProcessSequence();
		SystemLine systemLine = new SystemLine();

		for (SystemProcessGroupContext processGroup : processSeqCtx.systemProcessGroup()) {
			ProcessReferenceGroup processReferenceGroup = new ProcessReferenceGroup();
			for (TerminalNode processName : processGroup.IDENTIFIER_NAME()) {
				Identifier processIdentifier = new Identifier();
				processIdentifier.setText(processName.getText());
				processReferenceGroup.getProcessIdentifiers().add(processIdentifier);
			}
			systemLine.getProcessPrioritySequence().add(processReferenceGroup);
		}

		return systemLine;
	}
}
