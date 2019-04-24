//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*
Possible to wait in S1 of p2.
*/
E<> p2.S1 and p2.clk > 0

/*
Possible to wait in S1 of p0.
*/
E<> p0.S1 and p0.clk > 0

/*
Cannot wait in S1 of p0.

*/
A[] p0.S1 imply p0.clk == 0

/*
Cannot wait in S1 of p2.

*/
A[] p2.S1 imply p2.clk == 0

/*
Cannot wait in S1 of p1.

*/
A[] p1.S1 imply p1.clk == 0

/*
Possible to wait in S1 of p1.
*/
E<> p1.S1 and p1.clk > 0
