//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*

*/
A[] x > 3 imply not observer.taken

/*

*/
A[] not deadlock

/*
The observer can only be idle if clock x <= 3.
*/
A[] observer.idle imply x <= 3

/*
It is possible to take the transition when x is between 2 and 3 (upper bound is checked with the above query).
*/
E<> observer.idle and x > 2

/*
The transition is taken when x is between 2 and 3 (after a delay between 2 and 3).
*/
A[] observer.taken imply (x >= 2 and x <=3)

/*
It is possible for the observer to be idle and clock x to be greater than 3.
We check that we may delay at least 3 time units between resets.

*/
E<> observer.idle and x > 3

/*
For all reachable states, being in the location obs.taken implies that clock x >= 2.
*/
A[] observer.taken imply x >= 2
