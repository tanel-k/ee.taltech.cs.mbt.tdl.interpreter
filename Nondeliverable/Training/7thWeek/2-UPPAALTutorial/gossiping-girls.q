//This file was generated from (Commercial) UPPAAL 4.0.14 (rev. 5615), May 2014

/*
All girls know all secrets.
*/
E<> forall(i: girl_t) forall(j: girl_t) (Girl(i).secrets & (1 << j))

/*

*/
A[] not deadlock
