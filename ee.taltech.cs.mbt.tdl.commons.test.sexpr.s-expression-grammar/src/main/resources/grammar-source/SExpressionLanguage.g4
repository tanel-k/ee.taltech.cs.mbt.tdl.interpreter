grammar SExpressionLanguage;

sExpr : sequence ;  // Root production.

sequence : LPAREN item (SEQ_SEP item)* RPAREN   #NonEmptySequence
         | LPAREN RPAREN                        #EmptySequence
         ;

item    : sequence  #SequenceItem
        | string    #StringItem
        ;

string  : DELIMITED_STRING      #DelimitedString
        | NON_DELIMITED_STRING  #NonDelimitedString
        ;

fragment BLANK : [ \t\r\n] ;

DELIMITED_STRING        : '"' (ALPHANUMERIC | SPECIAL | BLANK | ESCAPED_RESERVED_TOK)* '"' ;
NON_DELIMITED_STRING    : (ALPHANUMERIC | SPECIAL | ESCAPED_RESERVED_TOK)+ ;
SEQ_SEP                 : '.' ;
LPAREN                  : '(' ;
RPAREN                  : ')' ;
ALPHANUMERIC            : [A-Za-z0-9] ;
SPECIAL                 : [#~!@$%^&*_\-?`=<>|{}[\]/:;,+] ;
ESCAPED_RESERVED_TOK    : '\\.' | '\\(' | '\\)' | '\\"' ;

WS : BLANK+ -> skip ;
