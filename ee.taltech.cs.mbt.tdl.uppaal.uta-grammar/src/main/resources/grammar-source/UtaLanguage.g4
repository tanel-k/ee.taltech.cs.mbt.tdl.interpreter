grammar UtaLanguage;

@lexer::members {
public static final int CHANNEL_LANGUAGE = 0;
public static final int CHANNEL_WHITESPACE = 1;
public static final int CHANNEL_COMMENTS = 2;
}

synchronization
    : expression COMMON_TOK_EXCLAMATION_MARK
        # ActiveSynchronization
    | expression COMMON_TOK_QUESTION_MARK
        # ReactiveSynchronization
    ;

selectionSequence
    : selection (SEP_ENUMERATION selection)*
    ;

selection : IDENTIFIER_NAME COMMON_TOK_COLON type ;

systemDefinition
    : declarationSequence?
      systemLine?
      progressMeasureDeclaration?
    ;

systemLine
    : PHRASE_SYSTEM systemProcessSequence SEP_SEMICOLON
    ;

systemProcessSequence
    : systemProcessGroup (COMMON_TOK_LESS_THAN systemProcessGroup)*
    ;

systemProcessGroup
    : IDENTIFIER_NAME (SEP_ENUMERATION IDENTIFIER_NAME)*
    ;

progressMeasureDeclaration
    : PHRASE_PROGRESS GROUP_LEFT_CURLY (expression SEP_SEMICOLON)* GROUP_RIGHT_CURLY
    ;

declarationSequence : declaration+ ;

declaration
    : type variableInitialization (SEP_ENUMERATION variableInitialization)* SEP_SEMICOLON
        # VariableDeclaration
    | PHRASE_TYPEDEF type identifierDeclaration (SEP_ENUMERATION identifierDeclaration)* SEP_SEMICOLON
        # TypeDeclaration
    | declarationOfFunction
        # FunctionDeclaration
    | TYPE_CHANNEL PHRASE_PRIORITY channelPrioritySequence SEP_SEMICOLON
        # ChannelPriorityDeclaration
    | IDENTIFIER_NAME (GROUP_LEFT_PAREN parameterSequence? GROUP_RIGHT_PAREN)?
      ASSG_OP
      IDENTIFIER_NAME GROUP_LEFT_PAREN argumentSequence? GROUP_RIGHT_PAREN SEP_SEMICOLON
        # TemplateInstantiation
    ;

channelPrioritySequence
    : channelPriorityGroup (COMMON_TOK_LESS_THAN channelPriorityGroup)+
    ;

channelPriorityGroup
    : channelReference (SEP_ENUMERATION channelReference)*
    ;

channelReference
    : PHRASE_DEFAULT
        # DefaultChannelReference
    | arrayVariableLookup
        # ChannelArrayLookup
    | IDENTIFIER_NAME
        # ChannelIdentifierReference
    ;

variableInitialization
    : identifierDeclaration (ASSG_OP initializerExpression)?
    ;

initializerExpression
    : expression
        # FlatInitializer
    | GROUP_LEFT_CURLY initializerExpression (SEP_ENUMERATION initializerExpression)* GROUP_RIGHT_CURLY
        # StructuredInitializer
    ;

declarationOfFunction
    : type IDENTIFIER_NAME GROUP_LEFT_PAREN parameterSequence? GROUP_RIGHT_PAREN statementBlock
        # ValueFunctionDeclaration
    | PHRASE_VOID IDENTIFIER_NAME GROUP_LEFT_PAREN parameterSequence? GROUP_RIGHT_PAREN statementBlock
        # VoidFunctionDeclaration
    ;

statementBlock
    : GROUP_LEFT_CURLY declarationSequence? statementSequence? GROUP_RIGHT_CURLY
    ;

statementSequence : statement+ ;

