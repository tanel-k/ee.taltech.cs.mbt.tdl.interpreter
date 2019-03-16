grammar UTALanguageCommons;

/*
Expression associativity and precedence (listed from highest to lowest)
Associativity   | Precedence
-------------------------------------
left            | () [] .
right           | ! ++ -- - (unary) + (unary)
left            | * / %
left            | - +
left            | << >>
left            | <? >?
left            | < <= >= >
left            | == !=
left            | &
left            | ^
left            | |
left            | &&
right           | ||
right           | ?:
right           | = := += -= *= /= %= &= |= <<= >>= ^=
right           | not
left            | or
left            | and
left            | or imply
left            | forall exists
*/
expression
    :<assoc=left> LEFT_PAREN expression RIGHT_PAREN
        # ExpressionGrouped
    |<assoc=left> expression LEFT_BRACKET expression RIGHT_BRACKET
        # ExpressionArrayLookup
    |<assoc=left> expression BINARY_OP_ACCESS_FIELD IDENTIFIER
        # ExpressionFieldAccess
    |<assoc=right> UNARY_OP_NEGATED expression
        # ExpressionUnaryOpNegated
    |<assoc=right> expression UNARY_OP_INCREMENT
        # ExpressionIncrementAndGet
    |<assoc=right> UNARY_OP_INCREMENT expression
        # ExpressionGetAndIncrement
    |<assoc=right> expression UNARY_OP_DECREMENT
        # ExpressionGetAndDecrement
    |<assoc=right> UNARY_OP_DECREMENT expression
        # ExpressionDecrementAndGet
    |<assoc=right> UNARY_OP_NEGATIVE expression
        # ExpressionUnaryOpNegative
    |<assoc=right> UNARY_OP_POSITIVE expression
        # ExpressionUnaryOpPositive
    |<assoc=left> expression BINARY_OP_MULTIPLICATION expression
        # ExpressionBinaryOpMultiplication
    |<assoc=left> expression BINARY_OP_DIVISION expression
        # ExpressionBinaryOpDivision
    |<assoc=left> expression BINARY_OP_MODULO expression
        # ExpressionBinaryOpModulo
    |<assoc=left> expression BINARY_OP_SUBTRACTION expression
        # ExpressionBinaryOpSubtraction
    |<assoc=left> expression BINARY_OP_ADDITION expression
        # ExpressionBinaryOpAddition
    |<assoc=left> expression BINARY_OP_LEFT_SHIFT expression
        # ExpressionBinaryOpLeftShift
    |<assoc=left> expression BINARY_OP_RIGHT_SHIFT expression
        # ExpressionBinaryOpRightShift
    |<assoc=left> expression BINARY_OP_MAX expression
        # ExpressionBinaryOpMaximum
    |<assoc=left> expression BINARY_OP_MIN expression
        # ExpressionBinaryOpMinimum
    |<assoc=left> expression BINARY_OP_LESS_THAN expression
        # ExpressionBinaryOpLessThan
    |<assoc=left> expression BINARY_OP_LESS_THAN_OR_EQUAL_TO expression
        # ExpressionBinaryOpLessThanOrEqual
    |<assoc=left> expression BINARY_OP_GREATER_THAN expression
        # ExpressionBinaryOpGreaterThan
    |<assoc=left> expression BINARY_OP_GREATER_THAN_OR_EQUAL expression
        # ExpressionBinaryOpGreaterThanOrEqual
    |<assoc=left> expression BINARY_OP_EQUAL expression
        # ExpressionBinaryOpEqual
    |<assoc=left> expression BINARY_OP_NOT_EQUAL expression
        # ExpressionBinaryOpNotEqual
    |<assoc=left> expression BINARY_OP_BITWISE_AND expression
        # ExpressionBinaryOpBitwiseAnd
    |<assoc=left> expression BINARY_OP_BITWISE_XOR expression
        # ExpressionBinaryOpBitwiseXOR
    |<assoc=left> expression BINARY_OP_BITWISE_OR expression
        # ExpressionBinaryOpBitwiseOr
    |<assoc=left> expression BINARY_OP_CONJUNCTION expression
        # ExpressionBinaryOpConjunction
    |<assoc=left> expression BINARY_OP_DISJUNCTION expression
        # ExpressionBinaryOpDisjunction
    |<assoc=right> expression TERNARY_OP_IF_ELSE expression TERNARY_OP_IF_ELSE_SEP expression
        # ExpressionTernary
    |<assoc=right> expression ASSG_OP expression
        # ExpressionAssignOp
    |<assoc=right> expression ASSG_OP_ADDITION expression
        # ExpressionAssignOpAddition
    |<assoc=right> expression ASSG_OP_SUBTRACTION expression
        # ExpressionAssignOpSubtraction
    |<assoc=right> expression ASSG_OP_MULTIPLICATION expression
        # ExpressionAssignOpMultiplication
    |<assoc=right> expression ASSG_OP_DIVISION expression
        # ExpressionAssignOpDivision
    |<assoc=right> expression ASSG_OP_MODULO expression
        # ExpressionAssignOpModulo
    |<assoc=right> expression ASSG_OP_BITWISE_AND expression
        # ExpressionAssignOpBitwiseAnd
    |<assoc=right> expression ASSG_OP_BITWISE_OR expression
        # ExpressionAssignOpBitwiseOr
    |<assoc=right> expression ASSG_OP_LEFT_SHIFT expression
        # ExpressionAssignOpLeftShift
    |<assoc=right> expression ASSG_OP_RIGHT_SHIFT expression
        # ExpressionAssignOpRightShift
    |<assoc=right> expression ASSG_OP_BITWISE_XOR expression
        # ExpressionAssignOpBitwiseXOR
    |<assoc=right> UNARY_OP_NEGATED_PHRASE expression
        # ExpressionUnaryOpNegatedPhrase
    |<assoc=left> expression BINARY_OP_DISJUNCTION_PHRASE expression
        # ExpressionBinaryOpDisjunctionPhrase
    |<assoc=left> expression BINARY_OP_IMPLICATION_PHRASE expression
        # ExpressionBinaryOpImplicationPhrase
    |<assoc=left> expression BINARY_OP_CONJUNCTION_PHRASE expression
        # ExpressionBinaryOpConjunctionPhrase
    |<assoc=left>  TERNARY_OP_UNIVERSAL_QUANTIFICATION
            LEFT_PAREN
                IDENTIFIER TERNARY_OP_QUANTIFICATION_SEP type
            RIGHT_PAREN
            expression
        # ExpressionUniversalQuantification
    |<assoc=left> TERNARY_OP_EXISTENTIAL_QUANTIFICATION
            LEFT_PAREN
                IDENTIFIER TERNARY_OP_QUANTIFICATION_SEP type
            RIGHT_PAREN
            expression
        # ExpressionExistentialQuantification
    | expression LEFT_PAREN arguments RIGHT_PAREN
        # ExpressionWithArguments
    | EXPR_LITERAL_DEADLOCK
        # ExpressionDeadlockLiteral
    | EXPR_LITERAL_TRUE
        # ExpressionTrueLiteral
    | EXPR_LITERAL_FALSE
        # ExpressionFalseLiteral
    | NATURAL_NUMBER
        # ExpressionNaturalNumber
    | IDENTIFIER
        # ExpressionVariableRef
    ;

