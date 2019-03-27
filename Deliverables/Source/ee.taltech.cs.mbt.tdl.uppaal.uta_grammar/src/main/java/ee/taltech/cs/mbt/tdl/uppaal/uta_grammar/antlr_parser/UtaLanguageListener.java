// Generated from UtaLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UtaLanguageParser}.
 */
public interface UtaLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 */
	void enterActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 */
	void exitActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 */
	void enterReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#synchronization}.
	 * @param ctx the parse tree
	 */
	void exitReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#selectionSequence}.
	 * @param ctx the parse tree
	 */
	void enterSelectionSequence(UtaLanguageParser.SelectionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#selectionSequence}.
	 * @param ctx the parse tree
	 */
	void exitSelectionSequence(UtaLanguageParser.SelectionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(UtaLanguageParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(UtaLanguageParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSystemDefinition(UtaLanguageParser.SystemDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSystemDefinition(UtaLanguageParser.SystemDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemLine}.
	 * @param ctx the parse tree
	 */
	void enterSystemLine(UtaLanguageParser.SystemLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemLine}.
	 * @param ctx the parse tree
	 */
	void exitSystemLine(UtaLanguageParser.SystemLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemProcessSequence}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessSequence(UtaLanguageParser.SystemProcessSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemProcessSequence}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessSequence(UtaLanguageParser.SystemProcessSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemProcessGroup}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessGroup(UtaLanguageParser.SystemProcessGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemProcessGroup}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessGroup(UtaLanguageParser.SystemProcessGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgressMeasureDeclaration(UtaLanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgressMeasureDeclaration(UtaLanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#declarationSequence}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSequence(UtaLanguageParser.DeclarationSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#declarationSequence}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSequence(UtaLanguageParser.DeclarationSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(UtaLanguageParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(UtaLanguageParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(UtaLanguageParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(UtaLanguageParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(UtaLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(UtaLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelPriorityDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterChannelPriorityDeclaration(UtaLanguageParser.ChannelPriorityDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelPriorityDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitChannelPriorityDeclaration(UtaLanguageParser.ChannelPriorityDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterTemplateInstantiation(UtaLanguageParser.TemplateInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitTemplateInstantiation(UtaLanguageParser.TemplateInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#channelPrioritySequence}.
	 * @param ctx the parse tree
	 */
	void enterChannelPrioritySequence(UtaLanguageParser.ChannelPrioritySequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#channelPrioritySequence}.
	 * @param ctx the parse tree
	 */
	void exitChannelPrioritySequence(UtaLanguageParser.ChannelPrioritySequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#channelPriorityGroup}.
	 * @param ctx the parse tree
	 */
	void enterChannelPriorityGroup(UtaLanguageParser.ChannelPriorityGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#channelPriorityGroup}.
	 * @param ctx the parse tree
	 */
	void exitChannelPriorityGroup(UtaLanguageParser.ChannelPriorityGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefaultChannelReference}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void enterDefaultChannelReference(UtaLanguageParser.DefaultChannelReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefaultChannelReference}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void exitDefaultChannelReference(UtaLanguageParser.DefaultChannelReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void enterChannelArrayLookup(UtaLanguageParser.ChannelArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void exitChannelArrayLookup(UtaLanguageParser.ChannelArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelIdentifierRefrence}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void enterChannelIdentifierRefrence(UtaLanguageParser.ChannelIdentifierRefrenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelIdentifierRefrence}
	 * labeled alternative in {@link UtaLanguageParser#channelReference}.
	 * @param ctx the parse tree
	 */
	void exitChannelIdentifierRefrence(UtaLanguageParser.ChannelIdentifierRefrenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitialization(UtaLanguageParser.VariableInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitialization(UtaLanguageParser.VariableInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FlatInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void enterFlatInitializer(UtaLanguageParser.FlatInitializerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FlatInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void exitFlatInitializer(UtaLanguageParser.FlatInitializerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructuredInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void enterStructuredInitializer(UtaLanguageParser.StructuredInitializerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructuredInitializer}
	 * labeled alternative in {@link UtaLanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void exitStructuredInitializer(UtaLanguageParser.StructuredInitializerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterValueFunctionDeclaration(UtaLanguageParser.ValueFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitValueFunctionDeclaration(UtaLanguageParser.ValueFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterVoidFunctionDeclaration(UtaLanguageParser.VoidFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidFunctionDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitVoidFunctionDeclaration(UtaLanguageParser.VoidFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#statementSequence}.
	 * @param ctx the parse tree
	 */
	void enterStatementSequence(UtaLanguageParser.StatementSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#statementSequence}.
	 * @param ctx the parse tree
	 */
	void exitStatementSequence(UtaLanguageParser.StatementSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(UtaLanguageParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(UtaLanguageParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(UtaLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(UtaLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForLoopStatement(UtaLanguageParser.ForLoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForLoopStatement(UtaLanguageParser.ForLoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IterationStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(UtaLanguageParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterationStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(UtaLanguageParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoopStatement(UtaLanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoopStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoopStatement(UtaLanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(UtaLanguageParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(UtaLanguageParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(UtaLanguageParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(UtaLanguageParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(UtaLanguageParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(UtaLanguageParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(UtaLanguageParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStatement}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(UtaLanguageParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(UtaLanguageParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(UtaLanguageParser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseXorExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXorExpression(UtaLanguageParser.BitwiseXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseXorExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXorExpression(UtaLanguageParser.BitwiseXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeftShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeftShiftExpression(UtaLanguageParser.LeftShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeftShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeftShiftExpression(UtaLanguageParser.LeftShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DisjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctionExpression(UtaLanguageParser.DisjunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DisjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctionExpression(UtaLanguageParser.DisjunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanExpression(UtaLanguageParser.GreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanExpression(UtaLanguageParser.GreaterThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveIdentityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveIdentityExpression(UtaLanguageParser.AdditiveIdentityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveIdentityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveIdentityExpression(UtaLanguageParser.AdditiveIdentityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveInverseExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveInverseExpression(UtaLanguageParser.AdditiveInverseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveInverseExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveInverseExpression(UtaLanguageParser.AdditiveInverseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldAccessExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessExpression(UtaLanguageParser.FieldAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldAccessExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessExpression(UtaLanguageParser.FieldAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModuloAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModuloAssignmentExpr(UtaLanguageParser.ModuloAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModuloAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModuloAssignmentExpr(UtaLanguageParser.ModuloAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(UtaLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(UtaLanguageParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndAssignmentExpr(UtaLanguageParser.BitwiseAndAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndAssignmentExpr(UtaLanguageParser.BitwiseAndAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UniversalQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalQuantificationExpression(UtaLanguageParser.UniversalQuantificationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UniversalQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalQuantificationExpression(UtaLanguageParser.UniversalQuantificationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NaturalNumberLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNaturalNumberLiteral(UtaLanguageParser.NaturalNumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NaturalNumberLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNaturalNumberLiteral(UtaLanguageParser.NaturalNumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGroup(UtaLanguageParser.ExpressionGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGroup(UtaLanguageParser.ExpressionGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RightShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRightShiftExpression(UtaLanguageParser.RightShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RightShiftExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRightShiftExpression(UtaLanguageParser.RightShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrAssignmentExpr(UtaLanguageParser.BitwiseOrAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrAssignmentExpr(UtaLanguageParser.BitwiseOrAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqualExpression(UtaLanguageParser.GreaterThanOrEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqualExpression(UtaLanguageParser.GreaterThanOrEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivisionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivisionAssignmentExpr(UtaLanguageParser.DivisionAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivisionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivisionAssignmentExpr(UtaLanguageParser.DivisionAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuffixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixDecrementExpression(UtaLanguageParser.SuffixDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuffixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixDecrementExpression(UtaLanguageParser.SuffixDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistentialQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistentialQuantificationExpression(UtaLanguageParser.ExistentialQuantificationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistentialQuantificationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistentialQuantificationExpression(UtaLanguageParser.ExistentialQuantificationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(UtaLanguageParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(UtaLanguageParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModuloExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModuloExpression(UtaLanguageParser.ModuloExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModuloExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModuloExpression(UtaLanguageParser.ModuloExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionExpression(UtaLanguageParser.ConjunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConjunctionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionExpression(UtaLanguageParser.ConjunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationAssignmentExpr(UtaLanguageParser.MultiplicationAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationAssignmentExpr(UtaLanguageParser.MultiplicationAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(UtaLanguageParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(UtaLanguageParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLookupExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLookupExpression(UtaLanguageParser.ArrayLookupExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLookupExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLookupExpression(UtaLanguageParser.ArrayLookupExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixIncrementExpression(UtaLanguageParser.PrefixIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixIncrementExpression(UtaLanguageParser.PrefixIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqualExpression(UtaLanguageParser.LessThanOrEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqualExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqualExpression(UtaLanguageParser.LessThanOrEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteral(UtaLanguageParser.FalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteral(UtaLanguageParser.FalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InequalityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInequalityExpression(UtaLanguageParser.InequalityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InequalityExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInequalityExpression(UtaLanguageParser.InequalityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDeadlockLiteral(UtaLanguageParser.DeadlockLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDeadlockLiteral(UtaLanguageParser.DeadlockLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteral(UtaLanguageParser.TrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteral(UtaLanguageParser.TrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(UtaLanguageParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(UtaLanguageParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuffixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixIncrementExpression(UtaLanguageParser.SuffixIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuffixIncrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixIncrementExpression(UtaLanguageParser.SuffixIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpression(UtaLanguageParser.DivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivisionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpression(UtaLanguageParser.DivisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionAssignmentExpr(UtaLanguageParser.AdditionAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionAssignmentExpr(UtaLanguageParser.AdditionAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(UtaLanguageParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(UtaLanguageParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(UtaLanguageParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(UtaLanguageParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixDecrementExpression(UtaLanguageParser.PrefixDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixDecrementExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixDecrementExpression(UtaLanguageParser.PrefixDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(UtaLanguageParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(UtaLanguageParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(UtaLanguageParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(UtaLanguageParser.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseXorAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXorAssignmentExpr(UtaLanguageParser.BitwiseXorAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseXorAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXorAssignmentExpr(UtaLanguageParser.BitwiseXorAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionAssignmentExpr(UtaLanguageParser.SubtractionAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractionAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionAssignmentExpr(UtaLanguageParser.SubtractionAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RightShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRightShiftAssignmentExpr(UtaLanguageParser.RightShiftAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RightShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRightShiftAssignmentExpr(UtaLanguageParser.RightShiftAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaximumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMaximumExpression(UtaLanguageParser.MaximumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaximumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMaximumExpression(UtaLanguageParser.MaximumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(UtaLanguageParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(UtaLanguageParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionExpression(UtaLanguageParser.SubtractionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractionExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionExpression(UtaLanguageParser.SubtractionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(UtaLanguageParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(UtaLanguageParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinimumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinimumExpression(UtaLanguageParser.MinimumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinimumExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinimumExpression(UtaLanguageParser.MinimumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplicationExpression(UtaLanguageParser.ImplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImplicationExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplicationExpression(UtaLanguageParser.ImplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeftShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeftShiftAssignmentExpr(UtaLanguageParser.LeftShiftAssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeftShiftAssignmentExpr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeftShiftAssignmentExpr(UtaLanguageParser.LeftShiftAssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanExpression(UtaLanguageParser.LessThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanExpression}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanExpression(UtaLanguageParser.LessThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#parameterSequence}.
	 * @param ctx the parse tree
	 */
	void enterParameterSequence(UtaLanguageParser.ParameterSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#parameterSequence}.
	 * @param ctx the parse tree
	 */
	void exitParameterSequence(UtaLanguageParser.ParameterSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(UtaLanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(UtaLanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#argumentSequence}.
	 * @param ctx the parse tree
	 */
	void enterArgumentSequence(UtaLanguageParser.ArgumentSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#argumentSequence}.
	 * @param ctx the parse tree
	 */
	void exitArgumentSequence(UtaLanguageParser.ArgumentSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(UtaLanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(UtaLanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdInteger(UtaLanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdInteger(UtaLanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdClock(UtaLanguageParser.TypeIdClockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdClock(UtaLanguageParser.TypeIdClockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdChannel(UtaLanguageParser.TypeIdChannelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdChannel(UtaLanguageParser.TypeIdChannelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdBoolean(UtaLanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdBoolean(UtaLanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdIntegerBounded(UtaLanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdIntegerBounded(UtaLanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdScalar(UtaLanguageParser.TypeIdScalarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdScalar(UtaLanguageParser.TypeIdScalarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdStruct(UtaLanguageParser.TypeIdStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdStruct(UtaLanguageParser.TypeIdStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdIdentifierName}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdIdentifierName(UtaLanguageParser.TypeIdIdentifierNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdIdentifierName}
	 * labeled alternative in {@link UtaLanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdIdentifierName(UtaLanguageParser.TypeIdIdentifierNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#arrayVariableLookup}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariableLookup(UtaLanguageParser.ArrayVariableLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#arrayVariableLookup}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariableLookup(UtaLanguageParser.ArrayVariableLookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(UtaLanguageParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(UtaLanguageParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayIdentifierDeclaration(UtaLanguageParser.ArrayIdentifierDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayIdentifierDeclaration(UtaLanguageParser.ArrayIdentifierDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBaseIdentifierDeclaration(UtaLanguageParser.BaseIdentifierDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseIdentifierDeclaration}
	 * labeled alternative in {@link UtaLanguageParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBaseIdentifierDeclaration(UtaLanguageParser.BaseIdentifierDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 */
	void enterArraySizeFromExpression(UtaLanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 */
	void exitArraySizeFromExpression(UtaLanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 */
	void enterArraySizeFromType(UtaLanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UtaLanguageParser#arraySizeModifier}.
	 * @param ctx the parse tree
	 */
	void exitArraySizeFromType(UtaLanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixUrgent(UtaLanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixUrgent(UtaLanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixBroadcast(UtaLanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixBroadcast(UtaLanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixMeta(UtaLanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixMeta(UtaLanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixConstant(UtaLanguageParser.TypePrefixConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UtaLanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixConstant(UtaLanguageParser.TypePrefixConstantContext ctx);
}