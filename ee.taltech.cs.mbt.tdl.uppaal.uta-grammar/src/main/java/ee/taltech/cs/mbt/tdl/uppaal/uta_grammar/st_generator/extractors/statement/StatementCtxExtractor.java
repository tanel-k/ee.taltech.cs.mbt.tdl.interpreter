package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.statement;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.BaseTypeCtxExtractor;
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

import java.util.Collection;

public class StatementCtxExtractor implements IContextExtractor<AbsStatement>, IStatementVisitor<ContextBuilder> {
	public static StatementCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final StatementCtxExtractor INSTANCE = new StatementCtxExtractor();

	private StatementCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsStatement stmt) {
		return stmt.accept(this);
	}

	@Override
	public ContextBuilder visitReturnStatement(ReturnStatement stmt) {
		return ContextBuilder.newBuilder("returnStatement")
				.put("expression", ExpressionCtxExtractor.getInstance().extract(stmt.getExpression()));
	}

	@Override
	public ContextBuilder visitExpressionStatement(ExpressionStatement stmt) {
		return ContextBuilder.newBuilder("expressionStatement")
				.put("expression", ExpressionCtxExtractor.getInstance().extract(stmt.getExpression()));
	}

	@Override
	public ContextBuilder visitEmptyStatement(EmptyStatement stmt) {
		return ContextBuilder.newBuilder("emptyStatement");
	}

	@Override
	public ContextBuilder visitConditionalStatement(ConditionalStatement stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getCondition());
		ContextBuilder primaryCtx = extract(stmt.getPrimaryStatement());
		ContextBuilder alternativeCtx = stmt.getAlternativeStatement() != null
				? extract(stmt.getAlternativeStatement())
				: null;
		return ContextBuilder.newBuilder("conditionalStatement")
				.put("condition", conditionCtx)
				.put("primary", primaryCtx)
				.put("alternative", alternativeCtx);
	}

	@Override
	public ContextBuilder visitBlockStatement(StatementBlock stmt) {
		Collection<ContextBuilder> declarationCtxs = DeclarationCtxExtractor.getInstance().extract(stmt.getDeclarations());
		return ContextBuilder.newBuilder("blockStatement")
				.put("declarations", declarationCtxs)
				.put("statements", this.extract(stmt.getStatements()));
	}

	@Override
	public ContextBuilder visitWhileStatement(WhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getCondition());
		return ContextBuilder.newBuilder("whileStatement")
				.put("condition", conditionCtx)
				.put("statement", extract(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitDoWhileStatement(DoWhileLoop stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getCondition());
		return ContextBuilder.newBuilder("doWhileStatement")
				.put("condition", conditionCtx)
				.put("statement", extract(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitForStatement(ForLoop stmt) {
		ContextBuilder conditionCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getCondition());
		ContextBuilder initializerCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getInitializer());
		ContextBuilder updateCtx = ExpressionCtxExtractor.getInstance().extract(stmt.getUpdate());
		return ContextBuilder.newBuilder("forLoopStatement")
				.put("condition", conditionCtx)
				.put("initializer", initializerCtx)
				.put("update", updateCtx)
				.put("statement", extract(stmt.getStatement()));
	}

	@Override
	public ContextBuilder visitIterationStatement(IterationLoop stmt) {
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance().extract(stmt.getIteratedType());
		return ContextBuilder.newBuilder("iterationStatement")
				.put("identifierValue", stmt.getLoopVariable().toString())
				.put("iteratedType", baseTypeCtx)
				.put("statement", extract(stmt.getStatement()));
	}
}