arguments : expression (ENUMERATION_SEP expression)* ;

type : typePrefix? typeIdentifier ;

typeIdentifier
    // Integer type:
    : TYPE_INTEGER
        # TypeIdInteger
    // Clock type
    | TYPE_CLOCK
        # TypeIdClock
    // Channel type
    | TYPE_CHANNEL
        # TypeIdChannel
    // Boolean type
    | TYPE_BOOLEAN
        # TypeIdBoolean
    // Integer type (with min and max bound):
    | TYPE_INTEGER LEFT_BRACKET expression ENUMERATION_SEP expression RIGHT_BRACKET
        # TypeIdIntegerBounded
    // Scalar type:
    // Scalar types only have assignment and identity testing operations.
    | TYPE_SCALAR LEFT_BRACKET expression RIGHT_BRACKET
        # TypeIdScalar
    // Record type:
    // Follows C notation
    | TYPE_STRUCT LEFT_CURLY fieldDeclaration+ RIGHT_CURLY
        # TypeIdStruct
    // Custom type (should be last since it matches a-zA-Z):
    | IDENTIFIER
        # TypeIdIdentifier
    ;

fieldDeclaration
    : type IDENTIFIER arrayDeclaration* (ENUMERATION_SEP IDENTIFIER arrayDeclaration*)* SEMICOLON_SEP
    ;

// When appended to a type, denotes an array
arrayDeclaration
    // Array size can be specified as an integer
    : LEFT_BRACKET expression RIGHT_BRACKET
        # ArraySizeFromExpression
    // Or as a bounded integer type or scalar set type
    | LEFT_BRACKET type RIGHT_BRACKET
        # ArraySizeFromType
    ;

typePrefix
    // Urgent modifier is only applicable for channels.
    : TYPE_PREFIX_URGENT
        # TypePrefixUrgent
    // Broadcast modifier is only applicable for channels.
    | TYPE_PREFIX_BROADCAST
        # TypePrefixBroadcast
    // Integers, Booleans and arrays/records over integers and Booleans can be marked as meta.
    // Meta variables are not considered part of the state.
    | TYPE_PREFIX_META
        # TypePrefixMeta
    // Integers, Booleans, arrays and arrays/records over integers and Booleans can be marked constant.
    | TYPE_PREFIX_CONST
        # TypePrefixConstant
    ;

// Uppaal types
TYPE_INTEGER    : 'int' ;
TYPE_CLOCK      : 'clock' ;
TYPE_CHANNEL    : 'chan' ;
TYPE_BOOLEAN    : 'bool' ;
TYPE_SCALAR     : 'scalar' ;
TYPE_STRUCT     : 'struct' ;

