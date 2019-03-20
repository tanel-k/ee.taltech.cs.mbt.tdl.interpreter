grammar UTALanguage;

@lexer::members {
public static final int CHANNEL_LANGUAGE = 0;
public static final int CHANNEL_WHITESPACE = 1;
public static final int CHANNEL_COMMENTS = 2;
}

// UTA template parameters:
utaTemplateParameterList
    : parameterList?
    ;

parameterList
    : parameter (SEP_ENUMERATION parameter)*
    ;

parameter
    : type parameterIdentifier
    ;

parameterIdentifier
    : COMMON_TOK_AMPERSAND identifierNameVariant
        # ByReferenceVariable
    | identifierNameVariant
        # ByValueVariable
    ;

// UTA transition assignments:
utaTransitionUpdateList
    : expression (SEP_ENUMERATION expression)*
    ;

// UTA global and local declarations:
utaDeclarations
    : declarationSequence
    ;

// UTA transition synchronization:
utaTransitionSynchronization
    : expression COMMON_TOK_EXCLAMATION_MARK
        # ActiveSynchronization
    | expression COMMON_TOK_QUESTION_MARK
        # ReactiveSynchronization
    ;

// UTA transition select:
utaTransitionSelectionSequence
    : selection (SEP_ENUMERATION selection)*
    ;

// UTA transition guard:
utaTransitionGuardExpression
    : expression
    ;

// UTA location invariant
utaLocationInvariantExpression
    : expression
    ;

// UTA system definition:
utaSystemDefinition
    : systemDeclarationSequence
      systemLine?
      progressMeasureDeclaration?
    ;

systemDeclarationSequence
    : systemDeclarationStatement*
    ;

systemDeclarationStatement
    : processVariableAssignment
    | declaration
    ;

// This will class with assignment expressions if used at the same alt layer.
// Currently this alts with declarations, which do not clash with the productions below.
processVariableAssignment
    : IDENTIFIER_NAME GROUP_LEFT_PAREN parameterList GROUP_RIGHT_PAREN ASSG_OP
      IDENTIFIER_NAME GROUP_LEFT_PAREN argumentList? GROUP_RIGHT_PAREN SEP_SEMICOLON
        # ProcessVarPartialTemplateInstantiation
    | IDENTIFIER_NAME ASSG_OP
      IDENTIFIER_NAME GROUP_LEFT_PAREN argumentList? GROUP_RIGHT_PAREN SEP_SEMICOLON
        # ProcessVarFullTemplateInstantiation
    ;

systemLine
    : PHRASE_SYSTEM systemProcessesList SEP_SEMICOLON
    ;

systemProcessesList
    : systemProcessRefList (COMMON_TOK_LESS_THAN systemProcessRefList)*
    ;

systemProcessRefList
    : systemProcessRef (SEP_ENUMERATION systemProcessRef)*
    ;

systemProcessRef
    : IDENTIFIER_NAME
    ;

progressMeasureDeclaration
    : PHRASE_PROGRESS GROUP_LEFT_CURLY (expression SEP_SEMICOLON)* GROUP_RIGHT_CURLY
    ;

selection : IDENTIFIER_NAME COMMON_TOK_COLON type ;

declarationSequence : declaration* ;

declaration
    : type variableInitialization (SEP_ENUMERATION variableInitialization)* SEP_SEMICOLON
        # VariableDeclaration
    | PHRASE_TYPEDEF type identifierNameVariant (SEP_ENUMERATION identifierNameVariant)* SEP_SEMICOLON
        # TypeDeclaration
    | declarationOfFunction
        # FunctionDeclaration
    | TYPE_CHANNEL PHRASE_PRIORITY channelPrioritySpecExpression SEP_SEMICOLON
        # ChannelPriorityDeclaration
    ;

channelPrioritySpecExpression
    : channelRefList (COMMON_TOK_LESS_THAN channelRefList)+
    ;

channelRefList
    : channelRefExpression (SEP_ENUMERATION channelRefExpression)*
    ;

channelRefExpression
    : PHRASE_DEFAULT
        # ChannelDefaultPriorityExpr
    | IDENTIFIER_NAME
        # ChannelIdentifierNameExpr
    | arrayIdentifierLookup
        # ChannelArrayLookupExr
    ;

