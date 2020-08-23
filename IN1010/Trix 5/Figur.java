/**
* Grensesnittet <code>Figur</code> gir metoder for å
* beregne areal og omkrets.
*/
public interface Figur {

    /**
    * Beregner en figurs areal.
    * @return figurens areal.
    */
    public double beregnAreal();

    /**
    * Beregner en figurs omkrets.
    * @return figurens omkrets.
    */
    public double beregnOmkrets();
}
