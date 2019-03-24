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
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaTemplateParameterList}.
	 * @param ctx the parse tree
	 */
	void enterUtaTemplateParameterList(UtaLanguageParser.UtaTemplateParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaTemplateParameterList}.
	 * @param ctx the parse tree
	 */
	void exitUtaTemplateParameterList(UtaLanguageParser.UtaTemplateParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(UtaLanguageParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(UtaLanguageParser.ParameterListContext ctx);
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
	 * Enter a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterByReferenceVariable(UtaLanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitByReferenceVariable(UtaLanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterByValueVariable(UtaLanguageParser.ByValueVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UtaLanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitByValueVariable(UtaLanguageParser.ByValueVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionUpdateList(UtaLanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionUpdateList(UtaLanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterUtaDeclarations(UtaLanguageParser.UtaDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitUtaDeclarations(UtaLanguageParser.UtaDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void enterActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void exitActiveSynchronization(UtaLanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void enterReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UtaLanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void exitReactiveSynchronization(UtaLanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaTransitionSelectionSequence}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionSelectionSequence(UtaLanguageParser.UtaTransitionSelectionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaTransitionSelectionSequence}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionSelectionSequence(UtaLanguageParser.UtaTransitionSelectionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionGuardExpression(UtaLanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionGuardExpression(UtaLanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 */
	void enterUtaLocationInvariantExpression(UtaLanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 */
	void exitUtaLocationInvariantExpression(UtaLanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 */
	void enterUtaSystemDefinition(UtaLanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 */
	void exitUtaSystemDefinition(UtaLanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemDeclarationSequence}.
	 * @param ctx the parse tree
	 */
	void enterSystemDeclarationSequence(UtaLanguageParser.SystemDeclarationSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemDeclarationSequence}.
	 * @param ctx the parse tree
	 */
	void exitSystemDeclarationSequence(UtaLanguageParser.SystemDeclarationSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterSystemDeclarationStatement(UtaLanguageParser.SystemDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitSystemDeclarationStatement(UtaLanguageParser.SystemDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PartialTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 */
	void enterPartialTemplateInstantiation(UtaLanguageParser.PartialTemplateInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PartialTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 */
	void exitPartialTemplateInstantiation(UtaLanguageParser.PartialTemplateInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 */
	void enterFullTemplateInstantiation(UtaLanguageParser.FullTemplateInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullTemplateInstantiation}
	 * labeled alternative in {@link UtaLanguageParser#templateInstantiation}.
	 * @param ctx the parse tree
	 */
	void exitFullTemplateInstantiation(UtaLanguageParser.FullTemplateInstantiationContext ctx);
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
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessesList(UtaLanguageParser.SystemProcessesListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessesList(UtaLanguageParser.SystemProcessesListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessRefList(UtaLanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessRefList(UtaLanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#systemProcessRef}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessRef(UtaLanguageParser.SystemProcessRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#systemProcessRef}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessRef(UtaLanguageParser.SystemProcessRefContext ctx);
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
	 * Enter a parse tree produced by {@link UtaLanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelPrioritySpecExpression(UtaLanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelPrioritySpecExpression(UtaLanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 */
	void enterChannelRefList(UtaLanguageParser.ChannelRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 */
	void exitChannelRefList(UtaLanguageParser.ChannelRefListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelDefaultPriorityExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelDefaultPriorityExpr(UtaLanguageParser.ChannelDefaultPriorityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelDefaultPriorityExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelDefaultPriorityExpr(UtaLanguageParser.ChannelDefaultPriorityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelIdentifierNameExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelIdentifierNameExpr(UtaLanguageParser.ChannelIdentifierNameExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelIdentifierNameExpr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelIdentifierNameExpr(UtaLanguageParser.ChannelIdentifierNameExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelArrayLookupExr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelArrayLookupExr(UtaLanguageParser.ChannelArrayLookupExrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelArrayLookupExr}
	 * labeled alternative in {@link UtaLanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelArrayLookupExr(UtaLanguageParser.ChannelArrayLookupExrContext ctx);
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
	 * Enter a parse tree produced by the {@code DeclarationOfValueFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfValueFunction(UtaLanguageParser.DeclarationOfValueFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationOfValueFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfValueFunction(UtaLanguageParser.DeclarationOfValueFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationOfVoidFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfVoidFunction(UtaLanguageParser.DeclarationOfVoidFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationOfVoidFunction}
	 * labeled alternative in {@link UtaLanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfVoidFunction(UtaLanguageParser.DeclarationOfVoidFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#blockOfStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockOfStatements(UtaLanguageParser.BlockOfStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#blockOfStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockOfStatements(UtaLanguageParser.BlockOfStatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(UtaLanguageParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(UtaLanguageParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(UtaLanguageParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementForLoop(UtaLanguageParser.StatementForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementForLoop(UtaLanguageParser.StatementForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIteration(UtaLanguageParser.StatementIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIteration(UtaLanguageParser.StatementIterationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhileLoop(UtaLanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhileLoop(UtaLanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDoWhile(UtaLanguageParser.StatementDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDoWhile(UtaLanguageParser.StatementDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementConditional(UtaLanguageParser.StatementConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementConditional(UtaLanguageParser.StatementConditionalContext ctx);
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
	 * Enter a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementEmpty(UtaLanguageParser.StatementEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UtaLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementEmpty(UtaLanguageParser.StatementEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#primaryStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryStatement(UtaLanguageParser.PrimaryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#primaryStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryStatement(UtaLanguageParser.PrimaryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#alternativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeStatement(UtaLanguageParser.AlternativeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#alternativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeStatement(UtaLanguageParser.AlternativeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 */
	void enterLoopInitializer(UtaLanguageParser.LoopInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 */
	void exitLoopInitializer(UtaLanguageParser.LoopInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 */
	void enterLoopCondition(UtaLanguageParser.LoopConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 */
	void exitLoopCondition(UtaLanguageParser.LoopConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 */
	void enterLoopUpdate(UtaLanguageParser.LoopUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 */
	void exitLoopUpdate(UtaLanguageParser.LoopUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void enterLoopBody(UtaLanguageParser.LoopBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void exitLoopBody(UtaLanguageParser.LoopBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExistentialQuantification(UtaLanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExistentialQuantification(UtaLanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUniversalQuantification(UtaLanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUniversalQuantification(UtaLanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMultiplication(UtaLanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMultiplication(UtaLanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseAnd(UtaLanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseAnd(UtaLanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpGreaterThan(UtaLanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpGreaterThan(UtaLanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpMultiplication(UtaLanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpMultiplication(UtaLanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMaximum(UtaLanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMaximum(UtaLanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNaturalNumber(UtaLanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNaturalNumber(UtaLanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDecrementAndGet(UtaLanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDecrementAndGet(UtaLanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionCall}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCall(UtaLanguageParser.ExpressionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionCall}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCall(UtaLanguageParser.ExpressionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpAdditiveIdentity}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpAdditiveIdentity(UtaLanguageParser.ExpressionUnaryOpAdditiveIdentityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpAdditiveIdentity}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpAdditiveIdentity(UtaLanguageParser.ExpressionUnaryOpAdditiveIdentityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTernary(UtaLanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTernary(UtaLanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpEqual(UtaLanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpEqual(UtaLanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpModulo(UtaLanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpModulo(UtaLanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseXOR(UtaLanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseXOR(UtaLanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLessThanOrEqual(UtaLanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLessThanOrEqual(UtaLanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpRightShift(UtaLanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpRightShift(UtaLanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpConjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpConjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpNegatedPhrase(UtaLanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpNegatedPhrase(UtaLanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLessThan(UtaLanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLessThan(UtaLanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpSubtraction(UtaLanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpSubtraction(UtaLanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionIdentifierRef}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIdentifierRef(UtaLanguageParser.ExpressionIdentifierRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionIdentifierRef}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIdentifierRef(UtaLanguageParser.ExpressionIdentifierRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLeftShift(UtaLanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLeftShift(UtaLanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpSubtraction(UtaLanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpSubtraction(UtaLanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpAdditiveInverse}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpAdditiveInverse(UtaLanguageParser.ExpressionUnaryOpAdditiveInverseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpAdditiveInverse}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpAdditiveInverse(UtaLanguageParser.ExpressionUnaryOpAdditiveInverseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTrueLiteral(UtaLanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTrueLiteral(UtaLanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDisjunction(UtaLanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDisjunction(UtaLanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseXOR(UtaLanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseXOR(UtaLanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFalseLiteral(UtaLanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFalseLiteral(UtaLanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseAnd(UtaLanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseAnd(UtaLanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGetAndIncrement(UtaLanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGetAndIncrement(UtaLanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMinimum(UtaLanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMinimum(UtaLanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFieldAccess(UtaLanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFieldAccess(UtaLanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseOr(UtaLanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseOr(UtaLanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIncrementAndGet(UtaLanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIncrementAndGet(UtaLanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpAddition(UtaLanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpAddition(UtaLanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpRightShift(UtaLanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpRightShift(UtaLanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpNegated(UtaLanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpNegated(UtaLanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDeadlockLiteral(UtaLanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDeadlockLiteral(UtaLanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDivision(UtaLanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDivision(UtaLanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpNotEqual(UtaLanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpNotEqual(UtaLanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseOr(UtaLanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseOr(UtaLanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpDivision(UtaLanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpDivision(UtaLanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGrouped(UtaLanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGrouped(UtaLanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionArrayLookup(UtaLanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionArrayLookup}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionArrayLookup(UtaLanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDisjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDisjunctionPhrase(UtaLanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpGreaterThanOrEqual(UtaLanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpGreaterThanOrEqual(UtaLanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpLeftShift(UtaLanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpLeftShift(UtaLanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpModulo(UtaLanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpModulo(UtaLanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOp(UtaLanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOp(UtaLanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpImplicationPhrase(UtaLanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpImplicationPhrase(UtaLanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGetAndDecrement(UtaLanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGetAndDecrement(UtaLanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpConjunction(UtaLanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpConjunction(UtaLanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpAddition(UtaLanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UtaLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpAddition(UtaLanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UtaLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(UtaLanguageParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(UtaLanguageParser.ArgumentListContext ctx);
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
	 * Enter a parse tree produced by {@link UtaLanguageParser#arrayIdentifierLookup}.
	 * @param ctx the parse tree
	 */
	void enterArrayIdentifierLookup(UtaLanguageParser.ArrayIdentifierLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link UtaLanguageParser#arrayIdentifierLookup}.
	 * @param ctx the parse tree
	 */
	void exitArrayIdentifierLookup(UtaLanguageParser.ArrayIdentifierLookupContext ctx);
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
	 * Enter a parse tree produced by the {@code ArrayIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 */
	void enterArrayIdentifier(UtaLanguageParser.ArrayIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 */
	void exitArrayIdentifier(UtaLanguageParser.ArrayIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 */
	void enterBaseIdentifier(UtaLanguageParser.BaseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link UtaLanguageParser#identifierNameVariant}.
	 * @param ctx the parse tree
	 */
	void exitBaseIdentifier(UtaLanguageParser.BaseIdentifierContext ctx);
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