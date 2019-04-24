@Juri.Vain @Evelin.Halling 

I think I more-or-less understand what needs to be done and why.
However, there are a few questions that should be answered before I proceed with the implementation.

Question 1: Elementary vs conditional traps: User perspective
---
In *Section 3*, it is claimed  that a trap can be either elementary (`tr = true`) or conditional (`tr = <BooleanExpression>`).

The Boolean expression in a conditional trap may have its arguments range over variables and constants in M<sup>SUT</sup> and auxiliary constants and variables in the test purpose spec (other traps, event counters etc).
In *Section 1* is also claimed that the first phase of generating a test model involves labeling TCIs (edges in M<sup>SUT</sup>) with traps.

At this point I'm lead to believe that the user can freely choose between elementary and conditional traps when they label TCIs.

However, in *Section 6* (and in *Section 4* where we define a labeling function provided by the user), we effectively restrict the user's usage of traps:
> [...] trapset formulas are implemented by labeling operations such as relative or absolute complement.<br/>
> Only trapset formulas can be universally or existentially quantified. No quantifier nesting is allowed.<br/>
> Since the validity of the root formula can be calculated using only the truth value(s) of the highest level trapset expression(s) in the parse tree, all trapsets closer to the ground level trapset along the parse tree's sub-branch can be removed from the labeling of the SUT model.<br/>
> This reduction can be done after labeling the SUT model and applying all the trapset operations.

Basically this simplification means elementary trap labels (user-provided) can be removed since the trapset operation labels added during the interpretation of a TDL<sup>TP</sup> expression already encode information about them.<br/>
Conditional traps, however, should not be eligible for this simplification as their Boolean expression conditions are lost in *Section 5.1* where the mapping of trapset expressions to M<sup>SUT</sup> is explained. (Those mappings assume elementary traps.)<br/>
Overall it is unclear how conditional trap information can be carried over to trapset expression labeling.

It's my assumption that the reason conditional traps were mentioned in *Section 3* is that the process of interpreting a TDL<sup>TP</sup> expression may involve the creation of such traps (f.ex. in mapping *M3* from *Section 5.1*).<br/>
The user should only use elementary traps to cover TCIs (edges in M<sup>SUT</sup>).

Question 2: User-friendliness and trapset names
---
In *Section 3* we define the syntax for TDL<sup>TP</sup>.

The BNF suggests that trapsets be labeled `TR<some number>`.

From my perspective, this seems like it can cause a headache when the user tries to interpret the simulation trace or even the templates we add to the test model.

In coding it is a well-known guideline that variable names should remind the user of the meaning of the variable.<br/>
While I understand that we need some specific structure for trapset names since they will be mixed with M<sup>SUT</sup>-specific update expressions, I would still suggest a more loose syntax restriction here.<br/>
Perhaps `TR<some number><identifier string>` where the identifier string can be a standard variable name that does not start with a number? <br/>
Since Uppaal has no variable name length restriction we can use this to have more intuitive flag/channel names for higher-level operation templates.

Question 3: Linked pair of trapsets (M3)
---
In *Mapping M3* of *Section 5* I noticed the use of `TS(TS1; TS2)[j] = (flag(TS1;TS2) ? true; false)`.

Isn't the ternary assignment here actually equivalent to `TS(TS1; TS2)[j] = flag(TS1; TS2)`?

The only reason I can see that we would use the ternary instead of simply copying the value is that Uppaal doesn't allow such assignments (and copies a pointer to the flag variable instead of the value of said var).

Question 4: Why are we performing logical simplification so "late"?
---
In Section 6 we describe some basic simplifications that can make the state space for model checking smaller.

Due to the positioning of this section I'm lead to believe that logical simplification occurs after:
* the labeling of trapset expressions is added to M<sup>SUT</sup>;
* property recognizing automata are built in their basic forms;
* simple trapset labels (added by the user) are removed.

This is a bit confusing since the original expression can change during logical simplification.

That, in turn, means we have to either modify or remove recognizing automata from the test model.

In my opinion such modifications would consume too much time.

I understand that after the three stages listed above we can tell if certain trapset expressions map to empty sets so we can use `false` in their stead in higher-level operations, but my hunch is that we can tell this the moment we are done labeling trapset expressions in the model.<br/>
I propose we simplify the expression before starting to output expression recognizing automata.

Question 5: Possibly incorrect conditional repetition simplification rule in *(14)*
---
This has to do with the meaning of #p &#10683; n with &#10683; ∈ {&lt;, &le;, &ge;, &gt;, =}.