statement
    : statementBlock
        # BlockStatement
    | expression SEP_SEMICOLON
        # ExpressionStatement
    | PHRASE_FOR
      GROUP_LEFT_PAREN expression SEP_SEMICOLON expression SEP_SEMICOLON expression GROUP_RIGHT_PAREN
      statement
        # ForLoopStatement
    | PHRASE_FOR
      GROUP_LEFT_PAREN IDENTIFIER_NAME COMMON_TOK_COLON type GROUP_RIGHT_PAREN
      statement
        # IterationStatement
    | PHRASE_WHILE GROUP_LEFT_PAREN expression GROUP_RIGHT_PAREN
      statement
        # WhileLoopStatement
    | PHRASE_DO statement PHRASE_WHILE expression SEP_SEMICOLON
        # DoWhileStatement
    | PHRASE_IF
      GROUP_LEFT_PAREN expression GROUP_RIGHT_PAREN
      statement
      (PHRASE_ELSE statement)?
        # ConditionalStatement
    | PHRASE_RETURN expression? SEP_SEMICOLON
        # StatementReturn
    | SEP_SEMICOLON
        # EmptyStatement
    ;

expressionSequence : expression (SEP_ENUMERATION expression)* ;

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
    :<assoc=left> GROUP_LEFT_PAREN expression GROUP_RIGHT_PAREN
        # ExpressionGroup
    |<assoc=left> expression GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # ArrayLookupExpression
    |<assoc=left> expression BINARY_OP_ACCESS_FIELD IDENTIFIER_NAME
        # FieldAccessExpression
    |<assoc=right> (COMMON_TOK_EXCLAMATION_MARK | PHRASE_NOT) expression
        # NegationExpression
    |<assoc=right> expression UNARY_OP_INCREMENT
        # PostfixIncrementExpression
    |<assoc=right> UNARY_OP_INCREMENT expression
        # PrefixIncrementExpression
    |<assoc=right> expression UNARY_OP_DECREMENT
        # PostfixDecrementExpression
    |<assoc=right> UNARY_OP_DECREMENT expression
        # PrefixDecrementExpression
    |<assoc=right> COMMON_TOK_MINUS expression
        # AdditiveInverseExpression
    |<assoc=right> COMMON_TOK_PLUS expression
        # AdditiveIdentityExpression
    |<assoc=left> expression BINARY_OP_MULTIPLICATION expression
        # MultiplicationExpression
    |<assoc=left> expression BINARY_OP_DIVISION expression
        # DivisionExpression
    |<assoc=left> expression BINARY_OP_MODULO expression
        # ModuloExpression
    |<assoc=left> expression COMMON_TOK_MINUS expression
        # SubtractionExpression
    |<assoc=left> expression COMMON_TOK_PLUS expression
        # AdditionExpression
    |<assoc=left> expression BINARY_OP_LEFT_SHIFT expression
        # LeftShiftExpression
    |<assoc=left> expression BINARY_OP_RIGHT_SHIFT expression
        # RightShiftExpression
    |<assoc=left> expression BINARY_OP_MAX expression
        # MaximumExpression
    |<assoc=left> expression BINARY_OP_MIN expression
        # MinimumExpression
    |<assoc=left> expression COMMON_TOK_LESS_THAN expression
        # LessThanExpression
    |<assoc=left> expression BINARY_OP_LESS_THAN_OR_EQUAL_TO expression
        # LessThanOrEqualExpression
    |<assoc=left> expression BINARY_OP_GREATER_THAN expression
        # GreaterThanExpression
    |<assoc=left> expression BINARY_OP_GREATER_THAN_OR_EQUAL expression
        # GreaterThanOrEqualExpression
    |<assoc=left> expression BINARY_OP_EQUAL expression
        # EqualityExpression
    |<assoc=left> expression BINARY_OP_NOT_EQUAL expression
        # InequalityExpression
    |<assoc=left> expression COMMON_TOK_AMPERSAND expression
        # BitwiseAndExpression
    |<assoc=left> expression BINARY_OP_BITWISE_XOR expression
        # BitwiseXorExpression
    |<assoc=left> expression BINARY_OP_BITWISE_OR expression
        # BitwiseOrExpression
    |<assoc=left> expression (BINARY_OP_CONJUNCTION | PHRASE_AND) expression
        # ConjunctionExpression
    |<assoc=left> expression (BINARY_OP_DISJUNCTION | PHRASE_OR)  expression
        # DisjunctionExpression
    |<assoc=right> expression COMMON_TOK_QUESTION_MARK expression COMMON_TOK_COLON expression
        # TernaryExpression
    |<assoc=left> expression PHRASE_IMPLY expression
        # ImplicationExpression
    |<assoc=left> (PHRASE_EXISTS | PHRASE_FOR_ALL) GROUP_LEFT_PAREN IDENTIFIER_NAME COMMON_TOK_COLON type GROUP_RIGHT_PAREN
          expression
        # QuantificationExpression
    | expression GROUP_LEFT_PAREN argumentSequence? GROUP_RIGHT_PAREN
        # CallExpression
    |<assoc=right> expression ASSG_OP expression
        # AssignmentExpression
    |<assoc=right> expression ASSG_OP_MULTIPLICATION expression
        # MultiplicationAssignmentExpr
    |<assoc=right> expression ASSG_OP_DIVISION expression
        # DivisionAssignmentExpr
    |<assoc=right> expression ASSG_OP_MODULO expression
        # ModuloAssignmentExpr
    |<assoc=right> expression ASSG_OP_SUBTRACTION expression
        # SubtractionAssignmentExpr
    |<assoc=right> expression ASSG_OP_ADDITION expression
        # AdditionAssignmentExpr
    |<assoc=right> expression ASSG_OP_LEFT_SHIFT expression
        # LeftShiftAssignmentExpr
    |<assoc=right> expression ASSG_OP_RIGHT_SHIFT expression
        # RightShiftAssignmentExpr
    |<assoc=right> expression ASSG_OP_BITWISE_AND expression
        # BitwiseAndAssignmentExpr
    |<assoc=right> expression ASSG_OP_BITWISE_XOR expression
        # BitwiseXorAssignmentExpr
    |<assoc=right> expression ASSG_OP_BITWISE_OR expression
        # BitwiseOrAssignmentExpr
    | EXPR_LITERAL_DEADLOCK
        # DeadlockLiteral
    | EXPR_LITERAL_TRUE
        # TrueLiteral
    | EXPR_LITERAL_FALSE
        # FalseLiteral
    | NATURAL_NUMBER
        # NaturalNumberLiteral
    | IDENTIFIER_NAME
        # IdentifierExpression
    ;

