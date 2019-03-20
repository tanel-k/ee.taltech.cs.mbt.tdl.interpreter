package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr_facade.converters.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ActiveSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ReactiveSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr_facade.converters.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;
import org.antlr.v4.runtime.tree.ErrorNode;

public class SynchronizationConverter extends UTALanguageBaseVisitor<Synchronization>
	implements IParseTreeConverter<Synchronization, UtaTransitionSynchronizationContext>
{
	@Override
	public Synchronization convert(UtaTransitionSynchronizationContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public Synchronization visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
				"Synchronization subtree contains an error node (" + node.getText() + ")."
		);
	}

	@Override
	public Synchronization visitActiveSynchronization(ActiveSynchronizationContext ctx) {
		Synchronization synchronization = initSynchronization(ctx.expression());
		synchronization.setActiveSync(false);
		return synchronization;
	}

	@Override
	public Synchronization visitReactiveSynchronization(ReactiveSynchronizationContext ctx) {
		Synchronization synchronization = initSynchronization(ctx.expression());
		synchronization.setActiveSync(false);
		return synchronization;
	}

	private Synchronization initSynchronization(ExpressionContext expressionCtx) {
		Synchronization synchronization = new Synchronization();
		synchronization.setVariableExpression(new ExpressionConverter().convert(expressionCtx));
		return synchronization;
	}
}
