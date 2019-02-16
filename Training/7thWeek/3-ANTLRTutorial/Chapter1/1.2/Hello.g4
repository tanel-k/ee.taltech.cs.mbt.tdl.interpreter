grammar Hello;            // define a grammar called Hello
r : 'hello' ID ;          // match keyword hello followed by identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines, \r