parameterSequence : parameter (SEP_ENUMERATION parameter)* ;

parameter : type referenceModifier? identifierDeclaration ;

referenceModifier : COMMON_TOK_AMPERSAND ;

argumentSequence : expression (SEP_ENUMERATION expression)* ;

type : typePrefix? typeIdentifier ;

typeIdentifier
    // Integer type:
    : TYPE_INTEGER
        # IntegerTypeId
    // Clock type
    | TYPE_CLOCK
        # ClockTypeId
    // Channel type
    | TYPE_CHANNEL
        # ChannelTypeId
    // Boolean type
    | TYPE_BOOLEAN
        # BooleanTypeId
    // Integer type (with min and max bound):
    | TYPE_INTEGER GROUP_LEFT_BRACKET expression SEP_ENUMERATION expression GROUP_RIGHT_BRACKET
        # BoundedIntegerTypeId
    // Scalar type:
    // Scalar types only have assignment and identity testing operations.
    | TYPE_SCALAR GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # ScalarTypeId
    // Record type:
    // Follows C notation
    | TYPE_STRUCT GROUP_LEFT_CURLY fieldDeclaration+ GROUP_RIGHT_CURLY
        # StructTypeId
    // Custom type (should be last since it matches a-zA-Z):
    | IDENTIFIER_NAME
        # CustomTypeId
    ;

arrayVariableLookup
    : IDENTIFIER_NAME (GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET)+
    ;

fieldDeclaration
    : type identifierDeclaration (SEP_ENUMERATION identifierDeclaration)* SEP_SEMICOLON
    ;

identifierDeclaration
    : IDENTIFIER_NAME arraySizeModifier+
        # ArrayIdentifierDeclaration
    | IDENTIFIER_NAME
        # BaseIdentifierDeclaration
    ;

