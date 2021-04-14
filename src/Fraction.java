/**
 * Die Klassen bildet einen Bruch ab.
 */
public class Fraction {
    /**
     * Der Zähler vom Bruch.
     */
    public int numerator;
    /**
     * Der Nenner vom Bruch.
     */
    public int denominator;

    /**
     *  Getter für Numerator
     * @return Gibt den Numerator zurück
     */
    public int getNumerator() {
        return numerator;
    }
    /**
     * Getter für Denominator
     * @return Gibt den Denominator zurück
     */
    public int getDenominator() {
        return denominator;
    }

    /** Konstruktur mit einem Parameter
     * Der Nenner im Bruch wird mit 1 initialisiert
     * @param numerator Gibt den Zähler im Bruch an
     */
    public Fraction(int numerator){
        this(numerator, 1);
    }

    /**  Konstruktur mit zwei Parameter
     * @param numerator Gibt den Zähler im Bruch an
     * @param denominator Gibt den Nenner im Bruch an
     */
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0) {
         denominator = 1;
         System.out.println("0 ist ein valider Nenner ! Der Nenner wurde auf 1 gesetzt.");
        }
        this.denominator = denominator;
    }

    /**
     * Erzeugt einen neuen Bruch der das Ergebnis von Übergabeparameter mal dem Bruch enthält
     * @param factor Ein ganzzahlige Faktor der mit dem aktuellen Bruch multipliziert werden soll.
     * @return Gibt den Bruch mit dem Ergebnis der multiplikation zurück.
     */
    public Fraction multiply(int factor){
        return new Fraction(numerator * factor,denominator);
    }

    /**
     * Erzeugt einen neuen Bruch der das Ergebnis von Übergabeparameter mal dem Bruch enthält.
     * @param factor Der Bruch der mit der aktuellen Bruch multipliziert werden soll.
     * @return Gibt den Bruch mit dem Ergebnis der multiplikation zurück.
     */
    public Fraction multiply(Fraction factor){
        return new Fraction(numerator * factor.numerator, denominator * factor.denominator);
    }

    /**
     * Erzeugt einen neuen Bruch der das Ergbenis von dem aktuellen Bruch geteilt durch den Übergabeparameter.
     * @param divisor Der Bruch durch den der aktuelle Bruch dividiert werden soll.
     * @return  Gibt den Bruch mit dem Ergebnis der division zurück.
     */
    public Fraction divide(Fraction divisor){
        if(divisor.getNumerator() == 0){
            System.out.println("Bei der Division darf der Zähler vom Divisor nicht 0 sein");
            return null;
        }
        return new Fraction(numerator * divisor.denominator, denominator * divisor.numerator);
    }

    /**
     * Erzeugt einen neuen Bruch der das Ergebnis von den Übergabeparametern mal dem Bruch enthält.
     * Dabei können beliebig viele Parameter Übergeben werden.
     * @param factors Die Brüche die mit dem aktuellen Bruch multipliziert werden sollen.
     * @return  Gibt den Bruch mit dem Ergebnis der multiplikation zurück.
     */
    public Fraction multiply(Fraction... factors){
        int newNumerator = this.numerator, newDenominator = this.denominator;
        for (Fraction factor : factors) {
            newNumerator *= factor.numerator;
            newDenominator *= factor.denominator;
        }
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Ermöglicht den aktuellen Bruch als Text auszurgebe
     * @return Gibt den Bruch in Textform zurück.
     */
    public String toString(){
       return numerator + "/" + denominator;
    }

}
