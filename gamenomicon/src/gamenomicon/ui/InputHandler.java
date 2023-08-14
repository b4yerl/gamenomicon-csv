package gamenomicon.ui;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return this.scanner.nextLine();
    }

    public boolean validateIntegerInput(int min, int max, String input) {
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
