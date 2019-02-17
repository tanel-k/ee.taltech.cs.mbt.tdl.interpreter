grammar JSON;

json            :       object
                |       array
                ;

object          :       LCURL nameValue (SEQ_SEP nameValue)* RCURL
                |       LCURL RCURL // empty object
                ;

nameValue       :       STRING NAME_VALUE_SEP value ;

array           :       LSQUARE value (SEQ_SEP value)* RSQUARE
                |       LSQUARE RSQUARE
                ;

value           :       STRING
                |       NUMBER
                |       object
                |       array
                |       BOOL_TRUE
                |       BOOL_FALSE
                |       VALUE_NULL
                ;

LPAREN          :       '(' ;
RPAREN          :       ')' ;
LCURL           :       '{' ;
RCURL           :       '}' ;
LSQUARE         :       '[' ;
RSQUARE         :       ']' ;
NAME_VALUE_SEP  :       ':';
SEQ_SEP         :       ',' ;

BOOL_TRUE       :       'true' ;
BOOL_FALSE      :       'false' ;
VALUE_NULL      :       'null' ;
NUMBER          :       (NEG|POS)? INT '.' INT EXP?
                |       (NEG|POS)? INT EXP
                |       (NEG|POS)? INT
                ;
STRING          :        '"' (ESC | ~["\\])* '"';


fragment ESC    :       '\\' (["\\bfnrt] | UNICODE) ;
fragment UNICODE:       'u' HEX HEX HEX HEX ;
fragment HEX    :       [0-9a-fA-F] ;
fragment NEG    :       '-';
fragment POS    :       '+' ;
fragment INT    :       '0' | [1-9] [0-9]* ; // no leading zeroes
fragment EXP    :       [Ee] [+\-]? INT ; // \- since - means "range" inside [ ]

WS              :  [ \r\n\t]+ -> skip ;
