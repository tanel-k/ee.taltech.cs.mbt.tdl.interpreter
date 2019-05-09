package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.WhileLoop;

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
