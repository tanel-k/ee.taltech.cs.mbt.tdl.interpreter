grammar UTASublangForDeclarations;

import UTASublangForParameters;

declarationList : declaration* ;

declaration
    : declarationOfVariable
    | declarationOfType
    | declarationOfFunction
    | declarationOfChannelPriority
    ;

declarationOfChannelPriority
    : TYPE_CHANNEL STMT_TOK_CHAN_PRIORITY channelPrioritySpecExpression SEMICOLON_SEP
    ;

channelPrioritySpecExpression
    : channelRefList (SEP_CHAN_PRIORITY channelRefList)+
    ;

channelRefList
    : channelRefExpression (ENUMERATION_SEP channelRefExpression)*
    ;

channelRefExpression
    : STMT_TOK_DEFAULT_CHAN_PRIORITY
        # ChannelExprDefaultPriority
    | channelRefExpression LEFT_BRACKET expression RIGHT_BRACKET
        # ChannelExpChannelArrayLookup
    | IDENTIFIER
        # ChannelExprChannelVariableRef
    ;

declarationOfVariable
    : type variableId (ENUMERATION_SEP variableId)* SEMICOLON_SEP
    ;

variableId
    : IDENTIFIER arrayDeclaration* (ASSG_OP initializerExpression)?
    ;

initializerExpression
    : expression
        # InitializerBase
    | LEFT_CURLY initializerExpression (ENUMERATION_SEP initializerExpression)* RIGHT_CURLY
        # InitializerForArray
    ;

declarationOfType
    : DECLARATION_MODIFIER_TYPE_DEFINITION type IDENTIFIER arrayDeclaration* (ENUMERATION_SEP IDENTIFIER arrayDeclaration*)* SEMICOLON_SEP
    ;

declarationOfFunction
    : type IDENTIFIER LEFT_PAREN parameterList RIGHT_PAREN statementBlock
    ;

statementBlock
    : LEFT_CURLY declarationList statement* RIGHT_CURLY
    ;

statement
    : statementBlock
        # StatetementBlock
    | SEMICOLON_SEP
        # StatementEmpty
    | expression SEMICOLON_SEP
        # StatementExpression
    | forLoopStatement
        # StatementForLoop
    | iterationStatement
        # StatementIteration
    | whileLoopStatement
        # StatementWhileLoop
    | doWhileStatement
        # StatementDoWhile
    | ifStatement
        # StatementConditional
    | returnStatement
        # StatementReturn
    ;

forLoopStatement
    : forLoopHeader loopBody
    ;

forLoopHeader
    : STMT_IDENTIFIER_FOR
        LEFT_PAREN
            loopInitializer SEMICOLON_SEP
            loopCondition SEMICOLON_SEP
            loopUpdate
        RIGHT_PAREN
    ;

iterationStatement
    : iterationHeader loopBody
    ;

iterationHeader
    : STMT_IDENTIFIER_FOR
        LEFT_PAREN
            IDENTIFIER STMT_TOK_ITERATE_IN type
        RIGHT_PAREN
    ;

whileLoopStatement
    : whileLoopHeader loopBody
    ;

whileLoopHeader
    : STMT_IDENTIFIER_WHILE
        LEFT_PAREN
            loopCondition
        RIGHT_PAREN
    ;

doWhileStatement
    : STMT_IDENTIFIER_DO loopBody STMT_IDENTIFIER_WHILE loopCondition SEMICOLON_SEP
    ;

ifStatement
    : STMT_IDENTIFIER_IF
        LEFT_PAREN expression RIGHT_PAREN
            statement
        (STMT_IDENTIFIER_ELSE statement)?
    ;

returnStatement
    : STMT_IDENTIFIER_RETURN expression? SEMICOLON_SEP
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

DECLARATION_MODIFIER_TYPE_DEFINITION : 'typedef' ;

// Uppaal function statement tokens
STMT_IDENTIFIER_IF      : 'if' ;
STMT_IDENTIFIER_ELSE    : 'else' ;
STMT_IDENTIFIER_FOR     : 'for' ;
STMT_IDENTIFIER_WHILE   : 'while' ;
STMT_IDENTIFIER_RETURN  : 'return' ;
STMT_IDENTIFIER_DO      : 'do' ;

STMT_TOK_CHAN_PRIORITY          : 'priority' ;
STMT_TOK_DEFAULT_CHAN_PRIORITY  : 'default' ;

STMT_TOK_ITERATE_IN : SYMBOL_COLON ;

SEP_CHAN_PRIORITY               : SYMBOL_LESS_THAN ;

fragment TYPE_DEFINITION : 'typedef' ;

SKIP_WS : WS -> skip ;
