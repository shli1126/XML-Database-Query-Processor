grammar XPath;

@header {
package main.antlr;
}

ap  : doc '/' rp
    | doc '//' rp
    ;

doc : 'doc' '(' '"' STRING '"' ')'
    | 'document' '(' '"' STRING '"' ')'
    ;

rp  : TAGNAME
    | '*'
    | '.'
    | '..'
    | 'text' | 'text()'
    | '@' ATTRNAME
    | '(' rp ')'
    | rp '/' rp
    | rp '//' rp
    | rp '[' f ']'
    | rp ',' rp
    ;

f   : rp
    | rp EQ rp
    | rp IS rp
    | rp '=' STRING
    | '(' f ')'
    | f 'and' f
    | f 'or' f
    | 'not' f
    ;

TAGNAME  : [a-zA-Z_][a-zA-Z0-9_-]* ;

ATTRNAME : [a-zA-Z_][a-zA-Z0-9_-]* ;

STRING   : '"' (~["\r\n])*? '"'
         | '\'' (~['\r\n])*? '\''
         ;

// value-eq
EQ       : '=' | 'eq' ;

// id-eq
IS       : '==' | 'is' ;

// whitespace
WS       : [ \t\r\n]+ -> skip ;