grammar TDLExpressionLanguage;

sample  : '(' sample ')'
        | STRING
        ;

STRING : [a-zA-Z]+ ;
WS : [ \t\n\r] -> skip ;

