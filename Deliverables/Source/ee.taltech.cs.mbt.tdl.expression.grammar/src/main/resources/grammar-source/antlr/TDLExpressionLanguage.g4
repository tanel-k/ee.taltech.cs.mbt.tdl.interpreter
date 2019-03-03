grammar TDLExpressionLanguage;

// Root production:
expression  : LEFT_PAREN expression RIGHT_PAREN  # GroupedExpression
            | LOP_NEGATION expression  # NegatedExpression
            | expression LOP_CONJUNCTION expression  # ConjunctiveExpression
            | expression LOP_DISJUNCTION expression  # DisjunctiveExpression
            | expression LOP_IMPLICATION expression  # ImplicativeExpression
            | expression LOP_EQUIVALENCE expression  # EquivalenceExpression
            | expression LOP_LEADS_TO expression  # LeadsToExpression
            | expression LOP_LEADS_TO LEFT_BRACKET boundOverNaturals RIGHT_BRACKET expression  # TimeBoundedLeadsToExpression
            | LOP_REPETITION_COUNT expression LEFT_BRACKET boundOverNaturals RIGHT_BRACKET  # ConditionalRepetitionExpression
            | quantifiedTrapsetExpression  # GroundTermExpression
            ;

// Ground term for expression (quantified trapset expression):
quantifiedTrapsetExpression : LOP_UNIVERSAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN # UniversalTrapsetExpression
                            | LOP_EXISTENTIAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN # ExistentialTrapsetExpression
                            ;

// Trapset expressions:
trapsetExpression : LEFT_PAREN trapsetExpression RIGHT_PAREN # GroupedTrapsetExpression
                  | TOP_ABSOLUTE_COMPLEMENT trapsetExpression # AbsoluteTrapsetComplementExpression
                  | trapsetExpression TOP_RELATIVE_COMPLEMENT trapsetExpression # RelativeTrapsetComplementExpression
                  | trapsetExpression TOP_LINKED_PAIR trapsetExpression # LinkedTrapsetPairExpression
                  | TRAPSET_ID # TrapsetIdentifierExpression
                  ;

// Partial relation over natural numbers:
boundOverNaturals : REL_LESS_THAN NATURAL_NUMBER  # LessThanBound
                  | REL_GREATER_THAN NATURAL_NUMBER  # GreaterThanBound
                  | REL_LESS_THAN_OR_EQ NATURAL_NUMBER  # LessThanOrEqBound
                  | REL_GREATER_THAN_OR_EQ NATURAL_NUMBER  # GreaterThanOrEqBound
                  | REL_EQUAL NATURAL_NUMBER  # EqualityBound
                  ;

// Tokens:
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
LOP_IMPLICATION             : '-' BLANK* '>' ;
LOP_EQUIVALENCE             : '<' BLANK* '-' BLANK* '>' ;
LOP_LEADS_TO                : '~' BLANK* '>' ;
LOP_REPETITION_COUNT        : '#' ;

// Trapset operators:
TOP_ABSOLUTE_COMPLEMENT : '!' ;
TOP_RELATIVE_COMPLEMENT : '\\' ;
TOP_LINKED_PAIR         : ';' ;

// Relations over natural numbers:
REL_LESS_THAN_OR_EQ     : '<' BLANK* '=' ;
REL_GREATER_THAN_OR_EQ  : '>' BLANK* '=' ;
REL_LESS_THAN           : '<' ;
REL_GREATER_THAN        : '>' ;
REL_EQUAL               : '=' ;

// Other:
TRAPSET_ID      : TRAPSET_PREFIX NUMERIC_ID? ;
NATURAL_NUMBER  : ZERO
                | NONZERO_DIGIT ANY_DIGIT*
                ;
NUMERIC_ID      : ANY_DIGIT+ ;

// Fragments (only meant to be used in token productions):
fragment TRAPSET_PREFIX : [Tt][Rr] ;
fragment ZERO           : [0] ;
fragment ANY_DIGIT      : [0-9] ;
fragment NONZERO_DIGIT  : [1-9] ;
fragment BLANK          : [ \t\r\n] ;

// Meta rules:
// Skip whitespace:
WS : BLANK+ -> skip ;
