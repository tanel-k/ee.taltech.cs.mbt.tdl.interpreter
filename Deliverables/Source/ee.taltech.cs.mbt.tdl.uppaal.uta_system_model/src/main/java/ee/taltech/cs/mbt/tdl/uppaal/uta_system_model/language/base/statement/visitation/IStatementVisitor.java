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

public interface IStatementVisitor {
	void visitReturn(ReturnStatement retStmt);
	void visitExpression(ExpressionStatement expression);
	void visitEmpty(EmptyStatement empty);
	void visitConditional(ConditionalStatement conditional);
	void visitBlock(StatementBlock block);
	void visitWhile(WhileLoop whileLoop);
	void visitDoWhile(DoWhileLoop doWhileLoop);
	void visitFor(ForLoop forLoop);
	void visitIteration(IterationLoop iterationLoop);
}
