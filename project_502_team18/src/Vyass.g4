
grammar Vyass;

Space : [ \t\r\n\u000C] -> skip;

IF : 'if';
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


ASSIGNMENT_BINARY : '=';
ADDITION_BINARY : '+';
SUBTRACTION_BINARY : '-';
UN_OP : ADDITION_BINARY | SUBTRACTION_BINARY;
MULTIPLICATION_BINARY : '*';
DIVISION_BINARY : '/';
MODULUS_BINARY : '%';
TERNARY : '?';
NOT_BINARY : '!';
LESSTHAN_BINARY : '<';
GREATERTHAN_BINARY : '>';
LESSTHANEQUALS_BINARY : '=<';
GREATERTHANEQUALS_BINARY : '=>';
EQUALS_BINARY : '==';
NOTEQUALS_BINARY : '!=';
AND_BINARY : '&';
OR_BINARY : '|';
ARITHMETIC_OP : ADDITION_BINARY | SUBTRACTION_BINARY | MULTIPLICATION_BINARY | DIVISION_BINARY | MODULUS_BINARY;
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

LITERAL : INTEGER_LITERAL | BOOLEAN_LITERAL | STRING_LITERAL;
DTYPE : INTEGER_DTYPE | BOOL_DTYPE | STR_DTYPE;



epsilon : ;
program : declaration_list function_list;
declaration_list : declaration | declaration_list declaration | epsilon;
declaration : DTYPE id_list SEMICOLON_SEP;
id_list : IDENTIFIER | id_list COMMA_SEP IDENTIFIER;
function_list : function | function_list function | epsilon;
function : DTYPE IDENTIFIER LEFT_PAREN parameters RIGHT_PAREN compound_statement;


parameter : DTYPE IDENTIFIER;
parameters_list : parameter | parameters_list COMMA_SEP parameter;
parameters : epsilon | parameters_list;


expression : IDENTIFIER ASSIGNMENT_BINARY expression | boolean_expression | epsilon;
boolean_expression : boolean_expression OR_BINARY and_expression | and_expression |
epsilon;


compound_statement : START_BLOCK declaration_list statement END_BLOCK;


else_if_list : else_if_list ELSE IF LEFT_PAREN boolean_expression RIGHT_PAREN
START_BLOCK statement END_BLOCK | epsilon;

if_else_selection_stmt : IF LEFT_PAREN boolean_expression RIGHT_PAREN
START_BLOCK statement END_BLOCK else_if_list | IF LEFT_PAREN boolean_expression
RIGHT_PAREN START_BLOCK statement END_BLOCK else_if_list ELSE START_BLOCK
statement END_BLOCK;
statement : expression_stmt | compound_statement | if_else_selection_stmt | loop_stmt |
return_stmt | display_stmt | epsilon;
expression_stmt : expression SEMICOLON_SEP | SEMICOLON_SEP;
display_stmt : PRINT LEFT_PAREN expression RIGHT_PAREN | epsilon;
return_stmt : RETURN | RETURN LEFT_PAREN expression RIGHT_PAREN;


unary_expression : NOT_BINARY unary_expression | comparision_expression | const | method_call ;
and_expression : and_expression AND_BINARY unary_expression | unary_expression;



comparision_expression : arithmetic_expression COMPARISION_OP arithmetic_expression |
arithmetic_expression;
arithmetic_expression : epsilon | arithmetic_expression ARITHMETIC_OP
arithmetic_expression;
const : INTEGER_LITERAL | STRING_LITERAL | BOOLEAN_LITERAL;
method_call : IDENTIFIER LEFT_PAREN argument_list RIGHT_PAREN;
argument_list : argument_list COMMA_SEP expression | expression | epsilon;
loop_expression : boolean_expression | boolean_expression CONTINUE | boolean_expression BREAK;
loop_stmt : WHILE LEFT_PAREN loop_expression RIGHT_PAREN START_BLOCK statement
END_BLOCK | FOR loop_number START_BLOCK statement END_BLOCK;
loop_number : LEFT_PAREN IDENTIFIER ASSIGNMENT_BINARY boolean_expression SEMICOLON_SEP
IDENTIFIER COMPARISION_OP boolean_expression SEMICOLON_SEP expression RIGHT_PAREN |
IDENTIFIER IN RANGE LEFT_PAREN boolean_expression COMMA_SEP boolean_expression RIGHT_PAREN;




