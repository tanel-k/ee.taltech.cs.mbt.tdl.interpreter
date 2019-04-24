# What Questions Should a Problem Statement Answer

A problem statement defines the context and purpose of a bachelor's thesis. A reasonable statement should provide a cursory answers for the following action items:

* Preliminary verbiage of the subject of the thesis;
* Who will be instructing the thesis;
* A clearly defined problem, for which knowledge from the domain of the student's major is required;
* Clearly defined goals and expected results;
* Methodology for:
  * How we plan to achieve the set goals;
  * How we plan to validate/confirm the set goals;
* Some sources that will be used.

# What Needs to be Done

By March 1st we must present a roughly 1 page problem statement in PDF format.

The graders will use the following criteria to assess the subject:

1. Is it clear what is to be done as part of the thesis?
2. Are goals and expected results clear?
3. Is the student aware of the background and alternative solutions?
4. Are the sources appropriate and timely?
5. Is there a description for how we plan to achieve the goals?
6. How do you plan to test whether the results are adequate?
7. How do you plan to make and reason technological choices?
8. How actual/new is the problem?
9. Is the solution realistic?
10. How complicated is the assignment (easy/medium/hard)?
11. Is the subject appropriate for a bachelor's thesis?
12. What could the student do to make the problem statement even better?

# Notes Provided by the Instructor

* **Subject:** "Implementation and Validation of the Test Scenario Specification Language TDL<sup>TP</sup> Interpreter";
* **Instructor:** Jüri Vain;
* **Problem that needs knowledge acquired through studies:** In order to interpret TDL<sup>TP</sup> expressions, an optimizing parser is to be constructed. As a result of parsing, an Uppaal Timed Automata (UTA) composition is synthesized which generates test sequences according to TDL<sup>TP</sup> expressions.
* **Goals and expected results:** Create a TDL<sup>TP</sup> interpreter, which parses TDL<sup>TP</sup> expressions, simplifies them and transforms test scenario specified via the aforementioned expressions into test sequence generating UTA compositions. The generated UTA models are presented in an XML format that is accepted by the Uppaal model checking tool.
* **Plan for achieving goals:**
  * Work with literature;
  * Regular meeting with instructor(s).
* **Checking the results for suitability; criteria/methodology for validation:** The interpreter is planned as a prototype so there are no direct efficiency requirements. What is important is that the generated test models are functionally correct. To test this, we plan to to present constraints that are semantically equivalent with TDL<sup>TP</sup> expressions in Uppaal's query language (TCTL). By comparison of the generated test sequences we are able to check the functional correctness of the TDL<sup>TP</sup> interpreter.
* **How new/actual is the subject?** The subject is to implement an original test generation method based on the test scenario specification language TDL<sup>TP</sup>. The result will find use in a test environment prototype for the model-based testing of cyber-physical systems.
* **Is the planned solution realistic?** The assignment presumes good knowledge of the principles of the operational semantics of TDL<sup>TP</sup> and the principles of model checking with Uppaal timed automata. Good programming skills will make coming up with a solution realistic.
* **Is the problem suitable for a bachelor's degree?** The problem is suitable for a master's degree. It presumes that the student shall acquire knowledge on model checking, model-based testing and compiler theory.

Source material (e-mail exchange):

>Töö teema esialgne sõnastus:
>Implementation and validation of the test scenario specification language TDLTP interpreter.
>Testistsenaariumi kirjelduskeele TDLTP interpretaatori programmeerimine ja valideerimine
>
>- Töö juhendaja: Jüri Vain, (Evelin Halling?) - Lahendatav probleem, mille lahendamiseks on vaja erialal omandatud teadmisi;
>  TDLTP avaldiste interpreteerimiseks tuleb koostada optimeeriv parser, parsimise tulemusena sünteesitakse TDLTP avaldistele vastavaid testijadasid generereeriv Uppaali ajaga automaatide (UTA) kompositsioon.
>- Selgelt püstitatud eesmärgid ja oodatav tulemus:
>  Luua TDLTP interpretaator, mis parsib TDLTP avaldisi, lihtsustab neid ja teisendab avaldistega spetsifitseeritud testistsenaariumid neid testijadasid genereerivate UTA kompositsiooniks. Genereeritud UTA mudelid esitatakse Uppaali mudelkontrolli vahendile sobivas xml vormingus.
>- Tööplaan ja kriteeriumid, kuidas plaanitakse eesmärke saavutada:
>- Töö kirjandusega
>- Regulaarsed kohtumised juhendaja(te)ga
>  …
>- Töö tulemuste sobivuse kontrollimise ja valideerimise kriteeriumid ning metoodika:
>  Loodav interpretaator on kavandatud prototüübina ja otseseid jõudlusnõudeid sellele ei ole. Oluline on, et genereeritavad testimudelid on funktsionaalselt korrektsed. Selle testimiseks on kavas esitada TDLTP avaldistega semantiliselt ekvivalentsed kitsendused Uppaali nn tingimuslike trap-muutujate ja mudelkontrollija päringute keele TCTL kitsendustena. Genereeritud testijadade võrdluse abil saab kontrollida TDLTP interpretaatori implementatsiooni funktsionaalset korrektsust.
>- mõned allikad ja kirjandusviited millele tuginetakse. - Hindajad lähtuvad seisukoha kujundamisel järgmistest küsimustest, aga ei pruugi neid kõiki kommenteerida: - Kas on selge, mida töös teha plaanitakse? - Kas on püstitatud töös saavutatavad eesmärgid ja oodatav tulemus? - Kas tudeng on teadlik taustast ja alternatiivsetest lahendustest? - Kas viidatud allikad on sobilikud, asjakohased ja ajakohased? - Kas on kirjeldatud, kuidas plaanitakse eesmärke saavutada? - Kuidas plaanitakse kontrollida, kas saavutatud tulemus on adekvaatne? Kas on mainitud võrdlusmomente?
>- Valideerime
>- Kuidas plaanitakse teha ja põhjendada vajalikke tehnoloogilisi valikuid? - Kui aktuaalne/uudne teema on?
>  Teema käsitleb originaalse testigenereerimise meetodi implementeerimist testistsenaariumide spetsifitseerimise keele TDLTP baasil. Tulem leiab rakendamist küberfüüsikaliste süsteemide mudelipõhise testimiskeskkonna prototüübis.
>- Kas planeeritav lahendus on realistlik?
>  Ülesanne eeldab keele TDLTP operatsoonilise semantika, Uppaali ajaga automaatide ja mudelkontrolli põhimõtete head mõistmist. Samuti on oluline hea programmeerimisoskus.
>  Nende eelduste täitmise korral on lahenduse väljatöötamine realistlik. - Kui keeruline ülesanne on (skaalal lihtne / keskmine / keerukas)? - Kas ülesanne on sobiv bakalaureusetöö raames lahendamiseks?
>  Ülesanne sobib magistritööks ja väga tugeva teoreetilise ja praktilise taustaga bakalaureuse üliõpilasele. Teema eeldab lisaks bakalaureuse õppekavas õpetatavatele kursustele mahuka lisamaterjali omandamist sh mudelkontrolli, mudelipõhise testimise ja kompilaatorite teooria alused.
>  Mida võiks tudeng teha, et ülesandepüstitus oleks veel parem?