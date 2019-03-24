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
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaTemplateParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTemplateParameterList(UtaLanguageParser.UtaTemplateParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(UtaLanguageParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(UtaLanguageParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByReferenceVariable(UtaLanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByValueVariable(UtaLanguageParser.ByValueVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionUpdateList(UtaLanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaDeclarations(UtaLanguageParser.UtaDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaTransitionSelectionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionSelectionSequence(UtaLanguageParser.UtaTransitionSelectionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaTransitionGuardExpression(UtaLanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaLocationInvariantExpression(UtaLanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtaSystemDefinition(UtaLanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemDeclarationSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemDeclarationSequence(UtaLanguageParser.SystemDeclarationSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemDeclarationStatement(UtaLanguageParser.SystemDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PartialTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialTemplateInstantiation(UtaLanguageParser.PartialTemplateInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FullTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullTemplateInstantiation(UtaLanguageParser.FullTemplateInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemLine(UtaLanguageParser.SystemLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessesList(UtaLanguageParser.SystemProcessesListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessRefList(UtaLanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#systemProcessRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemProcessRef(UtaLanguageParser.SystemProcessRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgressMeasureDeclaration(UtaLanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(UtaLanguageParser.SelectionContext ctx);
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
	 * Visit a parse tree produced by {@link UtaLanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelPrioritySpecExpression(UtaLanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelRefList(UtaLanguageParser.ChannelRefListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelDefaultPriorityExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelDefaultPriorityExpr(UtaLanguageParser.ChannelDefaultPriorityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelIdentifierNameExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelIdentifierNameExpr(UtaLanguageParser.ChannelIdentifierNameExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChannelArrayLookupExr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelArrayLookupExr(UtaLanguageParser.ChannelArrayLookupExrContext ctx);
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
	 * Visit a parse tree produced by the {@code DeclarationOfValueFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfValueFunction(UtaLanguageParser.DeclarationOfValueFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationOfVoidFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationOfVoidFunction(UtaLanguageParser.DeclarationOfVoidFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#blockOfStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockOfStatements(UtaLanguageParser.BlockOfStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(UtaLanguageParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementForLoop(UtaLanguageParser.StatementForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIteration(UtaLanguageParser.StatementIterationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhileLoop(UtaLanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDoWhile(UtaLanguageParser.StatementDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementConditional(UtaLanguageParser.StatementConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(UtaLanguageParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEmpty(UtaLanguageParser.StatementEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#primaryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryStatement(UtaLanguageParser.PrimaryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#alternativeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternativeStatement(UtaLanguageParser.AlternativeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopInitializer(UtaLanguageParser.LoopInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopCondition(UtaLanguageParser.LoopConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopUpdate(UtaLanguageParser.LoopUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#loopBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBody(UtaLanguageParser.LoopBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionExistentialQuantification(UtaLanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUniversalQuantification(UtaLanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMultiplication(UtaLanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseAnd(UtaLanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpGreaterThan(UtaLanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpMultiplication(UtaLanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMaximum(UtaLanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNaturalNumber(UtaLanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDecrementAndGet(UtaLanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionCall}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCall(UtaLanguageParser.ExpressionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpAdditiveIdentity}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpAdditiveIdentity(UtaLanguageParser.ExpressionUnaryOpAdditiveIdentityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionTernary(UtaLanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpEqual(UtaLanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpModulo(UtaLanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseXOR(UtaLanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLessThanOrEqual(UtaLanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpRightShift(UtaLanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpConjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpNegatedPhrase(UtaLanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLessThan(UtaLanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpSubtraction(UtaLanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionIdentifierRef}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIdentifierRef(UtaLanguageParser.ExpressionIdentifierRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpLeftShift(UtaLanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpSubtraction(UtaLanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpAdditiveInverse}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpAdditiveInverse(UtaLanguageParser.ExpressionUnaryOpAdditiveInverseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionTrueLiteral(UtaLanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDisjunction(UtaLanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseXOR(UtaLanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFalseLiteral(UtaLanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseAnd(UtaLanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGetAndIncrement(UtaLanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpMinimum(UtaLanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFieldAccess(UtaLanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpBitwiseOr(UtaLanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIncrementAndGet(UtaLanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpAddition(UtaLanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpRightShift(UtaLanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryOpNegated(UtaLanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDeadlockLiteral(UtaLanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDivision(UtaLanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpNotEqual(UtaLanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpBitwiseOr(UtaLanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpDivision(UtaLanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGrouped(UtaLanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArrayLookup(UtaLanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpDisjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpGreaterThanOrEqual(UtaLanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpLeftShift(UtaLanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpModulo(UtaLanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOp(UtaLanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpImplicationPhrase(UtaLanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGetAndDecrement(UtaLanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinaryOpConjunction(UtaLanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignOpAddition(UtaLanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(UtaLanguageParser.ArgumentListContext ctx);
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
	 * Visit a parse tree produced by {@link UtaLanguageParser#arrayIdentifierLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIdentifierLookup(UtaLanguageParser.ArrayIdentifierLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link UtaLanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(UtaLanguageParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIdentifier(UtaLanguageParser.ArrayIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseIdentifier(UtaLanguageParser.BaseIdentifierContext ctx);
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