package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.statement;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration.DeclarationSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.type.BaseTypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.WhileLoop;

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
		return new ConditionalStatement()
				.setCondition(ExpressionConverter.getInstance().convert(ctx.expression()))
				.setPrimaryStatement(ctx.statement(0).accept(this))
				.setAlternativeStatement(
						ctx.statement(1) != null
								? ctx.statement(1).accept(this)
								: null
				);
	}

	@Override
	public AbsStatement visitDoWhileStatement(DoWhileStatementContext ctx) {
		return new DoWhileLoop()
				.setCondition(ExpressionConverter.getInstance().convert(ctx.expression()))
				.setStatement(ctx.statement().accept(this));
	}

	@Override
	public AbsStatement visitForLoopStatement(ForLoopStatementContext ctx) {
		return new ForLoop()
				.setUpdate(ExpressionConverter.getInstance().convert(ctx.expression(2)))
				.setInitializer(ExpressionConverter.getInstance().convert(ctx.expression(0)))
				.setCondition(ExpressionConverter.getInstance().convert(ctx.expression(1)))
				.setStatement(ctx.statement().accept(this));
	}

	@Override
	public AbsStatement visitWhileLoopStatement(WhileLoopStatementContext ctx) {
		return new WhileLoop()
				.setCondition(ExpressionConverter.getInstance().convert(ctx.expression()))
				.setStatement(ctx.statement().accept(this));
	}

	@Override
	public AbsStatement visitExpressionStatement(ExpressionStatementContext ctx) {
		return new ExpressionStatement()
				.setExpression(ExpressionConverter.getInstance().convert(ctx.expression()));
	}

	@Override
	public AbsStatement visitIterationStatement(IterationStatementContext ctx) {
		return new IterationLoop()
				.setIteratedType(BaseTypeConverter.getInstance().convert(ctx.type()))
				.setLoopVariable(Identifier.of(ctx.IDENTIFIER_NAME().getText()))
				.setStatement(ctx.statement().accept(this));
	}

	@Override
	public AbsStatement visitStatementReturn(StatementReturnContext ctx) {
		return new ReturnStatement()
				.setExpression(
						ctx.expression() != null
						? ExpressionConverter.getInstance().convert(ctx.expression())
						: null
				);
	}
}
