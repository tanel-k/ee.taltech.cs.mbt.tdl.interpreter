package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ReturnStatement;

public class BaseStatementVisitor implements IStatementVisitor {
	@Override public void visitReturn(ReturnStatement retStmt) { }
	@Override public void visitExpression(ExpressionStatement expression) { }
	@Override public void visitEmpty(EmptyStatement empty) { }
	@Override public void visitConditional(ConditionalStatement conditional) { }
	@Override public void visitBlock(StatementBlock block) { }
	@Override public void visitWhile(WhileLoop whileLoop) { }
	@Override public void visitDoWhile(DoWhileLoop doWhileLoop) { }
	@Override public void visitFor(ForLoop forLoop) { }
	@Override public void visitIteration(IterationLoop iterationLoop) { }
}
