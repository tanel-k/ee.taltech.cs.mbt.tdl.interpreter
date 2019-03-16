grammar UTASublangForParameters;

import UTALanguageCommons;

parameterList : parameter (ENUMERATION_SEP parameter)* ;

parameter
    : type parameterVariable arrayDeclaration*
    ;

parameterVariable
    : MODIFIER_BY_REFERENCE IDENTIFIER
        # ByReferenceVariable
    | IDENTIFIER
        # ByValueVariable
    ;

MODIFIER_BY_REFERENCE : '&' ;
