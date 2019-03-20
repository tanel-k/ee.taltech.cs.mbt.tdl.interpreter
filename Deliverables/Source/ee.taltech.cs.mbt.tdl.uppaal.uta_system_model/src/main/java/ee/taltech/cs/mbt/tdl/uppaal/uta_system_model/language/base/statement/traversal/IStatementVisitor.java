package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.container.VariableDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process.PartialTemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process.ProcessVariableAssignment;

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
	void visitValueFunctionDeclaration(ValueFunctionDeclaration valueFunction);
	void visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunction);
	void visitVariableDeclaration(VariableDeclaration variableDeclaration);
	void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelPriorityDeclaration);
	void visitTypeDeclaration(TypeDeclaration typeDeclaration);
	void visitTemplateInstantiation(ProcessVariableAssignment processVariableAssignment);
	void visitPartialTemplateInstantiation(PartialTemplateInstantiation partialTemplateInstantiation);
	void visitVariableDeclarations(VariableDeclarationList variableDeclarationList);
	void visitTypeDeclarations(TypeDeclarationList typeDeclarationList);
}
