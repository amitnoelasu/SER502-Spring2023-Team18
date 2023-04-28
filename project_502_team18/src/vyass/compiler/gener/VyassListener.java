// Generated from C:/Users/sdhulip7/Documents/SER502-Spring2023-Team18/project_502_team18/src\Vyass.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VyassParser}.
 */
public interface VyassListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VyassParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(VyassParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(VyassParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#literalConst}.
	 * @param ctx the parse tree
	 */
	void enterLiteralConst(VyassParser.LiteralConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#literalConst}.
	 * @param ctx the parse tree
	 */
	void exitLiteralConst(VyassParser.LiteralConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#dType}.
	 * @param ctx the parse tree
	 */
	void enterDType(VyassParser.DTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#dType}.
	 * @param ctx the parse tree
	 */
	void exitDType(VyassParser.DTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VyassParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VyassParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#mainFunctionBlock}.
	 * @param ctx the parse tree
	 */
	void enterMainFunctionBlock(VyassParser.MainFunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#mainFunctionBlock}.
	 * @param ctx the parse tree
	 */
	void exitMainFunctionBlock(VyassParser.MainFunctionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void enterExprBlock(VyassParser.ExprBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#exprBlock}.
	 * @param ctx the parse tree
	 */
	void exitExprBlock(VyassParser.ExprBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#variableDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarations(VyassParser.VariableDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#variableDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarations(VyassParser.VariableDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(VyassParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(VyassParser.VariableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#variableListMulti}.
	 * @param ctx the parse tree
	 */
	void enterVariableListMulti(VyassParser.VariableListMultiContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#variableListMulti}.
	 * @param ctx the parse tree
	 */
	void exitVariableListMulti(VyassParser.VariableListMultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitialization(VyassParser.VariableInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#variableInitialization}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitialization(VyassParser.VariableInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#functionDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclarations(VyassParser.FunctionDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#functionDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclarations(VyassParser.FunctionDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(VyassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(VyassParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#multiParameter}.
	 * @param ctx the parse tree
	 */
	void enterMultiParameter(VyassParser.MultiParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#multiParameter}.
	 * @param ctx the parse tree
	 */
	void exitMultiParameter(VyassParser.MultiParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(VyassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(VyassParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBlock(VyassParser.FunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBlock(VyassParser.FunctionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(VyassParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(VyassParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(VyassParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(VyassParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#assignmentList}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentList(VyassParser.AssignmentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#assignmentList}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentList(VyassParser.AssignmentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(VyassParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(VyassParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(VyassParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(VyassParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(VyassParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(VyassParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(VyassParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(VyassParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#conditionalBlock}.
	 * @param ctx the parse tree
	 */
	void enterConditionalBlock(VyassParser.ConditionalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#conditionalBlock}.
	 * @param ctx the parse tree
	 */
	void exitConditionalBlock(VyassParser.ConditionalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#elifList}.
	 * @param ctx the parse tree
	 */
	void enterElifList(VyassParser.ElifListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#elifList}.
	 * @param ctx the parse tree
	 */
	void exitElifList(VyassParser.ElifListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(VyassParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(VyassParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(VyassParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(VyassParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#iterativeBlock}.
	 * @param ctx the parse tree
	 */
	void enterIterativeBlock(VyassParser.IterativeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#iterativeBlock}.
	 * @param ctx the parse tree
	 */
	void exitIterativeBlock(VyassParser.IterativeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#whileTraditionalBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileTraditionalBlock(VyassParser.WhileTraditionalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#whileTraditionalBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileTraditionalBlock(VyassParser.WhileTraditionalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhileCondition(VyassParser.WhileConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhileCondition(VyassParser.WhileConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void enterForBlock(VyassParser.ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void exitForBlock(VyassParser.ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forTraditionalBlock}.
	 * @param ctx the parse tree
	 */
	void enterForTraditionalBlock(VyassParser.ForTraditionalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forTraditionalBlock}.
	 * @param ctx the parse tree
	 */
	void exitForTraditionalBlock(VyassParser.ForTraditionalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forInRangeBlock}.
	 * @param ctx the parse tree
	 */
	void enterForInRangeBlock(VyassParser.ForInRangeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forInRangeBlock}.
	 * @param ctx the parse tree
	 */
	void exitForInRangeBlock(VyassParser.ForInRangeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(VyassParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(VyassParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitStatement(VyassParser.ForInitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitStatement(VyassParser.ForInitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(VyassParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(VyassParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(VyassParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(VyassParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forUpdateStatement}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateStatement(VyassParser.ForUpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forUpdateStatement}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateStatement(VyassParser.ForUpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forAssign}.
	 * @param ctx the parse tree
	 */
	void enterForAssign(VyassParser.ForAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forAssign}.
	 * @param ctx the parse tree
	 */
	void exitForAssign(VyassParser.ForAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forInRangeLowerLimit}.
	 * @param ctx the parse tree
	 */
	void enterForInRangeLowerLimit(VyassParser.ForInRangeLowerLimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forInRangeLowerLimit}.
	 * @param ctx the parse tree
	 */
	void exitForInRangeLowerLimit(VyassParser.ForInRangeLowerLimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#forInRangeUpperLimit}.
	 * @param ctx the parse tree
	 */
	void enterForInRangeUpperLimit(VyassParser.ForInRangeUpperLimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#forInRangeUpperLimit}.
	 * @param ctx the parse tree
	 */
	void exitForInRangeUpperLimit(VyassParser.ForInRangeUpperLimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(VyassParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(VyassParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link VyassParser#expressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpress}.
	 * @param ctx the parse tree
	 */
	void enterValues(VyassParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link VyassParser#expressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpress}.
	 * @param ctx the parse tree
	 */
	void exitValues(VyassParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#functionValue}.
	 * @param ctx the parse tree
	 */
	void enterFunctionValue(VyassParser.FunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#functionValue}.
	 * @param ctx the parse tree
	 */
	void exitFunctionValue(VyassParser.FunctionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#rExpress}.
	 * @param ctx the parse tree
	 */
	void enterRExpress(VyassParser.RExpressContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#rExpress}.
	 * @param ctx the parse tree
	 */
	void exitRExpress(VyassParser.RExpressContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryLessThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLessThanEqualsExpression(VyassParser.BinaryLessThanEqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryLessThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLessThanEqualsExpression(VyassParser.BinaryLessThanEqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryGreaterThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryGreaterThanEqualsExpression(VyassParser.BinaryGreaterThanEqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryGreaterThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryGreaterThanEqualsExpression(VyassParser.BinaryGreaterThanEqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryNotExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNotExpression(VyassParser.UnaryNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryNotExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNotExpression(VyassParser.UnaryNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(VyassParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(VyassParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryEqualsExpression(VyassParser.BinaryEqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryEqualsExpression(VyassParser.BinaryEqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralExpression(VyassParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralExpression(VyassParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(VyassParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(VyassParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binarySubstractionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinarySubstractionExpression(VyassParser.BinarySubstractionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binarySubstractionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinarySubstractionExpression(VyassParser.BinarySubstractionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryNotEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryNotEqualsExpression(VyassParser.BinaryNotEqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryNotEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryNotEqualsExpression(VyassParser.BinaryNotEqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryModulusExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryModulusExpression(VyassParser.BinaryModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryModulusExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryModulusExpression(VyassParser.BinaryModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpression(VyassParser.StringLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpression(VyassParser.StringLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryLessThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLessThanExpression(VyassParser.BinaryLessThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryLessThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLessThanExpression(VyassParser.BinaryLessThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parametersExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterParametersExpression(VyassParser.ParametersExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parametersExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitParametersExpression(VyassParser.ParametersExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryDivisionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryDivisionExpression(VyassParser.BinaryDivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryDivisionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryDivisionExpression(VyassParser.BinaryDivisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteralExpression(VyassParser.IntegerLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteralExpression(VyassParser.IntegerLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(VyassParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(VyassParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryCondnExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterTernaryCondnExpression(VyassParser.TernaryCondnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryCondnExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitTernaryCondnExpression(VyassParser.TernaryCondnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(VyassParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(VyassParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryMultiplicationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryMultiplicationExpression(VyassParser.BinaryMultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryMultiplicationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryMultiplicationExpression(VyassParser.BinaryMultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryGreaterThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryGreaterThanExpression(VyassParser.BinaryGreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryGreaterThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryGreaterThanExpression(VyassParser.BinaryGreaterThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryNegationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNegationExpression(VyassParser.UnaryNegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryNegationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNegationExpression(VyassParser.UnaryNegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryAdditionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void enterBinaryAdditionExpression(VyassParser.BinaryAdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryAdditionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 */
	void exitBinaryAdditionExpression(VyassParser.BinaryAdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#ternaryTrue}.
	 * @param ctx the parse tree
	 */
	void enterTernaryTrue(VyassParser.TernaryTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#ternaryTrue}.
	 * @param ctx the parse tree
	 */
	void exitTernaryTrue(VyassParser.TernaryTrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link VyassParser#ternaryFalse}.
	 * @param ctx the parse tree
	 */
	void enterTernaryFalse(VyassParser.TernaryFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VyassParser#ternaryFalse}.
	 * @param ctx the parse tree
	 */
	void exitTernaryFalse(VyassParser.TernaryFalseContext ctx);
}