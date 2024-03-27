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
    | 'if' '(' condition ')' statement ('else' statement)?  # conditionStat
    | 'while' '(' condition ')' statement      # loopStat
    ;

/** Types */
type: 'int' | 'float' | 'string' | 'bool';
variable: ID;

/** Expressions */
expression: variable                             # var
    | INT                                 # int
    | FLOAT                                     # float
    | STRING                                    # string
    | BOOL                                      # bool
    | '-' expression                            # unaryMinus
    | expression op=('+' | '-' | '*' | '/') expression   # binaryArithmetic
    | expression op='%' expression                 # modulo
    | expression op='.' expression                 # concatenation
    | expression op=('<' | '<=' | '>' | '>=') expression   # relational
    | expression op=('==' | '!=') expression       # comparison
    | expression op=('&&' | '||') expression       # logical
    | '!' expression                            # logicalNot
    | variable op='=' expression                # assignment
    | '(' expression ')'                         # parentheses
    ;

/** Conditions */
condition: expression # help;

/** Literals */
ID: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
BOOL: 'true' | 'false';
WS : [ \t\r\n]+ -> skip ;   // toss out whitespace