package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.statement;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration.DeclarationMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.BaseTypeMapper;
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

import java.util.Collection;

public class StatementMapper implements IContextMapper<AbsStatement>, IStatementVisitor<ContextBuilder> {
	public static StatementMapper getInstance() {
		return INSTANCE;
	}

	private static final StatementMapper INSTANCE = new StatementMapper();

	private StatementMapper() { }

	@Override
	public ContextBuilder map(AbsStatement stmt) {
		return stmt.accept(this);
	}

	@Override
	public ContextBuilder visitReturnStatement(ReturnStatement stmt) {
		return ContextBuilder.newBuilder("returnStatement")
				.put("expression", ExpressionMapper.getInstance().map(stmt.getExpression()));
	}

	@Override
	public ContextBuilder visitExpressionStatement(ExpressionStatement stmt) {
		return ContextBuilder.newBuilder("expressionStatement")
				.put("expression", ExpressionMapper.getInstance().map(stmt.getExpression()));
	}

	@Override
	public ContextBuilder visitEmptyStatement(EmptyStatement stmt) {
		return ContextBuilder.newBuilder("emptyStatement");
	}

	@Override
	public ContextBuilder visitConditionalStatement(ConditionalStatement stmt) {
		ContextBuilder conditionCtx = ExpressionMapper.getInstance().map(stmt.getCondition());
		ContextBuilder primaryCtx = map(stmt.getPrimaryStatement());
		ContextBuilder alternativeCtx = stmt.getAlternativeStatement() != null
				? map(stmt.getAlternativeStatement())
				: null;
		return ContextBuilder.newBuilder("conditionalStatement")
				.put("condition", conditionCtx)
				.put("primary", primaryCtx)
				.put("alternative", alternativeCtx);
	}

	@Override
	public ContextBuilder visitBlockStatement(StatementBlock stmt) {
		Collection<ContextBuilder> declarationCtxs = DeclarationMapper.getInstance().map(stmt.getDeclarations());
		return ContextBuilder.newBuilder("blockStatement")
				.put("declarations", declarationCtxs)
				.put("statements", this.map(stmt.getStatements()));
	}

	@Override
	public ContextBuilder visitWhileStatement(WhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionMapper.getInstance().map(stmt.getCondition());
		return ContextBuilder.newBuilder("whileStatement")
				.put("condition", conditionCtx)
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitDoWhileStatement(DoWhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionMapper.getInstance().map(stmt.getCondition());
		return ContextBuilder.newBuilder("doWhileStatement")
				.put("condition", conditionCtx)
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitForStatement(ForLoop stmt) {
		ContextBuilder conditionCtx = ExpressionMapper.getInstance().map(stmt.getCondition());
		ContextBuilder initializerCtx = ExpressionMapper.getInstance().map(stmt.getInitializer());
		ContextBuilder updateCtx = ExpressionMapper.getInstance().map(stmt.getUpdate());
		return ContextBuilder.newBuilder("forLoopStatement")
				.put("condition", conditionCtx)
				.put("initializer", initializerCtx)
				.put("update", updateCtx)
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitIterationStatement(IterationLoop stmt) {
		ContextBuilder baseTypeCtx = BaseTypeMapper.getInstance().map(stmt.getIteratedType());
		return ContextBuilder.newBuilder("iterationStatement")
				.put("identifierValue", stmt.getLoopVariable().toString())
				.put("iteratedType", baseTypeCtx)
				.put("statement", map(stmt.getStatement()));
	}
}
