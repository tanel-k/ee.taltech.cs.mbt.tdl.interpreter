### Inputs

---

We expect the following to be provided by the user:

* TDL<sup>TP</sup> expression;
* Uppaal model M<sup>SUT</sup> in XML format.

#### Expectations on Input

We expect the following from user input:

* TDL<sup>TP</sup> expression is valid;
* TDL<sup>TP</sup> expression involves trapsets that are "defined" in terms of edges in M<sup>SUT</sup>.

### Outputs

---

We produce the following as a result of processing provided inputs.

* Uppaal test model M<sup>TEST</sup> (parallel composition of system model M<sup>SUT</sup>,  test stopwatch model M<sup>SW</sup>, operation automata model M<sup>OP</sup>) in XML format.

### Facilities Needed for Processing Inputs

---

We need the following capabilities to handle inputs:

* ability to parse TDL<sup>TP</sup> expressions and traverse the resulting parse tree;
* ability to parse Uppaal model XML:
  * ability to retrieve global declarations;
  * ability to retrieve templates;
  * ability to retrieve an automaton from a template;
  * ability to retrieve locations from automaton;
  * ability to retrieve edges from automaton;
  * ability to retrieve and parse variable assignments assigned to edges;
  * ability to retrieve variable declarations;
  * ability to retrieve and parse the system declaration.

### Facilities Needed for Producing Output

---

We need to following capabilities to produce user-expected output:

* ability to construct unique variable names;
* ability to modify Uppaal model XML format in memory:
  * ability to define global variables (broadcast channels, *Boolean* arrays, clocks, counters);
  * ability to add variable assignments to edges;
  * ability to add channel references to an edge;
  * ability to add locations that split edges;
  * ability to add automaton templates;
  * ability to define the locations in an automaton;
  * ability to define edges of an automaton;
  * ability to update assignments, type, channel references and conditions of an edge;
  * ability to add an invariant to a location;
  * ability to add a process to the system declaration.
* ability to simplify TDL<sup>TP</sup> expressions in memory:
  * ability to push down the negation operation (*not*);
  * ability to determine empty trapsets;
  * ability to recognize structures for which simplification is applicable;
  * ability to apply a simplification rule to an expression.
* ability to walk the parse tree of a *simplified* TDL<sup>TP</sup> parse tree and construct templates for recognizing automata.

### Nice to have

---

These are items that are not critical but enhance user experience or otherwise improve the quality of the deliverable:

