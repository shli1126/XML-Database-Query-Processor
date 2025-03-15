grammar XPath;

@header {
package main.antlr;
}

xq
    : var
    | STRING
    | ap
    | '(' xq ')'
    | xq ',' xq
    | xq '/' rp
    | xq '//' rp
    | '<' tagName '>' '{' xq '}' '</' tagName '>'
    | forClause letClause? whereClause? returnClause
    | letClause xq
    ;

forClause
    : 'for' var 'in' xq (',' var 'in' xq)*
    ;

letClause
    : 'let' var ':=' xq (',' var ':=' xq)*
    ;

whereClause
    : 'where' cond
    ;

returnClause
    : 'return' xq
    ;

cond
    : xq EQ xq
    | xq IS xq
    | 'empty' '(' xq ')'
    | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond
    | '(' cond ')'
    | cond 'and' cond
    | cond 'or' cond
    | 'not' cond
    | rp EQ STRING
    ;

ap
    : doc '/' rp
    | doc '//' rp
    ;

doc
    : 'doc' '(' STRING ')'
    | 'document' '(' STRING ')'
    ;

rp
    : tagName
    | '*'
    | '.'
    | '..'
    | 'text()'
    | '@' attrName
    | '(' rp ')'
    | rp '/' rp
    | rp '//' rp
    | rp '[' f ']'
    | rp ',' rp
    ;

f
    : rp
    | rp EQ rp
    | rp IS rp
    | rp EQ STRING
    | '(' f ')'
    | f 'and' f
    | f 'or' f
    | 'not' f
    ;

EQ
    : '=' | 'eq' ;

// id-eq
IS
    : '==' | 'is' ;


TAGNAME
    : [a-zA-Z_][a-zA-Z0-9_-]*;

ATTRNAME
    : [a-zA-Z_][a-zA-Z0-9_-]*;

STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

VAR : '$' TAGNAME ;

var : VAR ;

tagName
    : TAGNAME
    ;

attrName
    : ATTRNAME
    ;

// value-eq

// whitespace
WS
    : [ \t\r\n]+ -> skip ;