package gamenomicon.ui;

import java.util.Optional;
import java.util.Scanner;

/**
 * O InputHandler lida com os inputs do usuário e a validação dos dados.
 *
 * @author bayerl
 */
public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    /*public InputHandler() {
        scanner = new Scanner(System.in);
    }*/

    public static String getInput() {
        while(true) {
            String userInput = scanner.nextLine();
            if(!userInput.isEmpty()) return userInput;
            System.out.println("Input cannot be empty");
        }
    }

    public static boolean validateIntegerInput(int min, int max, String input) {
        try {
            int parsedInt = Integer.parseInt(input);
            if(parsedInt < min || parsedInt > max) throw new NumberFormatException();
            return true;
        } catch (Exception e) {
            System.out.println("Provide a valid integer between " + min + " and " + max);
            return false;
        }
    }
}
