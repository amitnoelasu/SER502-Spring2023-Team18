package vyass.compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import vyass.compiler.gener.VyassParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class CustomVyassListener extends vyass.compiler.gener.VyassBaseListener {
    public static final String INT_TYPE = "number";
    public static final String BOOL_TYPE = "bool";
    public static final String STR_TYPE = "str";

    //Intermediate code commands
    public static final String ASSIGN_CMD = "ASSIGN";
    public static final String METH_CMD = "METH";
    public static final String DISPLAY_CMD = "DISPLAY";
    public static final String RETURN_CMD = "RETURN";
    public static final String BREAK_CMD = "BREAK";
    public static final String CONTINUE_CMD = "CONTINUE";
    public static final String IF_CMD = "IF";
    public static final String TRUE_CONST = "TRUE";
    public static final String FALSE_CONST = "FALSE";
    public static final String LOOP_CMD = "LOOP";
    public static final String TERNARY_CMD = "TERNARY";
    public static final String NEG_CMD = "NEG";
    public static final String LOAD_CMD = "LOAD";
    public static final String ADD_CMD = "ADD";
    public static final String SUB_CMD = "SUB";
    public static final String MUL_CMD = "MUL";
    public static final String DIV_CMD = "DIV";
    public static final String MOD_CMD = "MOD";
    public static final String EQUALS_OPERATOR = "EQUALSTO";
    public static final String NOT_EQUALS_OPERATOR = "NOTEQUALS";
    public static final String LESS_THAN_OPERATOR = "LESSTHAN";
    public static final String GREATER_THAN_OPERATOR = "GREATERTHAN";
    public static final String LESS_THAN_OR_EQUALS_OPERATOR = "LESSTHANEQUALS";
    public static final String GREATER_THAN_OR_EQUALS_OPERATOR = "GREATERTHANEQUALS";
    public static final String AND_OPERATOR = "&&";
    public static final String OR_OPERATOR = "||";
    public static final String START_BLOCK = "{";
    public static final String END_BLOCK = "}";

    Map<String, String> variableMap;
    Map<String, List<String>> functionMap;
    Set<String> intermediateCodeKeywords;
    StringBuilder intermediateCodeBuilder;
    String currentFileName;

    String currentVariableType;
    String previousVariable;
    Stack<String> expressionStack;
    String lastExpressionResultType;
    StringBuilder temporaryStringBuilder;
    Stack<String> forLoopUpdateStack;
    Map<String, String> temporaryVariableMap;
    boolean isInMainBlock;
    String currentFunctionName;
    Stack<Pair<String, Integer>> functionCallPairStack;

    public String getIntermediateCodeBuilder() { return intermediateCodeBuilder.toString(); }

    public CustomVyassListener(String currentFileName) {
        this.currentFileName = currentFileName;

        this.isInMainBlock = false;
        this.intermediateCodeBuilder = new StringBuilder();
        this.variableMap = new HashMap<>();
        this.functionMap = new HashMap<>();
        this.expressionStack = new Stack<>();
        this.forLoopUpdateStack = new Stack<>();
        this.functionCallPairStack = new Stack<>();
        this.intermediateCodeKeywords = new HashSet<>();

        this.intermediateCodeKeywords.add(ASSIGN_CMD);
        this.intermediateCodeKeywords.add(METH_CMD);
        this.intermediateCodeKeywords.add(DISPLAY_CMD);
        this.intermediateCodeKeywords.add(RETURN_CMD);
        this.intermediateCodeKeywords.add(BREAK_CMD);
        this.intermediateCodeKeywords.add(CONTINUE_CMD);
        this.intermediateCodeKeywords.add(IF_CMD);
        this.intermediateCodeKeywords.add(TRUE_CONST);
        this.intermediateCodeKeywords.add(FALSE_CONST);
        this.intermediateCodeKeywords.add(LOOP_CMD);
        this.intermediateCodeKeywords.add(TERNARY_CMD);
        this.intermediateCodeKeywords.add(NEG_CMD);
        this.intermediateCodeKeywords.add(LOAD_CMD);
    }

    public void addVariableToContext(String identifier, String variableType, ParserRuleContext context) {
        if (intermediateCodeKeywords.contains(identifier)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + identifier + " is a reserved keyword, use a different identifier");
        }
        if (variableMap.containsKey(identifier)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "variable " + identifier + " is already defined");
        } else {
            variableMap.put(identifier, variableType);
        }
    }

    public String getConstType(VyassParser.LiteralConstContext constant) {
        if (constant.INTEGER_LITERAL() != null) {
            return INT_TYPE;
        } else if (constant.STRING_LITERAL() != null) {
            return STR_TYPE;
        } else if (constant.BOOLEAN_LITERAL() != null) {
            return BOOL_TYPE;
        }
        throw new RuntimeException(getPositionForErrorFunc(constant) + "Value " + constant.getText() + " is of invalid type");
    }

    public void validateExpressionCompatibility(String operator, String dataType, ParserRuleContext context) {
        String rightOperandType = expressionStack.pop();
        String leftOperandType = expressionStack.pop();
        if (!leftOperandType.equals(dataType)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + operator + " operation can't be performed on the left operand type " + leftOperandType);
        }
        if (!rightOperandType.equals(dataType)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + operator + " operation cannot be performed on the right operand type " + rightOperandType);
        }
    }

    public void validateUnaryExpressionCompatibility(String operator, String dataType, ParserRuleContext context) {
        String childTypeVar = expressionStack.pop();
        if (!childTypeVar.equals(dataType)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + operator + " operation cannot be performed on child type " + childTypeVar);
        }
    }

    public void compareExpressionCompatibility(String operator, ParserRuleContext context) {
        String rightOperandType = expressionStack.pop();
        String leftOperandType = expressionStack.pop();
        if (!rightOperandType.equals(leftOperandType)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Expression types on both sides of the operator " + operator + " don't match.");
        }
    }

    public String getPositionForErrorFunc(ParserRuleContext context) {
        return "line " + context.getStart().getLine() + ":" + context.getStart().getCharPositionInLine() + " ";
    }

    //Program listeners
    @Override
    public void exitProgram(VyassParser.ProgramContext context) {
        try {
            PrintWriter writerVar = new PrintWriter(currentFileName + ".int", "UTF-8");
            writerVar.print(intermediateCodeBuilder);
            writerVar.close();
        } catch (FileNotFoundException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void enterMainFunctionBlock(VyassParser.MainFunctionBlockContext ctx) {
        isInMainBlock = true;
    }

    //Variable initialization listeners
    @Override
    public void enterVariableDeclarations(VyassParser.VariableDeclarationsContext context) {
        this.currentVariableType = context.dType().getText();
    }

    @Override
    public void exitVariableDeclarations(VyassParser.VariableDeclarationsContext context) {
        this.currentVariableType = null;
    }

    @Override
    public void enterVariableInitialization(VyassParser.VariableInitializationContext context) {
        if (context.literalConst() != null) {
            if (!getConstType(context.literalConst()).equals(this.currentVariableType)) {
                throw new RuntimeException(getPositionForErrorFunc(context) + "Variable Type " + context.IDENTIFIER().getText() + " does not match the type of assigned value.");
            }

            addVariableToContext(context.IDENTIFIER().getText(), this.currentVariableType, context);

            intermediateCodeBuilder.append(ASSIGN_CMD + " ").append(context.IDENTIFIER().getText()).append(" ").append(context.literalConst().getText()).append("\n");
        } else {
            addVariableToContext(context.IDENTIFIER().getText(), this.currentVariableType, context);
        }
    }

    //Assignment listeners
    @Override
    public void exitAssignmentStatement(VyassParser.AssignmentStatementContext context) {
        intermediateCodeBuilder.append("\n");
        previousVariable = null;
    }

    @Override
    public void enterAssignmentList(VyassParser.AssignmentListContext context) {
        if (!variableMap.containsKey(context.IDENTIFIER().getText())) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Variable " + context.IDENTIFIER().getText() + " is not defined");
        }
        if (context.expression_expr() != null) {
            intermediateCodeBuilder.append(ASSIGN_CMD + " ").append(context.IDENTIFIER().getText()).append(" ");
            previousVariable = context.IDENTIFIER().getText();
        }
    }
    @Override
    public void exitAssignmentList(VyassParser.AssignmentListContext context) {
        if (context.expression_expr() == null) {
            intermediateCodeBuilder.append("\n");
            if (!variableMap.get(context.IDENTIFIER().getText()).equals(variableMap.get(previousVariable))) {
                throw new RuntimeException(getPositionForErrorFunc(context) + context.IDENTIFIER().getText() + " and the variable " + previousVariable + " are of different data types");
            }
            intermediateCodeBuilder.append(ASSIGN_CMD + " ").append(context.IDENTIFIER().getText()).append(" ").append(previousVariable);
            previousVariable = context.IDENTIFIER().getText();
        } else {
            if (!variableMap.get(context.IDENTIFIER().getText()).equals(lastExpressionResultType)) {
                throw new RuntimeException(getPositionForErrorFunc(context) + context.IDENTIFIER().getText() + " and the assigned expression dont have the same data type");
            }
            lastExpressionResultType = null;
        }
    }

    //Expression listeners
    @Override
    public void enterExpression_expr(VyassParser.Expression_exprContext context) {
        lastExpressionResultType = null;
    }

    @Override
    public void exitExpression_expr(VyassParser.Expression_exprContext context) {
        lastExpressionResultType = expressionStack.pop();
    }

    @Override
    public void enterRExpress(VyassParser.RExpressContext context) {
        intermediateCodeBuilder.append(", ");
    }

    @Override
    public void enterBinaryAdditionExpression(VyassParser.BinaryAdditionExpressionContext context) {
        intermediateCodeBuilder.append(ADD_CMD + " ");
    }

    @Override
    public void exitBinaryAdditionExpression(VyassParser.BinaryAdditionExpressionContext context) {
        validateExpressionCompatibility(ADD_CMD, INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterBinarySubstractionExpression(VyassParser.BinarySubstractionExpressionContext context) {
        intermediateCodeBuilder.append(SUB_CMD + " ");
    }

    @Override
    public void exitBinarySubstractionExpression(VyassParser.BinarySubstractionExpressionContext context) {
        validateExpressionCompatibility(SUB_CMD, INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterBinaryMultiplicationExpression(VyassParser.BinaryMultiplicationExpressionContext context) {
        intermediateCodeBuilder.append(MUL_CMD + " ");
    }

    @Override
    public void exitBinaryMultiplicationExpression(VyassParser.BinaryMultiplicationExpressionContext context) {
        validateExpressionCompatibility(MUL_CMD, INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterBinaryDivisionExpression(VyassParser.BinaryDivisionExpressionContext context) {
        intermediateCodeBuilder.append(DIV_CMD + " ");
    }

    @Override
    public void exitBinaryDivisionExpression(VyassParser.BinaryDivisionExpressionContext context) {
        validateExpressionCompatibility(DIV_CMD, INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterBinaryModulusExpression(VyassParser.BinaryModulusExpressionContext context) {
        intermediateCodeBuilder.append(MOD_CMD + " ");
    }

    @Override
    public void exitBinaryModulusExpression(VyassParser.BinaryModulusExpressionContext context) {
        validateExpressionCompatibility(MOD_CMD, INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterUnaryNegationExpression(VyassParser.UnaryNegationExpressionContext context) {
        intermediateCodeBuilder.append(NEG_CMD + " ");
    }

    @Override
    public void exitUnaryNegationExpression(VyassParser.UnaryNegationExpressionContext context) {
        validateUnaryExpressionCompatibility("'-' unary", INT_TYPE, context);
        expressionStack.push(INT_TYPE);
    }


    @Override
    public void enterUnaryNotExpression(VyassParser.UnaryNotExpressionContext context) {
        intermediateCodeBuilder.append(NEG_CMD + " ");
    }

    @Override
    public void exitUnaryNotExpression(VyassParser.UnaryNotExpressionContext context) {
        validateUnaryExpressionCompatibility(NEG_CMD, BOOL_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryEqualsExpression(VyassParser.BinaryEqualsExpressionContext context) {
        intermediateCodeBuilder.append(EQUALS_OPERATOR + " ");
    }

    @Override
    public void exitBinaryEqualsExpression(VyassParser.BinaryEqualsExpressionContext context) {
        compareExpressionCompatibility(EQUALS_OPERATOR, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryNotEqualsExpression(VyassParser.BinaryNotEqualsExpressionContext context) {
        intermediateCodeBuilder.append(NOT_EQUALS_OPERATOR + " ");
    }

    @Override
    public void exitBinaryNotEqualsExpression(VyassParser.BinaryNotEqualsExpressionContext context) {
        compareExpressionCompatibility(NOT_EQUALS_OPERATOR, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryLessThanExpression(VyassParser.BinaryLessThanExpressionContext context) {
        intermediateCodeBuilder.append(LESS_THAN_OPERATOR + " ");
    }

    @Override
    public void exitBinaryLessThanExpression(VyassParser.BinaryLessThanExpressionContext context) {
        validateExpressionCompatibility(LESS_THAN_OPERATOR, INT_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryGreaterThanExpression(VyassParser.BinaryGreaterThanExpressionContext context) {
        intermediateCodeBuilder.append(GREATER_THAN_OPERATOR + " ");
    }

    @Override
    public void exitBinaryGreaterThanExpression(VyassParser.BinaryGreaterThanExpressionContext context) {
        validateExpressionCompatibility(GREATER_THAN_OPERATOR, INT_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryLessThanEqualsExpression(VyassParser.BinaryLessThanEqualsExpressionContext context) {
        intermediateCodeBuilder.append(LESS_THAN_OR_EQUALS_OPERATOR + " ");
    }

    @Override
    public void exitBinaryLessThanEqualsExpression(VyassParser.BinaryLessThanEqualsExpressionContext context) {
        validateExpressionCompatibility(LESS_THAN_OR_EQUALS_OPERATOR, INT_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterBinaryGreaterThanEqualsExpression(VyassParser.BinaryGreaterThanEqualsExpressionContext context) {
        intermediateCodeBuilder.append(GREATER_THAN_OR_EQUALS_OPERATOR + " ");
    }

    @Override
    public void exitBinaryGreaterThanEqualsExpression(VyassParser.BinaryGreaterThanEqualsExpressionContext context) {
        validateExpressionCompatibility(GREATER_THAN_OR_EQUALS_OPERATOR, INT_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterLogicalAndExpression(VyassParser.LogicalAndExpressionContext context) {
        intermediateCodeBuilder.append(AND_OPERATOR + " ");
    }

    @Override
    public void exitLogicalAndExpression(VyassParser.LogicalAndExpressionContext context) {
        validateExpressionCompatibility(AND_OPERATOR, BOOL_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterLogicalOrExpression(VyassParser.LogicalOrExpressionContext context) {
        intermediateCodeBuilder.append(OR_OPERATOR + " ");
    }

    @Override
    public void exitLogicalOrExpression(VyassParser.LogicalOrExpressionContext context) {
        validateExpressionCompatibility(OR_OPERATOR, BOOL_TYPE, context);
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterIntegerLiteralExpression(VyassParser.IntegerLiteralExpressionContext context) {
        intermediateCodeBuilder.append(context.INTEGER_LITERAL().getText()).append(" ");
        expressionStack.push(INT_TYPE);
    }

    @Override
    public void enterBooleanLiteralExpression(VyassParser.BooleanLiteralExpressionContext context) {
        intermediateCodeBuilder.append(context.BOOLEAN_LITERAL().getText()).append(" ");
        expressionStack.push(BOOL_TYPE);
    }

    @Override
    public void enterStringLiteralExpression(VyassParser.StringLiteralExpressionContext context) {
        intermediateCodeBuilder.append(context.STRING_LITERAL().getText()).append(" ");
        expressionStack.push(STR_TYPE);
    }

    @Override
    public void enterIdentifierExpression(VyassParser.IdentifierExpressionContext context) {
        if (variableMap.containsKey(context.IDENTIFIER().getText())) {
            intermediateCodeBuilder.append(context.IDENTIFIER().getText()).append(" ");
            expressionStack.push(variableMap.get(context.IDENTIFIER().getText()));
        } else {
            throw new RuntimeException(getPositionForErrorFunc(context) + "The Variable " + context.IDENTIFIER().getText() + " isn't defined");
        }
    }

    @Override
    public void enterTernaryCondnExpression(VyassParser.TernaryCondnExpressionContext context) {
        intermediateCodeBuilder.append(TERNARY_CMD + " ");
    }

    @Override
    public void exitTernaryCondnExpression(VyassParser.TernaryCondnExpressionContext context) {
        String type1 = expressionStack.pop();
        String type2 = expressionStack.pop();
        if (!type1.equals(type2)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Expression data type for true and false cases for the ternary operator dont match.");
        }
        expressionStack.push(type2);
    }

    @Override
    public void enterTernaryTrue(VyassParser.TernaryTrueContext context) {
        if (!expressionStack.pop().equals(BOOL_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "ternary operator condition expression is not a expression of type bool");
        }
        intermediateCodeBuilder.append(TRUE_CONST + " " + START_BLOCK + " ");
    }

    @Override
    public void exitTernaryTrue(VyassParser.TernaryTrueContext context) {
        intermediateCodeBuilder.append(END_BLOCK + " ");
    }

    @Override
    public void enterTernaryFalse(VyassParser.TernaryFalseContext context) {
        intermediateCodeBuilder.append(FALSE_CONST + " " + START_BLOCK + " ");
    }

    @Override
    public void exitTernaryFalse(VyassParser.TernaryFalseContext context) {
        intermediateCodeBuilder.append(END_BLOCK + " ");
    }

    @Override
    public void enterFunctionCall(VyassParser.FunctionCallContext context) {
        if (!functionMap.containsKey(context.IDENTIFIER().getText())) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Function " + context.IDENTIFIER().getText() + " isn't defined.");
        }
        intermediateCodeBuilder.append(LOAD_CMD + " ").append(context.IDENTIFIER().getText()).append(" ");
        functionCallPairStack.push(new Pair<>(context.IDENTIFIER().getText(), 1));
    }

    @Override
    public void exitFunctionCall(VyassParser.FunctionCallContext context) {
        Pair<String, Integer> currFunction = functionCallPairStack.pop();
        if (functionMap.get(currFunction.key()).size() != currFunction.value()) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Not sufficient parameters mentioned in the function " + currFunction.key());
        }
        expressionStack.push(functionMap.get(currFunction.key()).get(0));
    }

    @Override
    public void enterFunctionValue(VyassParser.FunctionValueContext context) {
    }

    @Override
    public void exitFunctionValue(VyassParser.FunctionValueContext context) {
        Pair<String, Integer> currentFunction = functionCallPairStack.pop();
        if (functionMap.get(currentFunction.key()).size() <= currentFunction.value()) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "The no. of values passed in the function as parameters " + currentFunction.key() + " are more than the defined number of parameters");
        }
        if (!functionMap.get(currentFunction.key()).get(currentFunction.value()).equals(lastExpressionResultType)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "The type of passed value in the argument doesn't match the defined value in the function " + currentFunction.key());
        }
        lastExpressionResultType = null;
        functionCallPairStack.push(new Pair<>(currentFunction.key(), currentFunction.value() + 1));
    }

    //statement listeners that are in one line
    @Override
    public void enterPrintStatement(VyassParser.PrintStatementContext context) {
        intermediateCodeBuilder.append(DISPLAY_CMD + " ");
    }

    @Override
    public void exitPrintStatement(VyassParser.PrintStatementContext context) {
        intermediateCodeBuilder.append("\n");
        lastExpressionResultType = null;
    }

    @Override
    public void enterReturnStatement(VyassParser.ReturnStatementContext context) {
        intermediateCodeBuilder.append(RETURN_CMD + " ");
    }

    @Override
    public void exitReturnStatement(VyassParser.ReturnStatementContext context) {
        intermediateCodeBuilder.append("\n");
        if (isInMainBlock) {
            if (context.expression_expr() != null) {
                throw new RuntimeException(getPositionForErrorFunc(context) + "The return statement for main block has to be empty");
            }
        } else {
            if (context.expression_expr() == null) {
                throw new RuntimeException(getPositionForErrorFunc(context) + "missing return value");
            }
            if (!functionMap.get(currentFunctionName).get(0).equals(lastExpressionResultType)) {
                throw new RuntimeException(getPositionForErrorFunc(context) + "the function return type doesn't match the type of returned value.");
            }
        }
        lastExpressionResultType = null;
    }

    @Override
    public void enterBreakStatement(VyassParser.BreakStatementContext context) {
        intermediateCodeBuilder.append(BREAK_CMD + "\n");
    }

    @Override
    public void enterContinueStatement(VyassParser.ContinueStatementContext context) {
        intermediateCodeBuilder.append(CONTINUE_CMD + "\n");
    }

    //If-else listeners
    @Override
    public void enterConditionalBlock(VyassParser.ConditionalBlockContext context) {
        intermediateCodeBuilder.append(IF_CMD + " ");
    }

    @Override
    public void exitConditionalBlock(VyassParser.ConditionalBlockContext context) {
        intermediateCodeBuilder.append(END_BLOCK + "\n");
    }

    @Override
    public void exitIfCondition(VyassParser.IfConditionContext context) {
        if (!lastExpressionResultType.equals(BOOL_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Statement for if condition is not booelean");
        }
        lastExpressionResultType = null;
        intermediateCodeBuilder.append("\n" + TRUE_CONST + " " + START_BLOCK + "\n");
    }

    @Override
    public void enterElseBlock(VyassParser.ElseBlockContext context) {
        intermediateCodeBuilder.append(END_BLOCK + "\n" + FALSE_CONST + " " + START_BLOCK + "\n");
    }

    @Override
    public void enterElifList(VyassParser.ElifListContext context) {
        if (context.ELIF() != null && context.elseBlock() == null) {
            intermediateCodeBuilder.append(END_BLOCK + "\n" + FALSE_CONST + " " + START_BLOCK + "\n" + IF_CMD + " ");
        }
    }

    @Override
    public void exitElifList(VyassParser.ElifListContext context) {
        if (context.ELIF() != null) {
            intermediateCodeBuilder.append(END_BLOCK + "\n");
        }
    }

    //listeners - while iterative loop
    @Override
    public void enterWhileTraditionalBlock(VyassParser.WhileTraditionalBlockContext context) {
        intermediateCodeBuilder.append(LOOP_CMD + " ");
    }

    @Override
    public void exitWhileTraditionalBlock(VyassParser.WhileTraditionalBlockContext context) {
        intermediateCodeBuilder.append(END_BLOCK + "\n");
    }

    @Override
    public void exitWhileCondition(VyassParser.WhileConditionContext context) {
        if (!lastExpressionResultType.equals(BOOL_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "While condition statement is not a boolean expression");
        }
        lastExpressionResultType = null;
        intermediateCodeBuilder.append("\n" + START_BLOCK + "\n");
    }

    //listeners - For Loop
    @Override
    public void enterForTraditionalBlock(VyassParser.ForTraditionalBlockContext context) {
        temporaryStringBuilder = intermediateCodeBuilder;
        intermediateCodeBuilder = new StringBuilder();
    }

    @Override
    public void exitForTraditionalBlock(VyassParser.ForTraditionalBlockContext context) {
        intermediateCodeBuilder.append(forLoopUpdateStack.pop());
        intermediateCodeBuilder.append(END_BLOCK + "\n");
    }

    @Override
    public void exitForInit(VyassParser.ForInitContext context) {
        temporaryStringBuilder.append(intermediateCodeBuilder);
        intermediateCodeBuilder = temporaryStringBuilder;
        temporaryStringBuilder = null;
        intermediateCodeBuilder.append(LOOP_CMD + " ");
    }

    @Override
    public void exitForAssign(VyassParser.ForAssignContext context) {
        intermediateCodeBuilder.append("\n");
    }

    @Override
    public void exitForCondition(VyassParser.ForConditionContext context) {
        if (!lastExpressionResultType.equals(BOOL_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "for-loop condition expression is not of type bool");
        }
        lastExpressionResultType = null;
        intermediateCodeBuilder.append("\n" + START_BLOCK + "\n");
    }

    @Override
    public void enterForUpdate(VyassParser.ForUpdateContext context) {
        temporaryStringBuilder = intermediateCodeBuilder;
        intermediateCodeBuilder = new StringBuilder();
    }

    @Override
    public void exitForUpdate(VyassParser.ForUpdateContext context) {
        forLoopUpdateStack.push(intermediateCodeBuilder.toString());
        intermediateCodeBuilder = temporaryStringBuilder;
        temporaryStringBuilder = null;
    }

    //For in range loop listeners
    @Override
    public void enterForInRangeBlock(VyassParser.ForInRangeBlockContext context) {
        if (!variableMap.containsKey(context.IDENTIFIER().getText())) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Variable " + context.IDENTIFIER().getText() + " is not defined");
        }
        if (!variableMap.get(context.IDENTIFIER().getText()).equals(INT_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "Variable " + context.IDENTIFIER().getText() + " should be of type " + INT_TYPE);
        }
        intermediateCodeBuilder.append(ASSIGN_CMD + " ").append(context.IDENTIFIER().getText()).append(" ");
        temporaryStringBuilder = new StringBuilder(context.IDENTIFIER().getText());
    }

    @Override
    public void exitForInRangeBlock(VyassParser.ForInRangeBlockContext context) {
        intermediateCodeBuilder.append(forLoopUpdateStack.pop());
        intermediateCodeBuilder.append(END_BLOCK + "\n");
    }

    @Override
    public void exitForInRangeLowerLimit(VyassParser.ForInRangeLowerLimitContext context) {
        if (!lastExpressionResultType.equals(INT_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "for-in-range condition's lower limit is not of type int");
        }
        lastExpressionResultType = null;
        intermediateCodeBuilder.append("\n");
    }

    @Override
    public void enterForInRangeUpperLimit(VyassParser.ForInRangeUpperLimitContext context) {
        intermediateCodeBuilder.append(LOOP_CMD + " " + LESS_THAN_OPERATOR + " ").append(temporaryStringBuilder).append(" , ");
    }

    @Override
    public void exitForInRangeUpperLimit(VyassParser.ForInRangeUpperLimitContext context) {
        if (!lastExpressionResultType.equals(INT_TYPE)) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "for-in-range condition's upper limit is not of type int");
        }
        lastExpressionResultType = null;
        intermediateCodeBuilder.append("\n" + START_BLOCK + "\n");
        forLoopUpdateStack.push(ASSIGN_CMD + " " + temporaryStringBuilder + " " + ADD_CMD + " " + temporaryStringBuilder + " , " + 1 + "\n");
        temporaryStringBuilder = null;
    }

    //Function declaration listeners
    @Override
    public void enterFunctionDeclarations(VyassParser.FunctionDeclarationsContext context) {
        if (functionMap.containsKey(context.IDENTIFIER().getText())) {
            throw new RuntimeException(getPositionForErrorFunc(context) + "function " + context.IDENTIFIER().getText() + " is defined previously");
        }
        List<String> functionSign = new ArrayList<>();
        functionSign.add(context.dType().getText());
        functionMap.put(context.IDENTIFIER().getText(), functionSign);
        intermediateCodeBuilder.append(METH_CMD + " ").append(context.IDENTIFIER().getText()).append(" ");
        temporaryVariableMap = variableMap;
        variableMap = new HashMap<>();
        currentFunctionName = context.IDENTIFIER().getText();
    }

    @Override
    public void exitFunctionDeclarations(VyassParser.FunctionDeclarationsContext context) {
        variableMap = temporaryVariableMap;
        currentFunctionName = null;
    }

    @Override
    public void enterMultiParameter(VyassParser.MultiParameterContext context) {
        intermediateCodeBuilder.append(", ");
    }

    @Override
    public void enterParameter(VyassParser.ParameterContext context) {
        addVariableToContext(context.IDENTIFIER().getText(), context.dType().getText(), context);
        functionMap.get(currentFunctionName).add(context.dType().getText());
        intermediateCodeBuilder.append(context.IDENTIFIER().getText()).append(" ");
    }

    @Override
    public void enterFunctionBlock(VyassParser.FunctionBlockContext context) {
        intermediateCodeBuilder.append("\n" + START_BLOCK + "\n");
    }

    @Override
    public void exitFunctionBlock(VyassParser.FunctionBlockContext context) {
        intermediateCodeBuilder.append(END_BLOCK + "\n");
    }



}

