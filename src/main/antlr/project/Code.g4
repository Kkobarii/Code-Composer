grammar Code;

/** The start rule; begin parsing here. */
program: (statement)+;

/** An expression statement. */
statement: ';'                                  # emptyStat
    | type variable (',' variable)* ';'         # varDeclStat
    | expression ';'                            # expressionStat
    | 'read' variable (',' variable)* ';'       # readStat
    | 'write' expression (',' expression)* ';'  # writeStat
    | '{' statement* '}'                        # blockStat
    | 'if' '(' condition ')' statement ('else' statement)?  # ifStat
    | 'while' '(' condition ')' statement      # whileStat
    | 'do' statement 'while' '(' condition ')' ';'  # doWhileStat
    ;

/** Types */
type: 'int' | 'float' | 'string' | 'bool';
variable: ID;

/** Expressions */
expression: variable                             # varExpr
    | INT                                 # intExpr
    | FLOAT                                     # floatExpr
    | STRING                                    # stringExpr
    | BOOL                                      # boolExpr
    | '-' expression                            # unaryMinusExpr
    | left=expression op=('+' | '-' | '*' | '/') right=expression   # binaryArithmeticExpr
    | left=expression op='%' right=expression                 # moduloExpr
    | left=expression op='.' right=expression                 # concatenationExpr
    | left=expression op=('<' | '<=' | '>' | '>=') right=expression   # relationalExpr
    | left=expression op=('==' | '!=') right=expression       # comparisonExpr
    | left=expression op=('&&' | '||') right=expression       # logicalExpr
    | '!' expression                            # logicalNotExpr
    | <assoc=right> variable op='=' expression    # assignmentExpr
    | '(' expression ')'                         # parenthesesExpr
    ;

/** Conditions */
condition: expression # help;

/** Literals */
ID: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
BOOL: 'true' | 'false';
WS : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip;
