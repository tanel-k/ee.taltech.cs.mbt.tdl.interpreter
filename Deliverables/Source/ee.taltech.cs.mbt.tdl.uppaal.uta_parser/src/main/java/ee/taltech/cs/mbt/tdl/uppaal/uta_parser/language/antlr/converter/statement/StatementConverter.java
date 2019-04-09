package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.statement;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration.DeclarationSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.type.BaseTypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;

public class StatementConverter extends UtaLanguageBaseVisitor<AbsStatement>
		implements IParseTreeConverter<AbsStatement, StatementContext> {
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
	public AbsStatement visitEmptyStatement(EmptyStatementContext ctx) {
		return EmptyStatement.getInstance();
	}

	@Override
	public AbsStatement visitStatementBlock(StatementBlockContext ctx) {
		DeclarationSequenceContext declarationSeqCtx = ctx.declarationSequence();
		StatementSequenceContext stmtSeqCtx = ctx.statementSequence();

		StatementBlock statementBlock = new StatementBlock();

		if (declarationSeqCtx != null) {
			statementBlock.getDeclarations().addAll(
					DeclarationSequenceConverter.getInstance().convert(declarationSeqCtx)
			);
		}

		if (stmtSeqCtx != null) {
			statementBlock.getStatements().addAll(
					StatementSequenceConverter.getInstance().convert(stmtSeqCtx)
			);
		}

		return statementBlock;
	}

	@Override
	public AbsStatement visitConditionalStatement(ConditionalStatementContext ctx) {
		ConditionalStatement conditionalStatement = new ConditionalStatement();
		conditionalStatement.setCondition(
			ExpressionConverter.getInstance()
				.convert(ctx.expression())
		);
		conditionalStatement.setPrimaryStatement(
			ctx.statement(0).accept(this)
		);
		if (ctx.statement(1) != null) {
			conditionalStatement.setAlternativeStatement(
				ctx.statement(1).accept(this)
			);
		}
		return conditionalStatement;
	}

	@Override
	public AbsStatement visitDoWhileStatement(DoWhileStatementContext ctx) {
		DoWhileLoop doWhileLoop = new DoWhileLoop();
		doWhileLoop.setCondition(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		doWhileLoop.setStatement(
			ctx.statement().accept(this)
		);
		return doWhileLoop;
	}

	@Override
	public AbsStatement visitForLoopStatement(ForLoopStatementContext ctx) {
		ForLoop forLoop = new ForLoop();
		forLoop.setInitializer(
			ExpressionConverter.getInstance()
				.convert(ctx.expression(0))
		);
		forLoop.setCondition(
			ExpressionConverter.getInstance()
				.convert(ctx.expression(1))
		);
		forLoop.setUpdate(
			ExpressionConverter.getInstance()
				.convert(ctx.expression(2))
		);
		forLoop.setStatement(
			ctx.statement().accept(this)
		);
		return forLoop;
	}

	@Override
	public AbsStatement visitWhileLoopStatement(WhileLoopStatementContext ctx) {
		WhileLoop whileLoop = new DoWhileLoop();
		whileLoop.setCondition(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		whileLoop.setStatement(
			ctx.statement().accept(this)
		);
		return whileLoop;
	}

	@Override
	public AbsStatement visitExpressionStatement(ExpressionStatementContext ctx) {
		ExpressionStatement expressionStatement = new ExpressionStatement();
		expressionStatement.setExpression(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		return expressionStatement;
	}

	@Override
	public AbsStatement visitIterationStatement(IterationStatementContext ctx) {
		BaseType baseType = BaseTypeConverter.getInstance().convert(ctx.type());
		IterationLoop iterationLoop = new IterationLoop();
		iterationLoop.setIteratedType(baseType);
		Identifier variableName = Identifier.of(ctx.IDENTIFIER_NAME().getText());
		iterationLoop.setLoopVariable(variableName);
		iterationLoop.setStatement(
			ctx.statement().accept(this)
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
