grammar TDLExpressionLanguage;

expression  : LEFT_PAREN expression RIGHT_PAREN  # groupedExpression
            | quantifiedTrapsetExpression  # groundTermExpression
            | LOP_NEGATION expression  # negatedExpression
            | expression LOP_CONJUNCTION expression  # conjunctiveExpression
            | expression LOP_DISJUNCTION expression  # disjunctiveExpression
            | expression LOP_IMPLICATION expression  # implicativeExpression
            | expression LOP_EQUIVALENCE expression  # equivalenceExpression
            | expression LOP_LEADS_TO expression  # leadsToExpression
            | expression LOP_LEADS_TO LEFT_BRACKET relationOverNaturals RIGHT_BRACKET expression  # timeBoundedLeadsToExpression
            | LOP_REPETITION_COUNT expression relationOverNaturals  # conditionalRepetitionExpression
            ;

quantifiedTrapsetExpression : LOP_UNIVERSAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN # universalTrapsetExpression
                            | LOP_EXISTENTIAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN # existentialTrapsetExpression
                            ;

relationOverNaturals : REL_LESS_THAN NATURAL_NUMBER
                     | REL_GREATER_THAN NATURAL_NUMBER
                     | REL_LESS_THAN_OR_EQ NATURAL_NUMBER
                     | REL_GREATER_THAN_OR_EQ NATURAL_NUMBER
                     | REL_EQUAL NATURAL_NUMBER
                     ;

trapsetExpression : LEFT_PAREN trapsetExpression RIGHT_PAREN # groupedTrapsetExpression
                  | TOP_ABSOLUTE_COMPLEMENT trapsetExpression # absoluteTrapsetComplementExpression
                  | trapsetExpression TOP_RELATIVE_COMPLEMENT trapsetExpression # relativeTrapsetComplementExpression
                  | trapsetExpression TOP_LINKED_PAIR trapsetExpression # linkedTrapsetPairExpression
                  ;

// Grouping tokens:
LEFT_BRACKET    : '[' ;
RIGHT_BRACKET   : ']' ;
LEFT_PAREN      : '(' ;
RIGHT_PAREN     : ')' ;

// Logical operators:
LOP_UNIVERSAL_QUANTIFIER    : [Aa] ;
LOP_EXISTENTIAL_QUANTIFIER  : [Ee] ;
LOP_NEGATION                : '~' ;
LOP_CONJUNCTION             : '&' ;
LOP_DISJUNCTION             : '|' ;
LOP_IMPLICATION             : '->' ;
LOP_EQUIVALENCE             : '<->' ;
LOP_LEADS_TO                : '~>' ;
LOP_REPETITION_COUNT        : '#' ;

// Trapset operators:
TOP_ABSOLUTE_COMPLEMENT : '!' ;
TOP_RELATIVE_COMPLEMENT : '\\' ;
TOP_LINKED_PAIR         : ';' ;

// Relations over natural numbers:
REL_LESS_THAN           : '<' ;
REL_LESS_THAN_OR_EQ     : '<=' ;
REL_GREATER_THAN        : '>' ;
REL_GREATER_THAN_OR_EQ  : '>=' ;
REL_EQUAL               : '=' ;

// Tokens
TRAPSET_ID      : TRAPSET_PREFIX NUMERIC_ID? ;
NUMERIC_ID      : DIGIT+ ;
NATURAL_NUMBER  : ZERO
                | NONZERO_DIGIT DIGIT+
                ;

// Skip whitespace!
WS : [ \t\r\n]+ -> skip ;

// Fragments (only meant to be used in token productions)
fragment TRAPSET_PREFIX : [Tt][Rr] ;
fragment ZERO : '0' ;
fragment DIGIT : [0-9] ;
fragment NONZERO_DIGIT : [1-9] ;
