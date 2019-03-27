package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.misc.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.misc.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.misc.ReturnStatement;

public interface IStatementVisitor<T> {
	T visitReturn(ReturnStatement retStmt);
	T visitExpression(ExpressionStatement expression);
	T visitEmpty(EmptyStatement empty);
	T visitConditional(ConditionalStatement conditional);
	T visitBlock(StatementBlock block);
	T visitWhile(WhileLoop whileLoop);
	T visitDoWhile(DoWhileLoop doWhileLoop);
	T visitFor(ForLoop forLoop);
	T visitIteration(IterationLoop iterationLoop);
}
