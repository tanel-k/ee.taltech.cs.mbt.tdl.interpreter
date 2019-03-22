package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.statement;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration.DeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class StatementConverter extends UTALanguageBaseVisitor<AbsStatement>
	implements IParseTreeConverter<AbsStatement, StatementContext>
{
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
					new DeclarationConverter().convert(declarationContext)
				);
			}
		}
		return statementBlock;
	}

	@Override
	public AbsStatement visitStatementConditional(StatementConditionalContext ctx) {
		ConditionalStatement conditionalStatement = new ConditionalStatement();
		conditionalStatement.setConditionExpression(
			new ExpressionConverter()
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
		doWhileLoop.setLoopCondition(
			new ExpressionConverter().convert(ctx.loopCondition().expression())
		);
		doWhileLoop.setBody(
			ctx.loopBody().statement().accept(this)
		);
		return doWhileLoop;
	}

	@Override
	public AbsStatement visitStatementForLoop(StatementForLoopContext ctx) {
		ForLoop forLoop = new ForLoop();
		forLoop.setInitializer(
			new ExpressionConverter()
				.convert(ctx.loopInitializer().expression())
		);
		forLoop.setLoopCondition(
			new ExpressionConverter()
				.convert(ctx.loopCondition().expression())
		);
		forLoop.setUpdate(
			new ExpressionConverter()
				.convert(ctx.loopUpdate().expression())
		);
		forLoop.setBody(
			ctx.loopBody().statement().accept(this)
		);
		return forLoop;
	}

	@Override
	public AbsStatement visitStatementWhileLoop(StatementWhileLoopContext ctx) {
		WhileLoop whileLoop = new DoWhileLoop();
		whileLoop.setLoopCondition(
			new ExpressionConverter()
				.convert(ctx.loopCondition().expression())
		);
		whileLoop.setBody(
			ctx.loopBody().statement().accept(this)
		);
		return whileLoop;
	}

	@Override
	public AbsStatement visitStatementExpression(StatementExpressionContext ctx) {
		ExpressionStatement expressionStatement = new ExpressionStatement();
		expressionStatement.setExpression(
			new ExpressionConverter().convert(ctx.expression())
		);
		return expressionStatement;
	}

	@Override
	public AbsStatement visitStatementIteration(StatementIterationContext ctx) {
		IterationLoop<AbsTypeIdentifier> iterationLoop = new IterationLoop<>();
		iterationLoop.setIteratedType(
			new TypeConverter()
				.convert(ctx.type())
		);
		IdentifierName loopVar = new IdentifierName();
		loopVar.setName(ctx.IDENTIFIER_NAME().getText());
		iterationLoop.setLoopVariable(loopVar);
		iterationLoop.setBody(
			ctx.loopBody().accept(this)
		);
		return iterationLoop;
	}

	@Override
	public AbsStatement visitStatementReturn(StatementReturnContext ctx) {
		ReturnStatement returnStatement = new ReturnStatement();
		if (ctx.expression() != null) {
			returnStatement.setExpression(
				new ExpressionConverter()
					.convert(ctx.expression())
			);
		}
		return returnStatement;
	}
}
