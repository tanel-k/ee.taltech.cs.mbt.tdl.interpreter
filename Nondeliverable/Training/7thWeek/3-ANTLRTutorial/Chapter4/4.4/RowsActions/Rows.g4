grammar Rows;

@parser::members { // add members to RowsParser
    int col;
    public RowsParser(TokenStream input, int col) { // custom constructor
        this(input);
        this.col = col;
    }
}
file    :   (row NL)+ ;

row
locals [int i=0]
        : (     STUFF
                {
                $i++;
                if ($i == col) System.out.println($STUFF.text);
                }
          )+
        ;

TAB     :   '\t' -> skip ; // match but don't pass to parser
NL      :   '\r'? '\n' ; // newline
STUFF   :   ~[\t\r\n]+ ; // any except tab, newline
