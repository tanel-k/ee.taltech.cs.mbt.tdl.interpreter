//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*
Is it possible to reach a state where the observer is idle and the time is greater than 3.
*/
E<> o.idle and clk > 3

/*
Check for deadlock.

*/
A[] clk > 3 imply not o.taken

/*
Upper bound is respected (invariant needed: x <= 3).
*/
A[] o.idle imply clk <= 3\


/*
It is possible to take the transition with clk in (2, 3].

*/
E<> o.idle and clk > 2 and clk <= 3

/*
Transition must occur when clk is in [2, 3].
*/
A[] o.taken imply (clk >= 2 and clk <= 3)

/*
All fall-down of the clock value are above 2.

*/
A[] o.taken imply clk >= 2
