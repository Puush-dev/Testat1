
class FractionTest {
    /**
     * Enthaelt die Anzahl der Fehler ueber alle Tests die durchgefuehrt
     * wurden
     */
    private int anzahlFehler = 0;

    public static void main(String[] args) {
        System.out.println("Starte Tests");
        FractionTest test = new FractionTest();
        test.testAll();
        System.out.println(test.anzahlFehler + " Fehler in den Tests");
        System.out.println("Tests abgeschlossen");
    }

    void testAll() {
        this.testMultiplyInt();
        this.testMultiplyFrac();
        this.testMultiplyFrac2();
        this.testDivide();
        this.testToString();
    }

    void testMultiplyInt() {
        Fraction frac1 = new Fraction(1,2);
        assertBool( frac1.multiply(0).getNumerator() == 0 ,"Fehler in MultiplyInt #1");
        assertBool( frac1.multiply(1).getNumerator() == 1 ,"Fehler in MultiplyInt #2");
        assertBool( frac1.multiply(2).getNumerator() == 2 ,"Fehler in MultiplyInt #3");
    }

    void testMultiplyFrac() {
        Fraction frac1 = new Fraction(1,2);
        Fraction frac2 = new Fraction(3,4);
        assertBool( frac1.multiply(frac2).getNumerator() == 3 && frac1.multiply(frac2).getDenominator() == 8 ,"Fehler in MultiplyFrac #1");
    }

    void testMultiplyFrac2() {
        Fraction frac1 = new Fraction(1,2);
        Fraction frac2 = new Fraction(3,4);
        Fraction frac3 = new Fraction(5,6);
        assertBool( frac1.multiply(frac2,frac3).getNumerator() == 15 && frac1.multiply(frac2,frac3).getDenominator() == 48 ,"Fehler in MultiplyFrac2 #1");
    }

    void testDivide() {
        Fraction frac1 = new Fraction(1,2);
        Fraction frac2 = new Fraction(3,4);
        assertBool( frac1.divide(frac2).getNumerator() == 4 && frac1.divide(frac2).getNumerator() == 6 , "Fehler in MultiplyDivide #1" );
    }

    void testToString() {
        Fraction frac1 = new Fraction(1,2);
        System.out.println("TestToString : " + frac1);
    }

    /**
     * Testet einen booleschen Ausdruck und gibt eine Fehlermeldung aus,
     * falls dieser nicht gilt. Erhoeht zusaetzlich den Counter fuer die Anzahl
     * der festgestellten Fehler.
     * Convenience-Methode, die es erspart fuer jede Ueberpruefung eine extra
     * if-Abfrage  schreiben zu müssen.
     *
     * @param statement Der Ausdruck der ueberprueft werden soll
     * @param errorMsg Die Fehlermeldung
     */
    private void assertBool(boolean statement, String errorMsg) {
        if(!statement) {
            this.anzahlFehler++;
            System.out.println(errorMsg);
        }
    }

}