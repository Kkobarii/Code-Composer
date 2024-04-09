grammar Code;

/** The start rule; begin parsing here. */
program: (statement)+;

/** An expression statement. */
statement
    : ';'                                                   # emptyStat
    | type variable (',' variable)* ';'                     # varDeclStat
    | expression ';'                                        # expressionStat
    | 'read' variable (',' variable)* ';'                   # readStat
    | 'write' expression (',' expression)* ';'              # writeStat
    | '{' statement* '}'                                    # blockStat
    | 'if' '(' condition ')' statement ('else' statement)?  # ifStat
    | 'while' '(' condition ')' statement                   # whileStat
    | 'do' statement 'while' '(' condition ')' ';'          # doWhileStat
    ;

/** Types */
type: 'int' | 'float' | 'string' | 'bool';
variable: ID;

/** Expressions */
expression
    : literal                                                       # literalExpr
    | variable                                                      # variableExpr
    | '-' expression                                                # unaryMinusExpr
    | left=expression op=('+' | '-' | '*' | '/') right=expression   # binaryArithmeticExpr
    | left=expression op='%' right=expression                       # moduloExpr
    | left=expression op='.' right=expression                       # concatenationExpr
    | left=expression op=('<' | '<=' | '>' | '>=') right=expression # relationalExpr
    | left=expression op=('==' | '!=') right=expression             # comparisonExpr
    | left=expression op=('&&' | '||') right=expression             # logicalExpr
    | '!' expression                                                # logicalNotExpr
    | cond=expression '?' ifTrue=expression ':' ifFalse=expression  # ternaryExpr
    | <assoc=right> variable op='=' expression                      # assignmentExpr
    | '(' expression ')'                                            # parenthesesExpr
    ;

/** Conditions */
condition: expression # cond;

/** Literals */
literal: INT | FLOAT | STRING | BOOL;

INT: NUMBER+;
FLOAT: NUMBER+'.'NUMBER+;
STRING: '"' ~'"'* '"';
BOOL: 'true' | 'false';

ID: LETTER (LETTER | NUMBER)*;

WS : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip;

NUMBER: [0-9];
LETTER: [a-zA-Z];
