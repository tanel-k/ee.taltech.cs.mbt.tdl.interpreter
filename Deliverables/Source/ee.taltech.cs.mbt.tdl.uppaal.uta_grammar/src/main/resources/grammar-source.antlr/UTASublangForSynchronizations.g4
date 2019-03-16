grammar UTASublangForSynchronizations;

import UTALanguageCommons ;

synchronization
    : expression OP_EMIT
        # ActiveSynchronization
    | expression OP_RECEIVE
        # ReactiveSynchronization
    ;

OP_EMIT     : '!' ;
OP_RECEIVE  : '?' ;

SKIP_WS : WS -> skip ;
