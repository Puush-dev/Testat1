import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zaehlen {

    public static void main(String[] args) {

        if(checkInput(args)) {
            int i = 0;
            while (i < Integer.parseInt(args[0])) {
                i++;
                System.out.println(i);
            }
        }
    }

    /**
     *
     * @param input Der Übergebene Parameter beim Ausführen des Javaprogramms
     * @return true bei validen Übergabeparameter ansonsten false
     */
    static boolean  checkInput(String[] input){
        if(input.length == 1 && Integer.parseInt(input[0]) > 0 ){
            return true;
        } else if(input.length != 1 ){
            System.out.println("Bitte geben Sie genau eine Zahl mit an !");
            return false;
        } else {
            System.out.println("Bitte geben Sie eine Zahl > 0 an !");
            return false;
        }
    }
}
