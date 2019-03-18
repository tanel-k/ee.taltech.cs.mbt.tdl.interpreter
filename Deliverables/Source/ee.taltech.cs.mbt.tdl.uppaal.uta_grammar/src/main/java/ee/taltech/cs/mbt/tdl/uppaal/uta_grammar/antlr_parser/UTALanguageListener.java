// Generated from UTALanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UTALanguageParser}.
 */
public interface UTALanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaTemplateParameterList}.
	 * @param ctx the parse tree
	 */
	void enterUtaTemplateParameterList(UTALanguageParser.UtaTemplateParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaTemplateParameterList}.
	 * @param ctx the parse tree
	 */
	void exitUtaTemplateParameterList(UTALanguageParser.UtaTemplateParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionUpdateList(UTALanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaTransitionUpdateList}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionUpdateList(UTALanguageParser.UtaTransitionUpdateListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void enterActiveSynchronization(UTALanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ActiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void exitActiveSynchronization(UTALanguageParser.ActiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void enterReactiveSynchronization(UTALanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReactiveSynchronization}
	 * labeled alternative in {@link UTALanguageParser#utaTransitionSynchronization}.
	 * @param ctx the parse tree
	 */
	void exitReactiveSynchronization(UTALanguageParser.ReactiveSynchronizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 */
	void enterUtaLocationInvariantExpression(UTALanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaLocationInvariantExpression}.
	 * @param ctx the parse tree
	 */
	void exitUtaLocationInvariantExpression(UTALanguageParser.UtaLocationInvariantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionGuardExpression(UTALanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaTransitionGuardExpression}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionGuardExpression(UTALanguageParser.UtaTransitionGuardExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaTransitionSelectionList}.
	 * @param ctx the parse tree
	 */
	void enterUtaTransitionSelectionList(UTALanguageParser.UtaTransitionSelectionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaTransitionSelectionList}.
	 * @param ctx the parse tree
	 */
	void exitUtaTransitionSelectionList(UTALanguageParser.UtaTransitionSelectionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterUtaDeclarationList(UTALanguageParser.UtaDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitUtaDeclarationList(UTALanguageParser.UtaDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 */
	void enterUtaSystemDefinition(UTALanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#utaSystemDefinition}.
	 * @param ctx the parse tree
	 */
	void exitUtaSystemDefinition(UTALanguageParser.UtaSystemDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void enterSystemDeclarationBody(UTALanguageParser.SystemDeclarationBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void exitSystemDeclarationBody(UTALanguageParser.SystemDeclarationBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSystemDeclaration(UTALanguageParser.SystemDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSystemDeclaration(UTALanguageParser.SystemDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#processVariableAssignments}.
	 * @param ctx the parse tree
	 */
	void enterProcessVariableAssignments(UTALanguageParser.ProcessVariableAssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#processVariableAssignments}.
	 * @param ctx the parse tree
	 */
	void exitProcessVariableAssignments(UTALanguageParser.ProcessVariableAssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcessVarPartialTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterProcessVarPartialTemplateInstantiation(UTALanguageParser.ProcessVarPartialTemplateInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcessVarPartialTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitProcessVarPartialTemplateInstantiation(UTALanguageParser.ProcessVarPartialTemplateInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcessVarFullTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterProcessVarFullTemplateInstantiation(UTALanguageParser.ProcessVarFullTemplateInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcessVarFullTemplateInstantiation}
	 * labeled alternative in {@link UTALanguageParser#processVariableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitProcessVarFullTemplateInstantiation(UTALanguageParser.ProcessVarFullTemplateInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemLine}.
	 * @param ctx the parse tree
	 */
	void enterSystemLine(UTALanguageParser.SystemLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemLine}.
	 * @param ctx the parse tree
	 */
	void exitSystemLine(UTALanguageParser.SystemLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessesList(UTALanguageParser.SystemProcessesListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemProcessesList}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessesList(UTALanguageParser.SystemProcessesListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessRefList(UTALanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemProcessRefList}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessRefList(UTALanguageParser.SystemProcessRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#systemProcessExpression}.
	 * @param ctx the parse tree
	 */
	void enterSystemProcessExpression(UTALanguageParser.SystemProcessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#systemProcessExpression}.
	 * @param ctx the parse tree
	 */
	void exitSystemProcessExpression(UTALanguageParser.SystemProcessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgressMeasureDeclaration(UTALanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#progressMeasureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgressMeasureDeclaration(UTALanguageParser.ProgressMeasureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(UTALanguageParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(UTALanguageParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(UTALanguageParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(UTALanguageParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(UTALanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(UTALanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#declarationOfChannelPriority}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfChannelPriority(UTALanguageParser.DeclarationOfChannelPriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#declarationOfChannelPriority}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfChannelPriority(UTALanguageParser.DeclarationOfChannelPriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelPrioritySpecExpression(UTALanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#channelPrioritySpecExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelPrioritySpecExpression(UTALanguageParser.ChannelPrioritySpecExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 */
	void enterChannelRefList(UTALanguageParser.ChannelRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#channelRefList}.
	 * @param ctx the parse tree
	 */
	void exitChannelRefList(UTALanguageParser.ChannelRefListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelDefaultPriorityRef}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelDefaultPriorityRef(UTALanguageParser.ChannelDefaultPriorityRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelDefaultPriorityRef}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelDefaultPriorityRef(UTALanguageParser.ChannelDefaultPriorityRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelVariablePriorityRef}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelVariablePriorityRef(UTALanguageParser.ChannelVariablePriorityRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelVariablePriorityRef}
	 * labeled alternative in {@link UTALanguageParser#channelRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelVariablePriorityRef(UTALanguageParser.ChannelVariablePriorityRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelVarRefArrayLookup}
	 * labeled alternative in {@link UTALanguageParser#channelVariableRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelVarRefArrayLookup(UTALanguageParser.ChannelVarRefArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelVarRefArrayLookup}
	 * labeled alternative in {@link UTALanguageParser#channelVariableRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelVarRefArrayLookup(UTALanguageParser.ChannelVarRefArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChannelVarIdentifierRef}
	 * labeled alternative in {@link UTALanguageParser#channelVariableRefExpression}.
	 * @param ctx the parse tree
	 */
	void enterChannelVarIdentifierRef(UTALanguageParser.ChannelVarIdentifierRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChannelVarIdentifierRef}
	 * labeled alternative in {@link UTALanguageParser#channelVariableRefExpression}.
	 * @param ctx the parse tree
	 */
	void exitChannelVarIdentifierRef(UTALanguageParser.ChannelVarIdentifierRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#declarationOfVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfVariable(UTALanguageParser.DeclarationOfVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#declarationOfVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfVariable(UTALanguageParser.DeclarationOfVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitialization(UTALanguageParser.VariableInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitialization(UTALanguageParser.VariableInitializationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitializerBase}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void enterInitializerBase(UTALanguageParser.InitializerBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitializerBase}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void exitInitializerBase(UTALanguageParser.InitializerBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitializerForArray}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void enterInitializerForArray(UTALanguageParser.InitializerForArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitializerForArray}
	 * labeled alternative in {@link UTALanguageParser#initializerExpression}.
	 * @param ctx the parse tree
	 */
	void exitInitializerForArray(UTALanguageParser.InitializerForArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#declarationOfType}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfType(UTALanguageParser.DeclarationOfTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#declarationOfType}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfType(UTALanguageParser.DeclarationOfTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationOfFunctionWithReturnType}
	 * labeled alternative in {@link UTALanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfFunctionWithReturnType(UTALanguageParser.DeclarationOfFunctionWithReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationOfFunctionWithReturnType}
	 * labeled alternative in {@link UTALanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfFunctionWithReturnType(UTALanguageParser.DeclarationOfFunctionWithReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationOfVoidFunction}
	 * labeled alternative in {@link UTALanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationOfVoidFunction(UTALanguageParser.DeclarationOfVoidFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationOfVoidFunction}
	 * labeled alternative in {@link UTALanguageParser#declarationOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationOfVoidFunction(UTALanguageParser.DeclarationOfVoidFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#functionNameParamsBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionNameParamsBody(UTALanguageParser.FunctionNameParamsBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#functionNameParamsBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionNameParamsBody(UTALanguageParser.FunctionNameParamsBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(UTALanguageParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(UTALanguageParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatetementBlock}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatetementBlock(UTALanguageParser.StatetementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatetementBlock}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatetementBlock(UTALanguageParser.StatetementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementEmpty(UTALanguageParser.StatementEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementEmpty(UTALanguageParser.StatementEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(UTALanguageParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(UTALanguageParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementForLoop(UTALanguageParser.StatementForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementForLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementForLoop(UTALanguageParser.StatementForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIteration(UTALanguageParser.StatementIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIteration}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIteration(UTALanguageParser.StatementIterationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWhileLoop(UTALanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementWhileLoop}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWhileLoop(UTALanguageParser.StatementWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDoWhile(UTALanguageParser.StatementDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementDoWhile}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDoWhile(UTALanguageParser.StatementDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementConditional(UTALanguageParser.StatementConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementConditional}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementConditional(UTALanguageParser.StatementConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(UTALanguageParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link UTALanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(UTALanguageParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#forLoopStatement}.
	 * @param ctx the parse tree
	 */
	void enterForLoopStatement(UTALanguageParser.ForLoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#forLoopStatement}.
	 * @param ctx the parse tree
	 */
	void exitForLoopStatement(UTALanguageParser.ForLoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#forLoopHeader}.
	 * @param ctx the parse tree
	 */
	void enterForLoopHeader(UTALanguageParser.ForLoopHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#forLoopHeader}.
	 * @param ctx the parse tree
	 */
	void exitForLoopHeader(UTALanguageParser.ForLoopHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(UTALanguageParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(UTALanguageParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#iterationHeader}.
	 * @param ctx the parse tree
	 */
	void enterIterationHeader(UTALanguageParser.IterationHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#iterationHeader}.
	 * @param ctx the parse tree
	 */
	void exitIterationHeader(UTALanguageParser.IterationHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoopStatement(UTALanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoopStatement(UTALanguageParser.WhileLoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#whileLoopHeader}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoopHeader(UTALanguageParser.WhileLoopHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#whileLoopHeader}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoopHeader(UTALanguageParser.WhileLoopHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(UTALanguageParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(UTALanguageParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(UTALanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(UTALanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(UTALanguageParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(UTALanguageParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 */
	void enterLoopInitializer(UTALanguageParser.LoopInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#loopInitializer}.
	 * @param ctx the parse tree
	 */
	void exitLoopInitializer(UTALanguageParser.LoopInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 */
	void enterLoopCondition(UTALanguageParser.LoopConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#loopCondition}.
	 * @param ctx the parse tree
	 */
	void exitLoopCondition(UTALanguageParser.LoopConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 */
	void enterLoopUpdate(UTALanguageParser.LoopUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#loopUpdate}.
	 * @param ctx the parse tree
	 */
	void exitLoopUpdate(UTALanguageParser.LoopUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void enterLoopBody(UTALanguageParser.LoopBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void exitLoopBody(UTALanguageParser.LoopBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExistentialQuantification(UTALanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionExistentialQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExistentialQuantification(UTALanguageParser.ExpressionExistentialQuantificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUniversalQuantification(UTALanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUniversalQuantification}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUniversalQuantification(UTALanguageParser.ExpressionUniversalQuantificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMultiplication(UTALanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMultiplication(UTALanguageParser.ExpressionBinaryOpMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseAnd(UTALanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseAnd(UTALanguageParser.ExpressionAssignOpBitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpGreaterThan(UTALanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpGreaterThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpGreaterThan(UTALanguageParser.ExpressionBinaryOpGreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpMultiplication(UTALanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpMultiplication}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpMultiplication(UTALanguageParser.ExpressionAssignOpMultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMaximum(UTALanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMaximum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMaximum(UTALanguageParser.ExpressionBinaryOpMaximumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNaturalNumber(UTALanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionNaturalNumber}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNaturalNumber(UTALanguageParser.ExpressionNaturalNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDecrementAndGet(UTALanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionDecrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDecrementAndGet(UTALanguageParser.ExpressionDecrementAndGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionCall}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCall(UTALanguageParser.ExpressionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionCall}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCall(UTALanguageParser.ExpressionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTernary(UTALanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTernary(UTALanguageParser.ExpressionTernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpEqual(UTALanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpEqual(UTALanguageParser.ExpressionBinaryOpEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpModulo(UTALanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpModulo(UTALanguageParser.ExpressionAssignOpModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseXOR(UTALanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseXOR(UTALanguageParser.ExpressionAssignOpBitwiseXORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLessThanOrEqual(UTALanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLessThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLessThanOrEqual(UTALanguageParser.ExpressionBinaryOpLessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpRightShift(UTALanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpRightShift(UTALanguageParser.ExpressionBinaryOpRightShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpConjunctionPhrase(UTALanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpConjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpConjunctionPhrase(UTALanguageParser.ExpressionBinaryOpConjunctionPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpNegatedPhrase(UTALanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpNegatedPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpNegatedPhrase(UTALanguageParser.ExpressionUnaryOpNegatedPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLessThan(UTALanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLessThan}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLessThan(UTALanguageParser.ExpressionBinaryOpLessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpSubtraction(UTALanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpSubtraction(UTALanguageParser.ExpressionAssignOpSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionIdentifierRef}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIdentifierRef(UTALanguageParser.ExpressionIdentifierRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionIdentifierRef}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIdentifierRef(UTALanguageParser.ExpressionIdentifierRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpLeftShift(UTALanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpLeftShift(UTALanguageParser.ExpressionBinaryOpLeftShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpSubtraction(UTALanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpSubtraction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpSubtraction(UTALanguageParser.ExpressionBinaryOpSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTrueLiteral(UTALanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionTrueLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTrueLiteral(UTALanguageParser.ExpressionTrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDisjunction(UTALanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDisjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDisjunction(UTALanguageParser.ExpressionBinaryOpDisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseXOR(UTALanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseXOR}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseXOR(UTALanguageParser.ExpressionBinaryOpBitwiseXORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFalseLiteral(UTALanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionFalseLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFalseLiteral(UTALanguageParser.ExpressionFalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseAnd(UTALanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseAnd}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseAnd(UTALanguageParser.ExpressionBinaryOpBitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGetAndIncrement(UTALanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGetAndIncrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGetAndIncrement(UTALanguageParser.ExpressionGetAndIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpMinimum(UTALanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpMinimum}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpMinimum(UTALanguageParser.ExpressionBinaryOpMinimumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFieldAccess(UTALanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionFieldAccess}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFieldAccess(UTALanguageParser.ExpressionFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpBitwiseOr(UTALanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpBitwiseOr(UTALanguageParser.ExpressionBinaryOpBitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIncrementAndGet(UTALanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionIncrementAndGet}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIncrementAndGet(UTALanguageParser.ExpressionIncrementAndGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpAddition(UTALanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpAddition(UTALanguageParser.ExpressionBinaryOpAdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpRightShift(UTALanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpRightShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpRightShift(UTALanguageParser.ExpressionAssignOpRightShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpNegated(UTALanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpNegated}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpNegated(UTALanguageParser.ExpressionUnaryOpNegatedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionDeadlockLiteral(UTALanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionDeadlockLiteral}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionDeadlockLiteral(UTALanguageParser.ExpressionDeadlockLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDivision(UTALanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDivision(UTALanguageParser.ExpressionBinaryOpDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpNotEqual(UTALanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpNotEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpNotEqual(UTALanguageParser.ExpressionBinaryOpNotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpBitwiseOr(UTALanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpBitwiseOr}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpBitwiseOr(UTALanguageParser.ExpressionAssignOpBitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpDivision(UTALanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpDivision}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpDivision(UTALanguageParser.ExpressionAssignOpDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGrouped(UTALanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGrouped}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGrouped(UTALanguageParser.ExpressionGroupedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionArrayLookup}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionArrayLookup(UTALanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionArrayLookup}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionArrayLookup(UTALanguageParser.ExpressionArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpNegative}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpNegative(UTALanguageParser.ExpressionUnaryOpNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpNegative}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpNegative(UTALanguageParser.ExpressionUnaryOpNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpDisjunctionPhrase(UTALanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpDisjunctionPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpDisjunctionPhrase(UTALanguageParser.ExpressionBinaryOpDisjunctionPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpGreaterThanOrEqual(UTALanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpGreaterThanOrEqual}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpGreaterThanOrEqual(UTALanguageParser.ExpressionBinaryOpGreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpLeftShift(UTALanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpLeftShift}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpLeftShift(UTALanguageParser.ExpressionAssignOpLeftShiftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpModulo(UTALanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpModulo}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpModulo(UTALanguageParser.ExpressionBinaryOpModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOp(UTALanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOp}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOp(UTALanguageParser.ExpressionAssignOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpImplicationPhrase(UTALanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpImplicationPhrase}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpImplicationPhrase(UTALanguageParser.ExpressionBinaryOpImplicationPhraseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGetAndDecrement(UTALanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGetAndDecrement}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGetAndDecrement(UTALanguageParser.ExpressionGetAndDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnaryOpPositive}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnaryOpPositive(UTALanguageParser.ExpressionUnaryOpPositiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnaryOpPositive}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnaryOpPositive(UTALanguageParser.ExpressionUnaryOpPositiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinaryOpConjunction(UTALanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBinaryOpConjunction}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinaryOpConjunction(UTALanguageParser.ExpressionBinaryOpConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignOpAddition(UTALanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAssignOpAddition}
	 * labeled alternative in {@link UTALanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignOpAddition(UTALanguageParser.ExpressionAssignOpAdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(UTALanguageParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(UTALanguageParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(UTALanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(UTALanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterByReferenceVariable(UTALanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ByReferenceVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitByReferenceVariable(UTALanguageParser.ByReferenceVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterByValueVariable(UTALanguageParser.ByValueVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ByValueVariable}
	 * labeled alternative in {@link UTALanguageParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitByValueVariable(UTALanguageParser.ByValueVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(UTALanguageParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(UTALanguageParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(UTALanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(UTALanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdInteger(UTALanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdInteger}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdInteger(UTALanguageParser.TypeIdIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdClock(UTALanguageParser.TypeIdClockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdClock}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdClock(UTALanguageParser.TypeIdClockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdChannel(UTALanguageParser.TypeIdChannelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdChannel}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdChannel(UTALanguageParser.TypeIdChannelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdBoolean(UTALanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdBoolean}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdBoolean(UTALanguageParser.TypeIdBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdIntegerBounded(UTALanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdIntegerBounded}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdIntegerBounded(UTALanguageParser.TypeIdIntegerBoundedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdScalar(UTALanguageParser.TypeIdScalarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdScalar}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdScalar(UTALanguageParser.TypeIdScalarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdStruct(UTALanguageParser.TypeIdStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdStruct}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdStruct(UTALanguageParser.TypeIdStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeIdIdentifierName}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdIdentifierName(UTALanguageParser.TypeIdIdentifierNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeIdIdentifierName}
	 * labeled alternative in {@link UTALanguageParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdIdentifierName(UTALanguageParser.TypeIdIdentifierNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTALanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(UTALanguageParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTALanguageParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(UTALanguageParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayIdentifier}
	 * labeled alternative in {@link UTALanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterArrayIdentifier(UTALanguageParser.ArrayIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayIdentifier}
	 * labeled alternative in {@link UTALanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitArrayIdentifier(UTALanguageParser.ArrayIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link UTALanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseIdentifier(UTALanguageParser.BaseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link UTALanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseIdentifier(UTALanguageParser.BaseIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArraySizeFromExpression(UTALanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySizeFromExpression}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArraySizeFromExpression(UTALanguageParser.ArraySizeFromExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArraySizeFromType(UTALanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySizeFromType}
	 * labeled alternative in {@link UTALanguageParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArraySizeFromType(UTALanguageParser.ArraySizeFromTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixUrgent(UTALanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixUrgent}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixUrgent(UTALanguageParser.TypePrefixUrgentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixBroadcast(UTALanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixBroadcast}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixBroadcast(UTALanguageParser.TypePrefixBroadcastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixMeta(UTALanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixMeta}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixMeta(UTALanguageParser.TypePrefixMetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefixConstant(UTALanguageParser.TypePrefixConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrefixConstant}
	 * labeled alternative in {@link UTALanguageParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefixConstant(UTALanguageParser.TypePrefixConstantContext ctx);
}