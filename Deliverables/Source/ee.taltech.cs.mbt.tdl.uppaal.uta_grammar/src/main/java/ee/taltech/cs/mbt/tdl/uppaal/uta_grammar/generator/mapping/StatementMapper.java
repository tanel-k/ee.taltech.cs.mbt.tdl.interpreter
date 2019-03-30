package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
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

public class StatementMapper implements IContextMapper<AbsStatement>, IStatementVisitor<ContextBuilder> {
	public static StatementMapper getInstance() {
		return INSTANCE;
	}

	private static final StatementMapper INSTANCE = new StatementMapper();

	private StatementMapper() { }

	@Override
	public ContextBuilder map(AbsStatement stmt) {
		if (stmt == null)
			return null;
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
		return ContextBuilder.newBuilder("conditionalStatement")
				.put("condition", ExpressionMapper.getInstance().map(stmt.getCondition()))
				.put("primary", StatementMapper.getInstance().map(stmt.getPrimaryStatement()))
				.put("alternative", StatementMapper.getInstance().map(stmt.getAlternativeStatement()));
	}

	@Override
	public ContextBuilder visitBlockStatement(StatementBlock stmt) {
		return ContextBuilder.newBuilder("blockStatement")
				.put("declarations", DeclarationMapper.getInstance().mapCollection(stmt.getDeclarations()))
				.put("statements", mapCollection(stmt.getStatements()));
	}

	@Override
	public ContextBuilder visitWhileStatement(WhileLoop stmt) {
		return ContextBuilder.newBuilder("whileStatement")
				.put("condition", ExpressionMapper.getInstance().map(stmt.getCondition()))
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitDoWhileStatement(DoWhileLoop stmt) {
		return ContextBuilder.newBuilder("doWhileStatement")
				.put("condition", ExpressionMapper.getInstance().map(stmt.getCondition()))
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitForStatement(ForLoop stmt) {
		return ContextBuilder.newBuilder("forLoopStatement")
				.put("condition", ExpressionMapper.getInstance().map(stmt.getCondition()))
				.put("initializer", ExpressionMapper.getInstance().map(stmt.getInitializer()))
				.put("update", ExpressionMapper.getInstance().map(stmt.getUpdate()))
				.put("statement", map(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitIterationStatement(IterationLoop stmt) {
		return ContextBuilder.newBuilder("iterationStatement")
				.put("identifierValue", stmt.getLoopVariable().getText())
				.put("iteratedType", stmt.getIteratedType())
				.put("statement", map(stmt.getStatement()));
	}
}
