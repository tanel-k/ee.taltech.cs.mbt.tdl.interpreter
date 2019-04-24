grammar LExpr;

s : e ;

/* To get more precise listener events, ANTLR lets us label the outermost alternatives of any rule using the # operator. */
e   : e MULT e  # Mult
    | e ADD e   # Add
    | INT       # Int
    ;
/* We don't need the op token label anymore */

MULT: '*' ;
ADD : '+' ;
INT : [0-9]+ ;
WS : [ \t\n]+ -> skip ;
