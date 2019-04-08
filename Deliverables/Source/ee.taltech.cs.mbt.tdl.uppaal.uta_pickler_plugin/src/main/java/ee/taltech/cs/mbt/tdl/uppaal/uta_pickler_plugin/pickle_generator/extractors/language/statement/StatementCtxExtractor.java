package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.statement;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IStatementVisitor;

import java.util.Set;

public class StatementCtxExtractor implements IPicklerContextExtractor<AbsStatement>,
		IStatementVisitor<ContextBuilder> {
	public static StatementCtxExtractor getInstance() {
		return new StatementCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private StatementCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsStatement stmt) {
		return stmt.accept(this);
	}

	@Override
	public ContextBuilder visitReturnStatement(ReturnStatement stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitExpressionStatement(ExpressionStatement stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitEmptyStatement(EmptyStatement stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitConditionalStatement(ConditionalStatement stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBlockStatement(StatementBlock stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitWhileStatement(WhileLoop stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitDoWhileStatement(DoWhileLoop stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitForStatement(ForLoop stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitIterationStatement(IterationLoop stmt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
