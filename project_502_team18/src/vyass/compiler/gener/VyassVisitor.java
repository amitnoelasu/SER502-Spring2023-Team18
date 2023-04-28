// Generated from C:/Users/sdhulip7/Documents/SER502-Spring2023-Team18/project_502_team18/src\Vyass.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VyassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VyassVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VyassParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(VyassParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#literalConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralConst(VyassParser.LiteralConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#dType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDType(VyassParser.DTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(VyassParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#mainFunctionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunctionBlock(VyassParser.MainFunctionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#exprBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBlock(VyassParser.ExprBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#variableDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarations(VyassParser.VariableDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#variableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableList(VyassParser.VariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#variableListMulti}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableListMulti(VyassParser.VariableListMultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#variableInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitialization(VyassParser.VariableInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#functionDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarations(VyassParser.FunctionDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(VyassParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#multiParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParameter(VyassParser.MultiParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(VyassParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#functionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBlock(VyassParser.FunctionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(VyassParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(VyassParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#assignmentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentList(VyassParser.AssignmentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(VyassParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(VyassParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(VyassParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(VyassParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#conditionalBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalBlock(VyassParser.ConditionalBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#elifList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifList(VyassParser.ElifListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(VyassParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(VyassParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#iterativeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterativeBlock(VyassParser.IterativeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#whileTraditionalBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileTraditionalBlock(VyassParser.WhileTraditionalBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(VyassParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBlock(VyassParser.ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forTraditionalBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForTraditionalBlock(VyassParser.ForTraditionalBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forInRangeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInRangeBlock(VyassParser.ForInRangeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(VyassParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forInitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitStatement(VyassParser.ForInitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(VyassParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(VyassParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forUpdateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateStatement(VyassParser.ForUpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAssign(VyassParser.ForAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forInRangeLowerLimit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInRangeLowerLimit(VyassParser.ForInRangeLowerLimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#forInRangeUpperLimit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInRangeUpperLimit(VyassParser.ForInRangeUpperLimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(VyassParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link VyassParser#expressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpressexpress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(VyassParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#functionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValue(VyassParser.FunctionValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#rExpress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRExpress(VyassParser.RExpressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryLessThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryLessThanEqualsExpression(VyassParser.BinaryLessThanEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryGreaterThanEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryGreaterThanEqualsExpression(VyassParser.BinaryGreaterThanEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryNotExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryNotExpression(VyassParser.UnaryNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(VyassParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryEqualsExpression(VyassParser.BinaryEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteralExpression(VyassParser.BooleanLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(VyassParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binarySubstractionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarySubstractionExpression(VyassParser.BinarySubstractionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryNotEqualsExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryNotEqualsExpression(VyassParser.BinaryNotEqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryModulusExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryModulusExpression(VyassParser.BinaryModulusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpression(VyassParser.StringLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryLessThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryLessThanExpression(VyassParser.BinaryLessThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parametersExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersExpression(VyassParser.ParametersExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDivisionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDivisionExpression(VyassParser.BinaryDivisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteralExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralExpression(VyassParser.IntegerLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(VyassParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryCondnExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryCondnExpression(VyassParser.TernaryCondnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(VyassParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryMultiplicationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMultiplicationExpression(VyassParser.BinaryMultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryGreaterThanExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryGreaterThanExpression(VyassParser.BinaryGreaterThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryNegationExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryNegationExpression(VyassParser.UnaryNegationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryAdditionExpression}
	 * labeled alternative in {@link VyassParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAdditionExpression(VyassParser.BinaryAdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#ternaryTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryTrue(VyassParser.TernaryTrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyassParser#ternaryFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryFalse(VyassParser.TernaryFalseContext ctx);
}