variableInitialization
    : identifierNameVariant (ASSG_OP initializerExpression)?
    ;

initializerExpression
    : expression
        # FlatInitializer
    | GROUP_LEFT_CURLY initializerExpression (SEP_ENUMERATION initializerExpression)* GROUP_RIGHT_CURLY
        # StructuredInitializer
    ;

declarationOfFunction
    : type IDENTIFIER_NAME GROUP_LEFT_PAREN parameterList? GROUP_RIGHT_PAREN blockOfStatements
        # DeclarationOfValueFunction
    | PHRASE_VOID IDENTIFIER_NAME GROUP_LEFT_PAREN parameterList? GROUP_RIGHT_PAREN blockOfStatements
        # DeclarationOfVoidFunction
    ;

blockOfStatements
    : GROUP_LEFT_CURLY declarationSequence statement* GROUP_RIGHT_CURLY
    ;

statement
    : blockOfStatements
        # StatementBlock
    | SEP_SEMICOLON
        # StatementEmpty
    | expression SEP_SEMICOLON
        # StatementExpression
    | PHRASE_FOR
      GROUP_LEFT_PAREN
        loopInitializer SEP_SEMICOLON
        loopCondition SEP_SEMICOLON
        loopUpdate
      GROUP_RIGHT_PAREN
      loopBody
        # StatementForLoop
    | PHRASE_FOR
      GROUP_LEFT_PAREN
        IDENTIFIER_NAME COMMON_TOK_COLON type
      GROUP_RIGHT_PAREN
      loopBody
        # StatementIteration
    | PHRASE_WHILE
      GROUP_LEFT_PAREN
        loopCondition
      GROUP_RIGHT_PAREN
      loopBody
        # StatementWhileLoop
    | PHRASE_DO loopBody PHRASE_WHILE loopCondition SEP_SEMICOLON
        # StatementDoWhile
    | PHRASE_IF
      GROUP_LEFT_PAREN expression GROUP_RIGHT_PAREN
      primaryStatement
      (PHRASE_ELSE alternativeStatement)?
        # StatementConditional
    | PHRASE_RETURN expression? SEP_SEMICOLON
        # StatementReturn
    ;

primaryStatement
    : statement
    ;

alternativeStatement
    : statement
    ;

loopInitializer
    : expression
    ;

loopCondition
    : expression
    ;

loopUpdate
    : expression
    ;