Is it a simple statement about the number of occurrences of p in the trace?

Or is it a statement about the number of occurrences of p in the trace **since the last time we successfully considered the number of occurrences of p in the trace** (as *Figure 14 f)* would lead me to believe with its counter reset update on the back edge to *Idle* - see *Question 7* for details).

If it is the former, then we have an error:<br/>
In *Section 6, (14)* we present the following simplification rule:<br/>
#p &#10683; n<sub>1</sub> &#10547; #p &#10683; n<sub>2</sub> &equiv; #p &#10683; (n<sub>1</sub> + n<sub>2</sub>) if &#10683; in {&ge;, &gt;, =}

Let's break this apart:
1) #p = n<sub>1</sub> &#10547; #p = n<sub>2</sub> &equiv; #p = (n<sub>1</sub> + n<sub>2</sub>)<br/>
Counter-example: If n<sub>1</sub> = n<sub>2</sub> &ne; 0, then #p = n<sub>1</sub> ~> #p = n<sub>2</sub> is not equivalent to #p = n<sub>1</sub> + n<sub>2</sub> = 2 * n<sub>1</sub>
2) #p &gt; n<sub>1</sub> &#10547; #p &gt; n<sub>2</sub> &equiv; #p &gt; (n<sub>1</sub> + n<sub>2</sub>)<br/>
Counter-example:
Assume max(#p) = n<sub>3</sub> (maximum number of occurences) and n<sub>3</sub> &gt; n<sub>1</sub> and n<sub>3</sub> &gt; n<sub>2</sub> but n<sub>3</sub> &lt; (n<sub>1</sub> + n<sub>2</sub>).
Then #p &gt; n<sub>1</sub> &#10547; #p &gt; n<sub>2</sub> is true while #p &gt; (n<sub>1</sub> + n<sub>2</sub>) is not.
3) #p &ge; n<sub>1</sub> &#10547; #p &ge; n<sub>2</sub> &equiv; #p &ge; (n<sub>1</sub> + n<sub>2</sub>)<br/>
Counter-example is similar to 2).

I propose an alternative simplification rule:<br/>
#p &#10683; n<sub>1</sub> &#10547;#p &#10683; n<sub>2</sub> &equiv; #p &#10683; max({n<sub>1</sub>, n<sub>2</sub>}) if &#10683; in {&gt;, &ge;, =}.

If the meaning I assumed to be true is not correct, then the original simplification rule is correct.

Question 6: Meaning of "non-trapset formula automaton"
---
In *Section 7 phase 2* we have the following:
> Each non-trapset formula automaton will be extended with a wrapping construct [...].<br/>
> The wrapper has one or two channel labels, depending on whether the sub-formula operation is unary or binary, to synchronize its state transition with those of its child expression(s).<br/>
> [...]<br/>
> Similarly two broadcast channels are introduced to synchronize the state transition of sub-formula automata with their upper operation automata.

Looking at the examples, it seems the upwards channels are added to all formulae templates (except the root) not just "non-trapset formula automatons".<br/>
The reason for the two phases is clear but I'm simply confused by the verbiage "non-trapset formula automaton".


Question 6: `Reset()` function is not explained in Section 7
---
In *Section 7 phase 2* we mention `Reset` functions which are not explained in detail.<br/>
I can see that they are only added to property automatons that have trapset expressions as operands.<br/>
My best guess is that they reset the values of the Boolean arrays that map to the trapset expressions?

Question 7: Why is the repetition counter reset when the conditional repetition recognizer returns from its terminal location to the *Idle* location?
---
In *Section 7, Figure 14 2)* we show the extension of the conditional repetition sub-formula that is the result of composing the model for the test supervisor.<br/>
This question has to do with the counter reset (`i = 0`) that is added to the edge from location *End* to location *Idle*.

Let's take this simple TDL<sup>TP</sup> expression as an example:<br/>
`# E(!TS) > 2 ~> # E(!TS) > 4`

Here is the way I would interpret this toy example.
> Any edges not labeled with traps of TS being visited more than 2 times will lead to any of those edges being visited more than 4 times (total).

If we reset the counter, however, the meaning changes:
> Any edges not labeled with traps of TS being visited more than 2 times will lead to any of those edges being visited more than 4 "additional" times **since the last time they were visited more than 2 times**.

Which interpretation is correct?<br/>
Which interpretation is more intuitive?
