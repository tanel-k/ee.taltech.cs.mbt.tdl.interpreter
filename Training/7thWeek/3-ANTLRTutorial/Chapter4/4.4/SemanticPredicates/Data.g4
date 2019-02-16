grammar Data;

file    :   group+ ;
group   :   INT sequence[$INT.int] ; // $INT <- last matched INT

sequence[int n] // parameterized
locals [int i = 1; ]
    : ( {$i<=$n}? INT {$i++} )* // match n integers
    ;

INT     : [0-9]+ ;
WS      : [ \t\n\r]+ -> skip ; // get rid of whitespace