* a nice user interface for editing TDL expressions and running the interpreter on them;
* logic for prettifying automata templates (no overlap of edges; assignments and other "labels" clearly visible) (in terms of scope this is actually huge);
* additional simplification rules (*may be needed for qualifying for an "A" grade*);
* validation of the test model (using *bisimulation*) (per comments in #13 this should actually be fairly doable).

### Programmatic Flow

---

Logical flow activated by user input (abstract description):

1. User provides Uppaal XML (`modelXml`) and TDL<sup>TP</sup> expression (`rootExpression`);
2. `rootExpression` is validated;
3. negations in `rootExpression` are pushed to the ground level (`negationNormalizedExpression`);
4. Empty set reduction is performed:
   * Parsing of `negationNormalizedExpression` is performed to determine trapset expressions;
   * `modelXml` is parsed into memory to produce a `modelObject`;
   * trapset expressions are checked against `modelObject` to determine if any are empty;
   * empty sets are used to simplify `negationNormalizedExpression` into `simplifiedExpression`.
5. Simplification rules are applied to `simplifiedExpression` to further simplify it;
6. We begin to traverse the parse tree of `simplifiedExpression` starting from the root:
   * at each non-trapset-expression node, create a recognizing automaton:
     * establish upstream link (if not root node):
       * get the channel name for receiving activation information from upstream expression;
       * get the channel name for sending success information to upstream expression.
     * establish downstream links*:
       * create channels for sending activation information to downstream expression(s);
       * create channels for receiving success information from downstream expression(s).
     * pass downstream channel names to next level below current*
     * *if the nodes at the next-level are not trapset-expression nodes, in which case we need to *receive* downstream channel names from those nodes;
   * at each trapset-expression node, update `modelObject`:
     * apply labeling rules according to the type of expression;
     * remove simple labels from `modelObject`;
     * split edges with trapset labels in two with a connecting committed location:
       * predecessor edge will have the original label;
       * successor edge will have a broadcast channel for sending information upstream;
     * add reset function calls to the return-to-*Idle* edge of the automatons of parent expressions.
   * when we're done with the parse tree, we create a stopwatch template and link it with the root of the parse tree using one downstream and one upstream channel;
   * we update the global declarations with all the variables we needed to create parse tree node recognizers;
   * we update the system declaration and add processes for recognizers and the stopwatch.
7. We serialize the completed `modelObject` into XML, producing `testModelXML`.

#### Enhancements of Programmatic Flow

Need to add diagnostic information per *Section 8* in the article.
In the initial phase of implementation, this is considered nice-to-have.

#### Problems with Programmatic Flow

Based on initial review, the following issues become evident.

##### Trapset expression Equivalence

The same trapset can be used more than once throughout an expression, for example A(**TS**<sub>**1**</sub>; **TS**<sub>**2**</sub>) &rarrc; E(**TS**<sub>**1**</sub>; **TS**<sub>**2**</sub>).

This is the reason why broadcast channels should be used for trapset-expression edges in `modelObject`.
Somehow we need to ensure that recognizing automatons at the layer just above the trapset-expression layer will be forced to use the same broadcast channels if they refer to the same trapset-expression.

This can be achieved by:

1. Providing a reference to the ancestor expression representation-object to successor lower levels;
2. Walking through the trapset-expression layer after all the upper layers are "ready";
3. Retaining only unique trapset-expressions and providing them references to all "user" nodes at the ancestor level;
4. Modifying nodes at the ancestor layer so that they use the correct downstream broadcast channels.

If we want to implement it this way we will need to create the templates only *after* the full expression parse tree has been traversed and processed (meaning we need to keep representative objects in memory until we are sure the model object is ready for serialization).

##### Simplification

At this point it is relatively unclear how to best implement simplification rules so that the result isn't a simple string-matching operation. This will not be trivial but is crucial. Probably we can leverage the parse tree representation - but how do we create a new parse tree after simplification?

This will probably prove to be the most significant part, perhaps even the highlight, of the thesis.

### Component Overview (Preliminary)

Note that some of these components can be written into a single artifact.
All of the information below is subject to change when problems occur during implementation.

| ID   | Component                                           | Implementation notes                                         | Tech                  | Deps                      | Ticket?  |
| ---- | --------------------------------------------------- | ------------------------------------------------------------ | --------------------- | ------------------------- | -------- |
| 0    | TDL<sup>TP</sup> grammar and base parser            | Parses and validates strings that represent TDL<sup>TP</sup> expressions. | Java, ANTLR4          | N/A                       | #24      |
| 1    | TDL<sup>TP</sup> expression object model            | An independent model for parse trees of TDL expressions as well as tree walking facilities. | Java                  | N/A                       | #25      |
| 2    | TDL<sup>TP</sup> expression parser                  | We need to use the base parser (0) to construct a model of the expression (1), free from ANTLR4-related details. | Java                  | 0, 1                      | #26      |
| 3    | TDL<sup>TP</sup> expression object model facilities | Should provide facilities for inspecting and modifying the object representations of TDL  expressions (1). | Java                  | 1                         | #30, #31 |
| 4    | Uppaal system object model                          | An independent model for representing Uppaal projects.       | Java                  | N/A                       | #27      |
| 5    | Uppaal system  parser/serializer                    | Parses Uppaal XML projects and produces corresponding object representations (4).<br />Provides facilities for serializing said object representations. | Java, Dom4j? libutap? | 4                         | #28      |
| 6    | Uppaal system object model facilities               | Provides facilities for inspecting and modifying the object representation of an Uppaal model. | Java                  | 4                         | #30, #31 |
| 7    | Test specification object model                     | We need this to have a representation of the recognizer objects (and other similar artifacts) needed to produce a test model from the Uppaal object model and  the TDL object model. | Java                  | 1, 4                      | #29      |
| 8    | Test specification object model facilities          | Provides facilities for creating a test spec object model. Should expose trapset expression logic for (9). | Java                  | 1, 4, 7                   | #30, #31 |
| 9    | TDL<sup>TP</sup> expression simplification library  | Uses (8) to perform empty set simplification and higher-level simplification on the expression object model (1). | Java                  | 1, 4, 7, 8                | #30, #31 |
| 10   | TDL<sup>TP</sup> interpreter                        | Parses (2, 5) Uppaal system, TDL<sup>TP</sup> expression into object representations (1, 4).<br />Performs simplification using the simplification library (9).<br />Walks the parse tree of the simplified expression to construct the test model (7) using test spec object model facilities (8).<br />Serializes the test model using the Uppaal object model serializer (5). | Java                  | 1, 2, 3, 4, 5, 6, 7, 8, 9 | #31      |
| 11   | TDL<sup>TP</sup> interpreter UI                     | Nice-to-have                                                 | ?                     | 10                        | N/A      |