loopBody
    : statement
    ;

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
        # ExpressionGrouped
    |<assoc=left> expression GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # ExpressionArrayLookup
    |<assoc=left> expression BINARY_OP_ACCESS_FIELD IDENTIFIER_NAME
        # ExpressionFieldAccess
    |<assoc=right> COMMON_TOK_EXCLAMATION_MARK expression
        # ExpressionUnaryOpNegated
    |<assoc=right> expression UNARY_OP_INCREMENT
        # ExpressionIncrementAndGet
    |<assoc=right> UNARY_OP_INCREMENT expression
        # ExpressionGetAndIncrement
    |<assoc=right> expression UNARY_OP_DECREMENT
        # ExpressionGetAndDecrement
    |<assoc=right> UNARY_OP_DECREMENT expression
        # ExpressionDecrementAndGet
    |<assoc=right> COMMON_TOK_MINUS expression
        # ExpressionUnaryOpNegative
    |<assoc=right> COMMON_TOK_PLUS expression
        # ExpressionUnaryOpPositive
    |<assoc=left> expression BINARY_OP_MULTIPLICATION expression
        # ExpressionBinaryOpMultiplication
    |<assoc=left> expression BINARY_OP_DIVISION expression
        # ExpressionBinaryOpDivision
    |<assoc=left> expression BINARY_OP_MODULO expression
        # ExpressionBinaryOpModulo
    |<assoc=left> expression COMMON_TOK_MINUS expression
        # ExpressionBinaryOpSubtraction
    |<assoc=left> expression COMMON_TOK_PLUS expression
        # ExpressionBinaryOpAddition
    |<assoc=left> expression BINARY_OP_LEFT_SHIFT expression
        # ExpressionBinaryOpLeftShift
    |<assoc=left> expression BINARY_OP_RIGHT_SHIFT expression
        # ExpressionBinaryOpRightShift
    |<assoc=left> expression BINARY_OP_MAX expression
        # ExpressionBinaryOpMaximum
    |<assoc=left> expression BINARY_OP_MIN expression
        # ExpressionBinaryOpMinimum
    |<assoc=left> expression COMMON_TOK_LESS_THAN expression
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
    |<assoc=left> expression COMMON_TOK_AMPERSAND expression
        # ExpressionBinaryOpBitwiseAnd
    |<assoc=left> expression BINARY_OP_BITWISE_XOR expression
        # ExpressionBinaryOpBitwiseXOR
    |<assoc=left> expression BINARY_OP_BITWISE_OR expression
        # ExpressionBinaryOpBitwiseOr
    |<assoc=left> expression BINARY_OP_CONJUNCTION expression
        # ExpressionBinaryOpConjunction
    |<assoc=left> expression BINARY_OP_DISJUNCTION expression
        # ExpressionBinaryOpDisjunction
    |<assoc=right> expression COMMON_TOK_QUESTION_MARK expression COMMON_TOK_COLON expression
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
    |<assoc=right> PHRASE_NOT expression
        # ExpressionUnaryOpNegatedPhrase
    |<assoc=left> expression PHRASE_OR expression
        # ExpressionBinaryOpDisjunctionPhrase
    |<assoc=left> expression PHRASE_IMPLY expression
        # ExpressionBinaryOpImplicationPhrase
    |<assoc=left> expression PHRASE_AND expression
        # ExpressionBinaryOpConjunctionPhrase
    |<assoc=left>  PHRASE_FOR_ALL
            GROUP_LEFT_PAREN
                IDENTIFIER_NAME COMMON_TOK_COLON type
            GROUP_RIGHT_PAREN
            expression
        # ExpressionUniversalQuantification
    |<assoc=left> PHRASE_EXISTS
            GROUP_LEFT_PAREN
                IDENTIFIER_NAME COMMON_TOK_COLON type
            GROUP_RIGHT_PAREN
            expression
        # ExpressionExistentialQuantification
    | expression GROUP_LEFT_PAREN argumentList GROUP_RIGHT_PAREN
        # ExpressionCall
    | EXPR_LITERAL_DEADLOCK
        # ExpressionDeadlockLiteral
    | EXPR_LITERAL_TRUE
        # ExpressionTrueLiteral
    | EXPR_LITERAL_FALSE
        # ExpressionFalseLiteral
    | NATURAL_NUMBER
        # ExpressionNaturalNumber
    | IDENTIFIER_NAME
        # ExpressionIdentifierRef
    ;

argumentList : expression (SEP_ENUMERATION expression)* ;

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
    | TYPE_INTEGER GROUP_LEFT_BRACKET expression SEP_ENUMERATION expression GROUP_RIGHT_BRACKET
        # TypeIdIntegerBounded
    // Scalar type:
    // Scalar types only have assignment and identity testing operations.
    | TYPE_SCALAR GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # TypeIdScalar
    // Record type:
    // Follows C notation
    | TYPE_STRUCT GROUP_LEFT_CURLY fieldDeclaration+ GROUP_RIGHT_CURLY
        # TypeIdStruct
    // Custom type (should be last since it matches a-zA-Z):
    | IDENTIFIER_NAME
        # TypeIdIdentifierName
    ;

arrayIdentifierLookup
    : IDENTIFIER_NAME (GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET)+
    ;

fieldDeclaration
    : type identifierNameVariant (SEP_ENUMERATION identifierNameVariant)* SEP_SEMICOLON
    ;

identifierNameVariant
    : IDENTIFIER_NAME arraySizeModifier+
        # ArrayIdentifier
    | IDENTIFIER_NAME
        # BaseIdentifier
    ;

// When appended to a type, denotes an array
arraySizeModifier
    // Array size can be specified as an integer
    : GROUP_LEFT_BRACKET expression GROUP_RIGHT_BRACKET
        # ArraySizeFromExpression
    // Or as a bounded integer type or scalar set type
    | GROUP_LEFT_BRACKET type GROUP_RIGHT_BRACKET
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
