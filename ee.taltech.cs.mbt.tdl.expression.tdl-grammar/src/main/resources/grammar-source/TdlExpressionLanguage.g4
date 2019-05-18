grammar TdlExpressionLanguage;

// Root production:
expression  :<assoc=left> LEFT_PAREN expression RIGHT_PAREN  #GroupedExpression
            |<assoc=right> expression LOP_LEADS_TO LEFT_BRACKET boundOverNaturals RIGHT_BRACKET expression  #TimeBoundedLeadsToExpression
            |<assoc=right> LOP_REPETITION_COUNT LEFT_BRACKET boundOverNaturals RIGHT_BRACKET expression #ConditionalRepetitionExpression
            |<assoc=left> LOP_NEGATION expression  #NegatedExpression
            |<assoc=left> expression LOP_CONJUNCTION expression  #ConjunctiveExpression
            |<assoc=left> expression LOP_DISJUNCTION expression  #DisjunctiveExpression
            |<assoc=left> expression LOP_IMPLICATION expression  #ImplicativeExpression
            |<assoc=left> expression LOP_EQUIVALENCE expression  #EquivalenceExpression
            |<assoc=left> expression LOP_LEADS_TO expression  #LeadsToExpression
            | quantifiedTrapsetExpression  #GroundTermExpression
            ;

// Ground term for expression (quantified trapset expression):
quantifiedTrapsetExpression : LOP_UNIVERSAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN #UniversalTrapsetExpression
                            | LOP_EXISTENTIAL_QUANTIFIER LEFT_PAREN trapsetExpression RIGHT_PAREN #ExistentialTrapsetExpression
                            ;

// Trapset expressions:
trapsetExpression : TOP_ABSOLUTE_COMPLEMENT TRAPSET_ID #AbsoluteTrapsetComplementExpression
                  | TRAPSET_ID TOP_RELATIVE_COMPLEMENT TRAPSET_ID #RelativeTrapsetComplementExpression
                  | TRAPSET_ID TOP_LINKED_PAIRS TRAPSET_ID #LinkedTrapsetPairExpression
                  | TRAPSET_ID #BaseTrapsetExpression
                  ;

// Partial relation over natural numbers:
boundOverNaturals : REL_LESS_THAN NATURAL_NUMBER  #LessThanBound
                  | REL_GREATER_THAN NATURAL_NUMBER  #GreaterThanBound
                  | REL_LESS_THAN_OR_EQ NATURAL_NUMBER  #LessThanOrEqBound
                  | REL_GREATER_THAN_OR_EQ NATURAL_NUMBER  #GreaterThanOrEqBound
                  | REL_EQUAL NATURAL_NUMBER  #EqualityBound
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
LOP_IMPLICATION             : '=' BLANK* '>' ;
LOP_EQUIVALENCE             : '<' BLANK* '=' BLANK* '>' ;
LOP_LEADS_TO                : '~' BLANK* '>' ;
LOP_REPETITION_COUNT        : '#' ;

// Trapset operators:
TOP_ABSOLUTE_COMPLEMENT : '!' ;
TOP_RELATIVE_COMPLEMENT : '\\' ;
TOP_LINKED_PAIRS         : ';' ;

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
fragment TRAPSET_PREFIX : [Tt][Ss] ;
fragment ZERO           : [0] ;
fragment ANY_DIGIT      : [0-9] ;
fragment NONZERO_DIGIT  : [1-9] ;
fragment BLANK          : [ \t\r\n] ;

// Meta rules:
// Skip whitespace:
WS : BLANK+ -> skip ;
