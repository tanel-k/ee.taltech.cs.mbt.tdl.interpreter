grammar UTASublangForUpdates;

import UTALanguageCommons;

updateList
    : expression (ENUMERATION_SEP expression)*
    ;

SKIP_WS : WS -> skip ;
