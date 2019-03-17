// Generated from UTALanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UTALanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UTALanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaTemplateParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTemplateParameters(UTALanguageParser.UtaTemplateParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionUpdateList(UTALanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActiveSynchronization(UTALanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReactiveSynchronization(UTALanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaLocationInvariantExpression(UTALanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionGuardExpression(UTALanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaTransitionSelectionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionSelectionList(UTALanguageParser.UtaTransitionSelectionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaDeclarations(UTALanguageParser.UtaDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaSystemDefinition(UTALanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemDeclarationBody(UTALanguageParser.SystemDeclarationBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemDeclarationStatement(UTALanguageParser.SystemDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#processVariableAssignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessVariableAssignments(UTALanguageParser.ProcessVariableAssignmentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcessVarPartialTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessVarPartialTemplateInstantiation(UTALanguageParser.ProcessVarPartialTemplateInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcessVarFullTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessVarFullTemplateInstantiation(UTALanguageParser.ProcessVarFullTemplateInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemLine(UTALanguageParser.SystemLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessesList(UTALanguageParser.SystemProcessesListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessRefList(UTALanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#systemProcessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessExpression(UTALanguageParser.SystemProcessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgressMeasureDeclaration(UTALanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(UTALanguageParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(UTALanguageParser.DeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(UTALanguageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declarationOfChannelPriority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfChannelPriority(UTALanguageParser.DeclarationOfChannelPriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelPrioritySpecExpression(UTALanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelRefList(UTALanguageParser.ChannelRefListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelExprDefaultPriority}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelExprDefaultPriority(UTALanguageParser.ChannelExprDefaultPriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelExprChannelVariableRef}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelExprChannelVariableRef(UTALanguageParser.ChannelExprChannelVariableRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelExpChannelArrayLookup}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelExpChannelArrayLookup(UTALanguageParser.ChannelExpChannelArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declarationOfVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfVariable(UTALanguageParser.DeclarationOfVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(UTALanguageParser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializerBase}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerBase(UTALanguageParser.InitializerBaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializerForArray}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerForArray(UTALanguageParser.InitializerForArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declarationOfType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfType(UTALanguageParser.DeclarationOfTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfFunction(UTALanguageParser.DeclarationOfFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(UTALanguageParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatetementBlock}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatetementBlock(UTALanguageParser.StatetementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEmpty(UTALanguageParser.StatementEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(UTALanguageParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementForLoop(UTALanguageParser.StatementForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIteration(UTALanguageParser.StatementIterationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhileLoop(UTALanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDoWhile(UTALanguageParser.StatementDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementConditional(UTALanguageParser.StatementConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(UTALanguageParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#forLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatement(UTALanguageParser.ForLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#forLoopHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopHeader(UTALanguageParser.ForLoopHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(UTALanguageParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#iterationHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationHeader(UTALanguageParser.IterationHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStatement(UTALanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#whileLoopHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopHeader(UTALanguageParser.WhileLoopHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(UTALanguageParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UTALanguageParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(UTALanguageParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopInitializer(UTALanguageParser.LoopInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopCondition(UTALanguageParser.LoopConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopUpdate(UTALanguageParser.LoopUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#loopBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBody(UTALanguageParser.LoopBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionExistentialQuantification(UTALanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUniversalQuantification(UTALanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMultiplication(UTALanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseAnd(UTALanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpGreaterThan(UTALanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpMultiplication(UTALanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMaximum(UTALanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNaturalNumber(UTALanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionWithArguments}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithArguments(UTALanguageParser.ExpressionWithArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDecrementAndGet(UTALanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionTernary(UTALanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpEqual(UTALanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpModulo(UTALanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseXOR(UTALanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLessThanOrEqual(UTALanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpRightShift(UTALanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpConjunctionPhrase(UTALanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpNegatedPhrase(UTALanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLessThan(UTALanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpSubtraction(UTALanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLeftShift(UTALanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpSubtraction(UTALanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionTrueLiteral(UTALanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDisjunction(UTALanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseXOR(UTALanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFalseLiteral(UTALanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseAnd(UTALanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGetAndIncrement(UTALanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMinimum(UTALanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFieldAccess(UTALanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseOr(UTALanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIncrementAndGet(UTALanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpAddition(UTALanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpRightShift(UTALanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpNegated(UTALanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDeadlockLiteral(UTALanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDivision(UTALanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpNotEqual(UTALanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseOr(UTALanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpDivision(UTALanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGrouped(UTALanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLookupExpression}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArrayLookup(UTALanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpNegative}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpNegative(UTALanguageParser.ExpressionUnaryOpNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDisjunctionPhrase(UTALanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpGreaterThanOrEqual(UTALanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpLeftShift(UTALanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpModulo(UTALanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOp(UTALanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpImplicationPhrase(UTALanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGetAndDecrement(UTALanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpPositive}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpPositive(UTALanguageParser.ExpressionUnaryOpPositiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionVariableRef}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionVariableRef(UTALanguageParser.ExpressionVariableRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpConjunction(UTALanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpAddition(UTALanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(UTALanguageParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(UTALanguageParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByReferenceVariable(UTALanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByValueVariable(UTALanguageParser.ByValueVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(UTALanguageParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UTALanguageParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdInteger(UTALanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdClock(UTALanguageParser.TypeIdClockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdChannel(UTALanguageParser.TypeIdChannelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdBoolean(UTALanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdIntegerBounded(UTALanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdScalar(UTALanguageParser.TypeIdScalarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdStruct(UTALanguageParser.TypeIdStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeIdIdentifier}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdIdentifier(UTALanguageParser.TypeIdIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTALanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(UTALanguageParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySizeFromExpression(UTALanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySizeFromType(UTALanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixUrgent(UTALanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixBroadcast(UTALanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixMeta(UTALanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefixConstant(UTALanguageParser.TypePrefixConstantContext ctx);
}