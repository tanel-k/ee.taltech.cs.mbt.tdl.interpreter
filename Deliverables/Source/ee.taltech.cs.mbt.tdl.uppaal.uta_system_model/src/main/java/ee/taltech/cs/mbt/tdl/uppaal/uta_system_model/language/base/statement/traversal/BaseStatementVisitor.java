package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers.DeclarationStatementList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.base.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.ChannelPriorityDeclaration;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.process.PartialTemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.process.ProcessVariableAssignment;

public class BaseStatementVisitor implements IStatementVisitor {
	@Override
	public void visitReturn(ReturnStatement returnStatement) { }

	@Override
	public void visitExpression(ExpressionStatement expressionStatement) { }

	@Override
	public void visitEmpty(EmptyStatement emptyStatement) { }

	@Override
	public void visitConditional(ConditionalStatement conditionalStatement) { }

	@Override
	public void visitStatementBlock(StatementBlock statementBlock) { }

	@Override
	public void visitWhileLoop(WhileLoop whileLoop) { }

	@Override
	public void visitDoWhileLoop(DoWhileLoop doWhileLoop) { }

	@Override
	public void visitForLoop(ForLoop forLoop) { }

	@Override
	public void visitIterationLoop(IterationLoop iterationLoop) { }

	@Override
	public void visitValueFunctionDeclaration(ValueFunctionDeclaration functionDeclaration) { }

	@Override
	public void visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunctionDeclaration) { }

	@Override
	public void visitVariableDeclaration(VariableDeclaration variableDeclaration) { }

	@Override
	public void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelPriorityDeclaration) { }

	@Override
	public void visitDeclarationList(DeclarationStatementList declarationStatementList) { }

	@Override
	public void visitTypeDeclaration(TypeDeclaration typeDeclaration) { }

	@Override
	public void visitTemplateInstantiation(ProcessVariableAssignment processVariableAssignment) { }

	@Override
	public void visitPartialTemplateInstantiation(PartialTemplateInstantiation partialTemplateInstantiation) { }
}
