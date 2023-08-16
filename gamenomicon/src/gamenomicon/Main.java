package gamenomicon;

import gamenomicon.file.FileHandler;
import gamenomicon.model.GameBook;
import gamenomicon.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        GameBook gamenomicon = FileHandler.load();
        UserInterface ui = new UserInterface(gamenomicon);
        ui.mainMenu();
    }
}
