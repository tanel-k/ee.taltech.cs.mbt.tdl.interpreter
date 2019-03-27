// Generated from UtaLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UtaLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UtaLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#selectionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionSequence(UtaLanguageParser.SelectionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(UtaLanguageParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemDefinition(UtaLanguageParser.SystemDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemLine(UtaLanguageParser.SystemLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemProcessSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessSequence(UtaLanguageParser.SystemProcessSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemProcessGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessGroup(UtaLanguageParser.SystemProcessGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgressMeasureDeclaration(UtaLanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#declarationSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSequence(UtaLanguageParser.DeclarationSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(UtaLanguageParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(UtaLanguageParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(UtaLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelPriorityDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelPriorityDeclaration(UtaLanguageParser.ChannelPriorityDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateInstantiation(UtaLanguageParser.TemplateInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#channelPrioritySequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelPrioritySequence(UtaLanguageParser.ChannelPrioritySequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#channelPriorityGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelPriorityGroup(UtaLanguageParser.ChannelPriorityGroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefaultChannelReference}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultChannelReference(UtaLanguageParser.DefaultChannelReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelArrayLookup(UtaLanguageParser.ChannelArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelIdentifierRefrence}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelIdentifierRefrence(UtaLanguageParser.ChannelIdentifierRefrenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#variableInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitialization(UtaLanguageParser.VariableInitializationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FlatInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatInitializer(UtaLanguageParser.FlatInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructuredInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredInitializer(UtaLanguageParser.StructuredInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueFunctionDeclaration(UtaLanguageParser.ValueFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidFunctionDeclaration(UtaLanguageParser.VoidFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#statementSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSequence(UtaLanguageParser.StatementSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(UtaLanguageParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(UtaLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatement(UtaLanguageParser.ForLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IterationStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(UtaLanguageParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStatement(UtaLanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(UtaLanguageParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(UtaLanguageParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(UtaLanguageParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(UtaLanguageParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(UtaLanguageParser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseXorExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXorExpression(UtaLanguageParser.BitwiseXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeftShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftShiftExpression(UtaLanguageParser.LeftShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DisjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctionExpression(UtaLanguageParser.DisjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpression(UtaLanguageParser.GreaterThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveIdentityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveIdentityExpression(UtaLanguageParser.AdditiveIdentityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveInverseExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveInverseExpression(UtaLanguageParser.AdditiveInverseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldAccessExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessExpression(UtaLanguageParser.FieldAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModuloAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuloAssignmentExpr(UtaLanguageParser.ModuloAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(UtaLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndAssignmentExpr(UtaLanguageParser.BitwiseAndAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UniversalQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversalQuantificationExpression(UtaLanguageParser.UniversalQuantificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NaturalNumberLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalNumberLiteral(UtaLanguageParser.NaturalNumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGroup(UtaLanguageParser.ExpressionGroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightShiftExpression(UtaLanguageParser.RightShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrAssignmentExpr(UtaLanguageParser.BitwiseOrAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqualExpression(UtaLanguageParser.GreaterThanOrEqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivisionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionAssignmentExpr(UtaLanguageParser.DivisionAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuffixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixDecrementExpression(UtaLanguageParser.SuffixDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistentialQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistentialQuantificationExpression(UtaLanguageParser.ExistentialQuantificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(UtaLanguageParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModuloExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuloExpression(UtaLanguageParser.ModuloExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctionExpression(UtaLanguageParser.ConjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationAssignmentExpr(UtaLanguageParser.MultiplicationAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(UtaLanguageParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLookupExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookupExpression(UtaLanguageParser.ArrayLookupExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixIncrementExpression(UtaLanguageParser.PrefixIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqualExpression(UtaLanguageParser.LessThanOrEqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(UtaLanguageParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InequalityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequalityExpression(UtaLanguageParser.InequalityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeadlockLiteral(UtaLanguageParser.DeadlockLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(UtaLanguageParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(UtaLanguageParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuffixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixIncrementExpression(UtaLanguageParser.SuffixIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionExpression(UtaLanguageParser.DivisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionAssignmentExpr(UtaLanguageParser.AdditionAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpression(UtaLanguageParser.NegationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(UtaLanguageParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDecrementExpression(UtaLanguageParser.PrefixDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(UtaLanguageParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(UtaLanguageParser.AdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseXorAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXorAssignmentExpr(UtaLanguageParser.BitwiseXorAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionAssignmentExpr(UtaLanguageParser.SubtractionAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightShiftAssignmentExpr(UtaLanguageParser.RightShiftAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaximumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaximumExpression(UtaLanguageParser.MaximumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(UtaLanguageParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionExpression(UtaLanguageParser.SubtractionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(UtaLanguageParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinimumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinimumExpression(UtaLanguageParser.MinimumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationExpression(UtaLanguageParser.ImplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeftShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftShiftAssignmentExpr(UtaLanguageParser.LeftShiftAssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpression(UtaLanguageParser.LessThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#parameterSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterSequence(UtaLanguageParser.ParameterSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(UtaLanguageParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#argumentSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentSequence(UtaLanguageParser.ArgumentSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UtaLanguageParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdInteger(UtaLanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdClock(UtaLanguageParser.TypeIdClockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdChannel(UtaLanguageParser.TypeIdChannelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdBoolean(UtaLanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdIntegerBounded(UtaLanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdScalar(UtaLanguageParser.TypeIdScalarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdStruct(UtaLanguageParser.TypeIdStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdIdentifierName}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdIdentifierName(UtaLanguageParser.TypeIdIdentifierNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#arrayVariableLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariableLookup(UtaLanguageParser.ArrayVariableLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(UtaLanguageParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIdentifierDeclaration(UtaLanguageParser.ArrayIdentifierDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseIdentifierDeclaration(UtaLanguageParser.BaseIdentifierDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySizeFromExpression(UtaLanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySizeFromType(UtaLanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixUrgent(UtaLanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixBroadcast(UtaLanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixMeta(UtaLanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixConstant(UtaLanguageParser.TypePrefixConstantContext ctx);
}