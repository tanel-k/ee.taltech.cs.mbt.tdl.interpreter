package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.base.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container.DeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.template.PartialTemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.template.ProcessVariableAssignment;

public interface IStatementVisitor {
	void visitReturn(ReturnStatement returnStatement);
	void visitExpression(ExpressionStatement expressionStatement);
	void visitEmpty(EmptyStatement emptyStatement);
	void visitConditional(ConditionalStatement conditionalStatement);
	void visitStatementBlock(StatementBlock statementBlock);
	void visitWhileLoop(WhileLoop whileLoop);
	void visitDoWhileLoop(DoWhileLoop doWhileLoop);
	void visitForLoop(ForLoop forLoop);
	void visitIterationLoop(IterationLoop iterationLoop);
	void visitValueFunctionDeclaration(ValueFunctionDeclaration functionDeclaration);
	void visitVoidFunction(VoidFunctionDeclaration voidFunctionDeclaration);
	void visitVariableDeclaration(VariableDeclaration variableDeclaration);
	void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelPriorityDeclaration);
	void visitDeclarationList(DeclarationList declarationList);
	void visitTypeDeclaration(TypeDeclaration typeDeclaration);
	void visitTemplateInstantiation(ProcessVariableAssignment processVariableAssignment);
	void visitPartialTemplateInstantiation(PartialTemplateInstantiation partialTemplateInstantiation);
}
