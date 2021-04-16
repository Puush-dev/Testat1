/**
 * Repräsentiert einen Bruch
 *
 * Dabei wird eine Multiplikation und Division als Operation unterstützt.
 *
 */
public class Fraction {

    /**
     * Repräsentiert den Zähler eines Bruchs
     */
    private int numerator;

    /**
     * Repräsentiert den Nener eines Bruchs
     */
    private int denominator;

    /**
     * @param numerator Zähler des Bruchs
     */
    public Fraction(int numerator){
        this(numerator, 1);
    }

    /**
     * @param numerator Zähler des Bruchs
     * @param denominator Nenner des Bruchs
     */
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;

        if(denominator == 0) {
            denominator = 1;
            System.out.println("0 ist kein valider Nenner. Der Nenner wurde auf 1 gesetzt.");
        }

        this.denominator = denominator;
    }

    /**
     * @return Zähler des Bruches
     */
    public int getNumerator() {
        return numerator;
    }
    /**
     * @return Nenner des Bruches
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Multipliziert den Bruch mit einem Faktor
     *
     * @param factor Ganzzahlige Faktor der mit dem aktuellen Bruch multipliziert werden soll
     * @return liefert einen Bruch mit dem Ergebnis
     */
    public Fraction multiply(int factor) {
        return new Fraction(numerator * factor,denominator);
    }

    /**
     * Multipliziert den Bruch mit einem anderen
     *
     * @param factor Bruch mit dem der aktuelle Bruch multipliziert werden soll
     * @return liefert einen Bruch mit dem Ergebnis
     */
    public Fraction multiply(Fraction factor) {
        return new Fraction(numerator * factor.numerator, denominator * factor.denominator);
    }

    /**
     * Multipliziert eine beliebige Anzahl an Brüchen
     *
     * @param factors Brüche die mit dem aktuellen Bruch multipliziert werden sollen
     * @return liefert einen Bruch mit dem Ergebnis
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
     * Dividiert den Bruch mit einem anderen
     *
     * @param divisor Bruch durch den der aktuelle Bruch dividiert werden soll
     * @return liefert einen Bruch mit dem Ergebnis
     */
    public Fraction divide(Fraction divisor) {
        if(divisor.getNumerator() == 0){
            System.out.println("Bei der Division darf der Zähler vom Divisor nicht 0 sein");
            return null;
        }
        return new Fraction(numerator * divisor.denominator, denominator * divisor.numerator);
    }

    /**
     * Formatierte Darstellung eines Bruches als String
     *
     * @return Darstellung des Bruches als String
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
