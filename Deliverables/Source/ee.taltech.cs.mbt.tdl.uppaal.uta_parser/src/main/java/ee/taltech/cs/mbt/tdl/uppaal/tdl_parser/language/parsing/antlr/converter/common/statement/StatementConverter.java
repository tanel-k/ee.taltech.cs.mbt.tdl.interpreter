package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.statement;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration.DeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

public class StatementConverter extends UtaLanguageBaseVisitor<AbsStatement>
	implements IParseTreeConverter<AbsStatement, StatementContext>
{
	public static StatementConverter getInstance() {
		return INSTANCE;
	}

	private static final StatementConverter INSTANCE = new StatementConverter();

	private StatementConverter() { }

	@Override
	public AbsStatement convert(StatementContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsStatement visitStatementEmpty(StatementEmptyContext ctx) {
		return new EmptyStatement();
	}

	@Override
	public AbsStatement visitStatementBlock(StatementBlockContext ctx) {
		BlockOfStatementsContext nestedContext = ctx.blockOfStatements();
		StatementBlock statementBlock = new StatementBlock();
		if (nestedContext.statement() != null) {
			for (StatementContext statementCtx : nestedContext.statement()) {
				statementBlock.getStatements().add(statementCtx.accept(this));
			}
		}
		if (nestedContext.declarationSequence() != null) {
			for (DeclarationContext declarationContext : nestedContext.declarationSequence().declaration()) {
				statementBlock.getDeclarations().add(
					DeclarationConverter.getInstance().convert(declarationContext)
				);
			}
		}
		return statementBlock;
	}

	@Override
	public AbsStatement visitStatementConditional(StatementConditionalContext ctx) {
		ConditionalStatement conditionalStatement = new ConditionalStatement();
		conditionalStatement.setCondition(
			ExpressionConverter.getInstance()
				.convert(ctx.expression())
		);
		conditionalStatement.setPrimaryStatement(
			ctx.primaryStatement().accept(this)
		);
		if (ctx.alternativeStatement() != null) {
			conditionalStatement.setAlternativeStatement(
				ctx.alternativeStatement().accept(this)
			);
		}
		return conditionalStatement;
	}

	@Override
	public AbsStatement visitStatementDoWhile(StatementDoWhileContext ctx) {
		DoWhileLoop doWhileLoop = new DoWhileLoop();
		doWhileLoop.setCondition(
			ExpressionConverter.getInstance().convert(ctx.loopCondition().expression())
		);
		doWhileLoop.setStatement(
			ctx.loopBody().statement().accept(this)
		);
		return doWhileLoop;
	}

	@Override
	public AbsStatement visitStatementForLoop(StatementForLoopContext ctx) {
		ForLoop forLoop = new ForLoop();
		forLoop.setInitializer(
			ExpressionConverter.getInstance()
				.convert(ctx.loopInitializer().expression())
		);
		forLoop.setCondition(
			ExpressionConverter.getInstance()
				.convert(ctx.loopCondition().expression())
		);
		forLoop.setUpdate(
			ExpressionConverter.getInstance()
				.convert(ctx.loopUpdate().expression())
		);
		forLoop.setStatement(
			ctx.loopBody().statement().accept(this)
		);
		return forLoop;
	}

	@Override
	public AbsStatement visitStatementWhileLoop(StatementWhileLoopContext ctx) {
		WhileLoop whileLoop = new DoWhileLoop();
		whileLoop.setCondition(
			ExpressionConverter.getInstance().convert(ctx.loopCondition().expression())
		);
		whileLoop.setStatement(
			ctx.loopBody().statement().accept(this)
		);
		return whileLoop;
	}

	@Override
	public AbsStatement visitStatementExpression(StatementExpressionContext ctx) {
		ExpressionStatement expressionStatement = new ExpressionStatement();
		expressionStatement.setExpression(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		return expressionStatement;
	}

	@Override
	public AbsStatement visitStatementIteration(StatementIterationContext ctx) {
		IterationLoop<AbsTypeId> iterationLoop = new IterationLoop<>();
		iterationLoop.setIteratedType(
			TypeConverter.getInstance().convert(ctx.type())
		);
		Identifier loopVar = new Identifier();
		loopVar.setName(ctx.IDENTIFIER_NAME().getText());
		iterationLoop.setLoopVariable(loopVar);
		iterationLoop.setStatement(
			ctx.loopBody().accept(this)
		);
		return iterationLoop;
	}

	@Override
	public AbsStatement visitStatementReturn(StatementReturnContext ctx) {
		ReturnStatement returnStatement = new ReturnStatement();
		if (ctx.expression() != null) {
			returnStatement.setExpression(
				ExpressionConverter.getInstance().convert(ctx.expression())
			);
		}
		return returnStatement;
	}
}
