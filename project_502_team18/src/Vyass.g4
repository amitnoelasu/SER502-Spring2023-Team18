grammar Vyass;

parse
  :  (x=.
          {System.out.printf("text: %-7s  type: %s \n",
           $x.text, tokenNames[$x.type]);}
     )*
     EOF
  ;

Space : [ \r\t\n\u000C] -> skip;

IF : 'if';
ELIF : 'elif';
ELSE : 'else';
RETURN : 'return';
BREAK : 'break';
CONTINUE: 'continue';
PRINT : 'print';
BEGIN : 'begin';
END : 'end';
WHILE : 'while';
FOR : 'for';
IN : 'in';
RANGE : 'range';
MAIN: 'main';

ASSIGNMENT_BINARY : '=';
ADDITION_BINARY : '+';
SUBSTRACTION_BINARY : '-';
MULTIPLICATION_BINARY : '*';
DIVISION_BINARY : '/';
MODULUS_BINARY : '%';
TERNARY : '?';
NOT_BINARY : '!';
LESSTHAN_BINARY  : '<';
GREATERTHAN_BINARY : '>';
LESSTHANEQUALS_BINARY : '<=';
GREATERTHANEQUALS_BINARY : '>=';
EQUALS_BINARY : '==';
NOTEQUALS_BINARY : '!=';
AND_BINARY : '&';
OR_BINARY : '|';
ARITHMETIC_OP : ADDITION_BINARY | SUBSTRACTION_BINARY | MULTIPLICATION_BINARY | DIVISION_BINARY | MODULUS_BINARY;
COMPARISION_OP : GREATERTHANEQUALS_BINARY | LESSTHANEQUALS_BINARY | LESSTHAN_BINARY | GREATERTHAN_BINARY | EQUALS_BINARY | NOTEQUALS_BINARY;

INTEGER_DTYPE : 'int';
BOOL_DTYPE : 'bool';
STR_DTYPE : 'string';

COMMA_SEP : ',';
SEMICOLON_SEP : ';';
COLON_SEP : ':' ;
START_BLOCK : '{';
END_BLOCK : '}' ;
LEFT_PAREN : '(' ;
RIGHT_PAREN : ')';

STRING_LITERAL : ["] (~["\r\n])* ["];
BOOLEAN_LITERAL: 'true' | 'false';
INTEGER_LITERAL: [1-9] [0-9]* | [0];
IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]*;

literalConst : INTEGER_LITERAL | BOOLEAN_LITERAL | STRING_LITERAL;
dType : INTEGER_DTYPE | BOOL_DTYPE | STR_DTYPE;

program : BEGIN functionDeclarations* mainFunctionBlock? END;
mainFunctionBlock : MAIN exprBlock ;

exprBlock: START_BLOCK variableDeclarations* statements* END_BLOCK;

variableDeclarations : dType variableList SEMICOLON_SEP;
variableList : variableInitialization variableListMulti?;
variableListMulti : COMMA_SEP variableInitialization variableListMulti?;
variableInitialization : IDENTIFIER ASSIGNMENT_BINARY literalConst | IDENTIFIER;

functionDeclarations : dType IDENTIFIER LEFT_PAREN parameters? RIGHT_PAREN functionBlock;
parameters : parameter (multiParameter)*;
multiParameter : COMMA_SEP parameter;
parameter : dType IDENTIFIER;
functionBlock : exprBlock;

statements : assignmentStatement
| printStatement
| returnStatement
| breakStatement
| continueStatement
| exprBlock
| conditionalBlock
| iterativeBlock
;

assignmentStatement : assignmentList SEMICOLON_SEP;
assignmentList : IDENTIFIER ASSIGNMENT_BINARY (assignmentList | express);

printStatement : PRINT LEFT_PAREN express RIGHT_PAREN SEMICOLON_SEP;
returnStatement : RETURN SEMICOLON_SEP | RETURN express SEMICOLON_SEP;
continueStatement : CONTINUE SEMICOLON_SEP;
breakStatement : BREAK SEMICOLON_SEP;


conditionalBlock : IF LEFT_PAREN ifCondition RIGHT_PAREN exprBlock elifList;
elifList : ELIF LEFT_PAREN ifCondition RIGHT_PAREN exprBlock elifList | elseBlock?;
elseBlock : ELSE exprBlock;
ifCondition : express;

iterativeBlock : whileTraditionalBlock | forBlock;

whileTraditionalBlock : WHILE LEFT_PAREN whileCondition RIGHT_PAREN exprBlock;
whileCondition : express;

forBlock : FOR (forTraditionalBlock | forInRangeBlock);
forTraditionalBlock : LEFT_PAREN forInit? SEMICOLON_SEP forCondition SEMICOLON_SEP forUpdate? RIGHT_PAREN exprBlock;
forInRangeBlock : IDENTIFIER IN RANGE LEFT_PAREN forInRangeLowerLimit COMMA_SEP forInRangeUpperLimit RIGHT_PAREN exprBlock;

forInit : forInitStatement (COMMA_SEP forInitStatement)*;
forInitStatement : forAssign;
forCondition : express;
forUpdate : forUpdateStatement (COMMA_SEP forUpdateStatement)*;
forUpdateStatement : forAssign;
forAssign : assignmentList;
forInRangeLowerLimit : express;
forInRangeUpperLimit : express;

functionCall : IDENTIFIER LEFT_PAREN values? RIGHT_PAREN;
values : functionValue (COMMA_SEP functionValue)*;
functionValue : express;

rExpress : express;
express:
LEFT_PAREN express RIGHT_PAREN      #parametersExpression
| '-' express       #unaryNegationExpression
| '!' express       #unaryNotExpression
| express MULTIPLICATION_BINARY rExpress        #binaryMultiplicationExpression
| express DIVISION_BINARY rExpress      #binaryDivisionExpression
| express MODULUS_BINARY rExpress       #binaryModulusExpression
| express ADDITION_BINARY rExpress      #binaryAdditionExpression
| express SUBSTRACTION_BINARY rExpress      #binarySubstractionExpression
| express GREATERTHANEQUALS_BINARY rExpress     #binaryGreaterThanEqualsExpression
| express LESSTHANEQUALS_BINARY rExpress        #binaryLessThanEqualsExpression
| express GREATERTHAN_BINARY rExpress       #binaryGreaterThanExpression
| express LESSTHAN_BINARY rExpress      #binaryLessThanExpression
| express EQUALS_BINARY rExpress        #binaryEqualsExpression
| express NOTEQUALS_BINARY rExpress     #binaryNotEqualsExpression
| express '&&' rExpress     #logicalAndExpression
| express '||' rExpress     #logicalOrExpression
| express '?' ternaryTrue ':' ternaryFalse    #ternaryCondnExpression
| INTEGER_LITERAL       #integerLiteralExpression
| BOOLEAN_LITERAL       #booleanLiteralExpression
| STRING_LITERAL        #stringLiteralExpression
| IDENTIFIER        #identifierExpression
| functionCall      #functionCallExpression
;
ternaryTrue : express;
ternaryFalse : express;
