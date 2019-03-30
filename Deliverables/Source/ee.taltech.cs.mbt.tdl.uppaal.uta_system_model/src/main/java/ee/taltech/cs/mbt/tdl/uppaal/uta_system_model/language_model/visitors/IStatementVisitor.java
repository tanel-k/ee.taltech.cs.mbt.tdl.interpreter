package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.WhileLoop;

public interface IStatementVisitor<T> {
	T visitReturnStatement(ReturnStatement stmt);
	T visitExpressionStatement(ExpressionStatement stmt);
	T visitEmptyStatement(EmptyStatement stmt);
	T visitConditionalStatement(ConditionalStatement stmt);
	T visitBlockStatement(StatementBlock stmt);
	T visitWhileStatement(WhileLoop stmt);
	T visitDoWhileStatement(DoWhileLoop stmt);
	T visitForStatement(ForLoop stmt);
	T visitIterationStatement(IterationLoop stmt);
}
