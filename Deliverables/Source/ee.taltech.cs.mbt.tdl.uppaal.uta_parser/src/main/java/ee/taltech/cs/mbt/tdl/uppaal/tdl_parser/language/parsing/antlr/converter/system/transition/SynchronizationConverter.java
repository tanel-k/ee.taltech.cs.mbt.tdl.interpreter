package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ActiveSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ReactiveSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;

public class SynchronizationConverter extends UTALanguageBaseVisitor<Synchronization>
	implements IParseTreeConverter<Synchronization, UtaTransitionSynchronizationContext>
{
	public static SynchronizationConverter getInstance() {
		return INSTANCE;
	}

	private static final SynchronizationConverter INSTANCE = new SynchronizationConverter();

	private SynchronizationConverter() { }

	@Override
	public Synchronization convert(UtaTransitionSynchronizationContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public Synchronization visitActiveSynchronization(ActiveSynchronizationContext ctx) {
		Synchronization synchronization = initSynchronization(ctx.expression());
		synchronization.setActiveSync(true);
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
		synchronization.setVariableExpression(ExpressionConverter.getInstance().convert(expressionCtx));
		return synchronization;
	}
}