// Uppaal type prefixes
TYPE_PREFIX_URGENT      : 'urgent' ;
TYPE_PREFIX_BROADCAST   : 'broadcast' ;
TYPE_PREFIX_META        : 'meta' ;
TYPE_PREFIX_CONST       : 'const' ;

// Expression literals:
EXPR_LITERAL_TRUE        : 'true' ;
EXPR_LITERAL_FALSE       : 'false' ;
EXPR_LITERAL_DEADLOCK    : 'deadlock' ;

// Valid identifier names in Uppaal
IDENTIFIER : [a-zA-Z_]([a-zA-Z0-9_])* ;

// Assignment operators
ASSG_OP                 : (SYMBOL_ASSIGNMENT | SYMBOL_ASSIGNMENT_LEGACY) ;
ASSG_OP_SUBTRACTION     : '-=' ;
ASSG_OP_ADDITION        : '+=' ;
ASSG_OP_MULTIPLICATION  : '*=' ;
ASSG_OP_DIVISION        : '/=' ;
ASSG_OP_MODULO          : '%=' ;
ASSG_OP_BITWISE_OR      : '|=' ;
ASSG_OP_BITWISE_AND     : '&=' ;
ASSG_OP_BITWISE_XOR     : '^=' ;
ASSG_OP_LEFT_SHIFT      : '<<=' ;
ASSG_OP_RIGHT_SHIFT     : '>>=' ;

// Unary operators
UNARY_OP_POSITIVE          : SYMBOL_PLUS ;
UNARY_OP_NEGATIVE          : SYMBOL_MINUS ;
UNARY_OP_NEGATED           : '!' ;
UNARY_OP_NEGATED_PHRASE    : 'not' ;
UNARY_OP_INCREMENT         : SYMBOL_PLUS{2} ;
UNARY_OP_DECREMENT         : SYMBOL_MINUS{2} ;

// Binary operators
BINARY_OP_LESS_THAN             : SYMBOL_LESS_THAN ;
BINARY_OP_LESS_THAN_OR_EQUAL_TO : '<=' ;
BINARY_OP_EQUAL                 : '==' ;
BINARY_OP_NOT_EQUAL             : '!=' ;
BINARY_OP_GREATER_THAN_OR_EQUAL : '>=' ;
BINARY_OP_GREATER_THAN          : '>' ;
BINARY_OP_ADDITION              : SYMBOL_PLUS ;
BINARY_OP_SUBTRACTION           : SYMBOL_MINUS ;
BINARY_OP_MULTIPLICATION        : '*' ;
BINARY_OP_DIVISION              : '/' ;
BINARY_OP_MODULO                : '%' ;
BINARY_OP_BITWISE_AND           : '&' ;
BINARY_OP_BITWISE_OR            : '|' ;
BINARY_OP_BITWISE_XOR           : '^' ;
BINARY_OP_LEFT_SHIFT            : '<<' ;
BINARY_OP_RIGHT_SHIFT           : '>>' ;
BINARY_OP_CONJUNCTION           : '&&' ;
BINARY_OP_DISJUNCTION           : '||' ;
BINARY_OP_MAX                   : '>?' ;
BINARY_OP_MIN                   : '<?' ;
BINARY_OP_DISJUNCTION_PHRASE    : 'or' ;
BINARY_OP_CONJUNCTION_PHRASE    : 'and' ;
BINARY_OP_IMPLICATION_PHRASE    : 'imply' ;
BINARY_OP_ACCESS_FIELD          : SYMBOL_PERIOD ;

TERNARY_OP_IF_ELSE                    : '?' ;
TERNARY_OP_IF_ELSE_SEP                : SYMBOL_COLON ;
TERNARY_OP_UNIVERSAL_QUANTIFICATION   : 'forall' ;
TERNARY_OP_EXISTENTIAL_QUANTIFICATION : 'exists' ;
TERNARY_OP_QUANTIFICATION_SEP         : SYMBOL_COLON ;

LEFT_CURLY      : '{';
RIGHT_CURLY     : '}';
LEFT_BRACKET    : '[' ;
RIGHT_BRACKET   : ']' ;
LEFT_PAREN      : '(' ;
RIGHT_PAREN     : ')' ;

NATURAL_NUMBER : [0-9]+ ;

ENUMERATION_SEP     : SYMBOL_COMMA ; // separator for enumerated items
SEMICOLON_SEP         : SYMBOL_SEMICOLON ; // statement terminator in Uppaal

WS : SYMBOL_BLANK+ ;

fragment SYMBOL_LESS_THAN           : '<' ;
fragment SYMBOL_COMMA               : ',' ;
fragment SYMBOL_SEMICOLON           : ';' ;
fragment SYMBOL_BLANK               : [ \t\r\n] ;
fragment SYMBOL_PLUS                : '+' ;
fragment SYMBOL_MINUS               : '-' ;
fragment SYMBOL_PERIOD              : '.' ;
fragment SYMBOL_COLON               : ':' ;
fragment SYMBOL_ASSIGNMENT          : '=' ;
fragment SYMBOL_ASSIGNMENT_LEGACY   : ':=' ;

SKIP_WS : WS -> skip ;