// When appended to a type, denotes an array
arraySizeModifier
    // Array size can be specified as an integer
    : GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # ExpressionArraySizeModifier
    // Or as a bounded integer type or scalar set type
    | GROUP_LEFT_BRACKET type GROUP_RIGHT_BRACKET
        # TypeArraySizeModifier
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

SKIP_SL_COMMENT : '//' .*? ('\n'| EOF)  -> channel(2) ; // CHANNEL_COMMENTS
SKIP_ML_COMMENT : '/*' .*? '*/'         -> channel(2) ; // CHANNEL_COMMENTS
SKIP_WS         : [ \t\n\r]+            -> channel(1) ; // CHANNEL_WHITESPACE

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

// Binary operators
BINARY_OP_LESS_THAN_OR_EQUAL_TO : '<=' ;
BINARY_OP_GREATER_THAN_OR_EQUAL : '>=' ;
BINARY_OP_EQUAL                 : '==' ;
BINARY_OP_NOT_EQUAL             : '!=' ;
BINARY_OP_LEFT_SHIFT            : '<<' ;
BINARY_OP_RIGHT_SHIFT           : '>>' ;
BINARY_OP_CONJUNCTION           : '&&' ;
BINARY_OP_DISJUNCTION           : '||' ;
BINARY_OP_BITWISE_OR            : '|' ;
BINARY_OP_MULTIPLICATION        : '*' ;
BINARY_OP_DIVISION              : '/' ;
BINARY_OP_MODULO                : '%' ;
BINARY_OP_BITWISE_XOR           : '^' ;
BINARY_OP_MAX                   : '>?' ;
BINARY_OP_MIN                   : '<?' ;
BINARY_OP_GREATER_THAN          : '>' ;
BINARY_OP_ACCESS_FIELD          : '.' ;

// Unary operators
UNARY_OP_INCREMENT         : '++' ;
UNARY_OP_DECREMENT         : '--' ;

COMMON_TOK_COLON            : ':' ;
COMMON_TOK_PLUS             : '+' ;
COMMON_TOK_MINUS            : '-' ;
COMMON_TOK_AMPERSAND        : '&' ;
COMMON_TOK_LESS_THAN        : '<' ;
COMMON_TOK_EXCLAMATION_MARK : '!' ;
COMMON_TOK_QUESTION_MARK    : '?' ;

GROUP_LEFT_CURLY      : '{';
GROUP_RIGHT_CURLY     : '}';
GROUP_LEFT_BRACKET    : '[' ;
GROUP_RIGHT_BRACKET   : ']' ;
GROUP_LEFT_PAREN      : '(' ;
GROUP_RIGHT_PAREN     : ')' ;

SEP_ENUMERATION     : ',' ; // separator for enumerated items
SEP_SEMICOLON       : ';' ; // statement terminator in Uppaal

PHRASE_VOID     : 'void' ;
PHRASE_NOT      : 'not' ;
PHRASE_OR       : 'or' ;
PHRASE_AND      : 'and' ;
PHRASE_IMPLY    : 'imply' ;
PHRASE_FOR_ALL  : 'forall' ;
PHRASE_EXISTS   : 'exists' ;
PHRASE_TYPEDEF  : 'typedef' ;
PHRASE_IF       : 'if' ;
PHRASE_ELSE     : 'else' ;
PHRASE_FOR      : 'for' ;
PHRASE_WHILE    : 'while' ;
PHRASE_RETURN   : 'return' ;
PHRASE_DO       : 'do' ;
PHRASE_PRIORITY : 'priority' ;
PHRASE_DEFAULT  : 'default' ;
PHRASE_SYSTEM   : 'system' ;
PHRASE_PROGRESS : 'progress' ;

IDENTIFIER_NAME : [a-zA-Z_]([a-zA-Z0-9_])* ;
NATURAL_NUMBER : [0-9]+ ;

fragment SYMBOL_ASSIGNMENT          : '=' ;
fragment SYMBOL_ASSIGNMENT_LEGACY   : ':=' ;
