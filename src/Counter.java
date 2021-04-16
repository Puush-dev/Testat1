
/**
 *  Die Klasse zählt auf der Konsole bis x, wobei x ein Programmargument ist.
 */
public class Counter {

    public static void main(String[] args) {
        if(checkInput(args)) {
            int i = 0;
            while(i < Integer.parseInt(args[0])) {
                i++;
                System.out.println(i);
            }
        }
    }

    /**
     * Überprüfung auf korrekte Programmargumente
     *
     * @param input Der uebergebene Parameter beim ausführen des Javaprogramms
     * @return true bei validem Argument sonst false
     */
    static boolean checkInput(String[] input) {
        if(input.length == 1 && Integer.parseInt(input[0]) > 0 ) {
            return true;
        } else if(input.length != 1 ) {
            System.out.println("Es wurde kein oder mehr als ein Parameter angeben.\nAufruf erfolgt mit \"java Counter x\", wobei x > 0 sein muss");
            return false;
        } else {
            System.out.println("Bitte geben Sie eine Zahl > 0 an!");
            return false;
        }
    }
}