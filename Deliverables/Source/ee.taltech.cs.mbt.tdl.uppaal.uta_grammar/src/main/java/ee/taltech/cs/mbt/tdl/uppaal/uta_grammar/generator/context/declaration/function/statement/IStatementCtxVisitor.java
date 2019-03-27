package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement.*;

public interface IStatementCtxVisitor<T> {
	T visitConditionalStatement(ConditionalStmtCtx ctx);
	T visitDoWhileStatement(DoWhileStmtCtx ctx);
	T visitEmptyStatement(EmptyStmtCtx ctx);
	T visitExpressionStatement(ExpressionStmtCtx ctx);
	T visitForLoopStatement(ForLoopStmtCtx ctx);
	T visitIterationStatement(IterationStmtCtx ctx);
	T visitStatementBlock(StatementBlockCtx ctx);
	T visitWhileStatement(WhileStmtCtx ctx);
	T visitReturnStatement(ReturnStmtCtx returnStmtCtx);
}
