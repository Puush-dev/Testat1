import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Test der Klasse Fraction
 */
public class TestFraction {
    /**
     * Anzahl aufgetretener Fehler
     */
    private int anzahlFehler;

    /**
     * @return Anzahl aufgetretener Fehler
     */
    public int getAnzahlFehler() {
        return anzahlFehler;
    }

    /**
     * Testet die Multiplikation mit ganzen Zahlen
     */
    void testMultiplyInt() {
        Fraction frac = new Fraction(1, 2);

        assertBool(frac.multiply(0).getNumerator() == 0, "Fehler in testMultiplyInt #1");
        assertBool(frac.multiply(1).getNumerator() == 1, "Fehler in testMultiplyInt #2");
        assertBool(frac.multiply(2).getNumerator() == 2, "Fehler in testMultiplyInt #3");
    }

    /**
     * Testet die Multiplikation mit einem anderen Bruch
     */
    private void testMultiply() {
        Fraction frac1 = new Fraction(1, 2);
        Fraction frac2 = new Fraction(3, 4);

        assertBool(frac1.multiply(frac2).getNumerator() == 3 && frac1.multiply(frac2).getDenominator() == 8, "Fehler in testMultiply");
    }

    /**
     * Testet die Multiplikation mit mehreren anderen Brüchen
     */
    private void testMultiplyMulti() {
        Fraction frac1 = new Fraction(1, 2);
        Fraction frac2 = new Fraction(3, 4);
        Fraction frac3 = new Fraction(5, 6);

        assertBool(frac1.multiply(frac2, frac3).getNumerator() == 15 && frac1.multiply(frac2, frac3).getDenominator() == 48, "Fehler in testMultiplyMulti");
    }

    /**
     * Testet die Division mit einem anderen Bruch inkl. Sonderfall mit 0 im Zähler des Divisors.
     */
    private void testDivide() {
        Fraction frac1 = new Fraction(1, 2);
        Fraction frac2 = new Fraction(3, 4);
        Fraction frac3 = new Fraction(0, 4);

        assertBool(frac1.divide(frac2).getNumerator() == 4 && frac1.divide(frac2).getDenominator() == 6, "Fehler in testDivide #1");
        assertBool(frac1.divide(frac3) == null , "Fehler in testDivide #2");
    }

    /**
     * Testet die toString Methode
     */
    private void testToString() {
        Fraction frac = new Fraction(1,2);

        assertString(frac.toString(), "Fehler in testToString");
    }

    /**
     * Führt alle Test nacheinander aus
     */
    public void testAll() {
        this.testMultiplyInt();
        this.testMultiply();
        this.testMultiplyMulti();
        this.testDivide();
        this.testToString();
    }

    /**
     * Testet einen booleschen Ausdruck und aktualisiert die Anzahl der Fehler
     *
     * @param statement Ausdruck der ueberprueft werden soll
     * @param errorMsg Fehlermeldung
     */
    private void assertBool(boolean statement, String errorMsg) {
        if(!statement) {
            this.anzahlFehler++;
            System.out.println(errorMsg);
        }
    }

    /**
     * Testet einen String auf ein Muster
     *
     * @param statement Ausdruck der ueberprueft werden soll
     * @param errorMsg Fehlermeldung
     */
    private void assertString(String statement, String errorMsg) {
        Pattern p = Pattern.compile("\\d+\\/\\d+");
        Matcher m = p.matcher(statement);

        if(!m.find()) {
            this.anzahlFehler++;
            System.out.println(errorMsg);
        }
    }

    public static void main(String[] args) {
        System.out.println("Starte Tests...");
        TestFraction test = new TestFraction();
        test.testAll();
        System.out.println(test.getAnzahlFehler() + " Fehler in den Tests gefunden.\nTests abgeschlossen.");
    }
}
