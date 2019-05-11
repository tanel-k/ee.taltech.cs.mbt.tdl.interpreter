package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.statement;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.BaseTypeCtxExtractor;

import java.util.Collection;
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
		requiredClasses.add(stmt.getClass());
		return stmt.accept(this);
	}

	@Override
	public ContextBuilder visitReturnStatement(ReturnStatement stmt) {
		ContextBuilder exprCtx = stmt.getExpression() != null
				? ExpressionCtxExtractor.getInstance().extract(stmt.getExpression(), requiredClasses)
				: null;
		return ContextBuilder.newBuilder("returnStatement")
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitExpressionStatement(ExpressionStatement stmt) {
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getExpression(), requiredClasses);
		return ContextBuilder.newBuilder("expressionStatement")
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitEmptyStatement(EmptyStatement stmt) {
		return ContextBuilder.newBuilder("emptyStatement");
	}

	@Override
	public ContextBuilder visitBlockStatement(StatementBlock stmt) {
		Collection<ContextBuilder> declCtxs = DeclarationCtxExtractor.getInstance()
				.extract(stmt.getDeclarations(), requiredClasses);
		Collection<ContextBuilder> stmtCtxs = StatementCtxExtractor.getInstance()
				.extract(stmt.getStatements(), requiredClasses);
		return ContextBuilder.newBuilder("blockStatement")
				.put("declarations", declCtxs)
				.put("statements", stmtCtxs);
	}

	@Override
	public ContextBuilder visitConditionalStatement(ConditionalStatement stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getCondition(), requiredClasses);
		ContextBuilder primaryStmtCtx = extract(stmt.getPrimaryStatement(), requiredClasses);
		ContextBuilder altStmtCtx = stmt.getAlternativeStatement() != null
				? extract(stmt.getAlternativeStatement(), requiredClasses)
				: null;
		return ContextBuilder.newBuilder("conditionalStatement")
				.put("condition", conditionCtx)
				.put("primary", primaryStmtCtx)
				.put("alternative", altStmtCtx);
	}

	@Override
	public ContextBuilder visitWhileStatement(WhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getCondition(), requiredClasses);
		ContextBuilder stmtCtx = StatementCtxExtractor.getInstance()
				.extract(stmt.getStatement(), requiredClasses);
		return ContextBuilder.newBuilder("whileStatement")
				.put("condition", conditionCtx)
				.put("statement", stmtCtx);
	}

	@Override
	public ContextBuilder visitDoWhileStatement(DoWhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getCondition(), requiredClasses);
		ContextBuilder stmtCtx = extract(stmt.getStatement(), requiredClasses);
		return ContextBuilder.newBuilder("doWhileStatement")
				.put("condition", conditionCtx)
				.put("statement", stmtCtx);
	}

	@Override
	public ContextBuilder visitForStatement(ForLoop stmt) {
		ContextBuilder initCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getInitializer(), requiredClasses);
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getCondition(), requiredClasses);
		ContextBuilder updateCtx = ExpressionCtxExtractor.getInstance()
				.extract(stmt.getUpdate(), requiredClasses);
		ContextBuilder stmtCtx = extract(stmt.getStatement(), requiredClasses);
		return ContextBuilder.newBuilder("forLoopStatement")
				.put("initializer", initCtx)
				.put("condition", conditionCtx)
				.put("update", updateCtx)
				.put("statement", stmtCtx);
	}

	@Override
	public ContextBuilder visitIterationStatement(IterationLoop stmt) {
		requiredClasses.add(Identifier.class);
		ContextBuilder typeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(stmt.getIteratedType(), requiredClasses);
		ContextBuilder stmtCtx = extract(stmt.getStatement(), requiredClasses);
		return ContextBuilder.newBuilder("iterationStatement")
				.put("iteratedType", typeCtx)
				.put("loopVariableName", stmt.getLoopVariable().toString())
				.put("statement", stmtCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
