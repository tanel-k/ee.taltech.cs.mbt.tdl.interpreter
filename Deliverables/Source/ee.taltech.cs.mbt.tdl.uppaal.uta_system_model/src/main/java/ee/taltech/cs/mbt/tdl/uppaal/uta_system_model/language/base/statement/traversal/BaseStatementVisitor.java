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
	@Override public void visitValueFunctionDeclaration(ValueFunctionDeclaration valueFunction) { }
	@Override public void visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunction) { }
	@Override public void visitVariableDeclaration(VariableDeclaration variableDeclaration) { }
	@Override public void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelPriorityDeclaration) { }
	@Override public void visitTypeDeclaration(TypeDeclaration typeDeclaration) { }
	@Override public void visitTemplateInstantiation(ProcessVariableAssignment processVariableAssignment) { }
	@Override public void visitPartialTemplateInstantiation(PartialTemplateInstantiation partialTemplateInstantiation) { }
	@Override public void visitVariableDeclarations(VariableDeclarationList variableDeclarationList) { }
	@Override public void visitTypeDeclarations(TypeDeclarationList typeDeclarationList) { }
}
