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
          if(numerator == 0) {
            numerator = 1;
            System.out.println("0 ist kein valider Zähler. Der Zähler wurde auf 1 gesetzt.");
        }
        if(denominator == 0) {
            denominator = 1;
            System.out.println("0 ist kein valider Nenner. Der Nenner wurde auf 1 gesetzt.");
        }
        int gcd = gcd(numerator,denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd ;
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

    /**
     * Findet den größten gemeinsamen Teiler
     * @param a Erste Zahl für die ein gemeinsamer Teiler gefunden werden soll.
     * @param b Zweite Zahl für die ein gemeinsamer Teiler gefunden werden soll.
     * @return Gibt den größten gemeinsamen Teiler zurück.
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b , a%b);
        }
    }
}
