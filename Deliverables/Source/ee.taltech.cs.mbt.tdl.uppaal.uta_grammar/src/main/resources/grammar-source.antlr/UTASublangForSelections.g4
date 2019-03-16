grammar UTASublangForSelections;

import UTALanguageCommons;

selectionList
    : selection (ENUMERATION_SEP selection)*
    ;

selection : IDENTIFIER OP_BIND type ;

OP_BIND : SYMBOL_COLON ;

SKIP_WS : WS -> skip ;
