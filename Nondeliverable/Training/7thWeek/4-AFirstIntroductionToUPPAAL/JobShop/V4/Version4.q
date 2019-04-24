//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*

*/
E<> now < 127 && (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*
Finding the slowest scheduling solution using approximation.
There is no option to compute the slowest execution leading to a certain state.

*/
A[] now >= 127 imply (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*

*/
A[] now >= 110 imply (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*

*/
A[] now >= 150 imply (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*

*/
A[] now >= 200 imply (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*

*/
E<> (Belt.end && Jobber(0).begin && Jobber(1).begin)\


/*
A[]: "in all reachable states it is the case that"
*/
A[] not deadlock

/*
UPPAAL can provide a diagnostic trace for E<> properties that hold and for A[] properties that do not hold.
In the case of E<> properties that do not hold or A[] properties that hold, UPPAAL can only report that it exhaustively checked all the reacahable states of the model and didn't find anything.

*/
E<> (Jobber(0).work_avg_mallet && Jobber(1).work_avg_hammer)\


/*

*/
A[] Hammer(0).taken == (Jobber(0).work_avg_hammer || Jobber(0).work_hard || Jobber(1).work_avg_hammer || Jobber(1).work_hard)

/*

*/
A[] Mallet(0).taken == (Jobber(0).work_avg_mallet || Jobber(1).work_avg_mallet)

/*
E<>: "There exists a reachable state such that"
*/
E<> (Jobber(0).work_hard && Jobber(1).work_hard)
