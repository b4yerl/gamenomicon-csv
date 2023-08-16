package gamenomicon.ui;

import gamenomicon.file.FileHandler;
import gamenomicon.model.Game;
import gamenomicon.model.GameBook;

import java.time.LocalDate;
import java.util.List;

/**
 * Essa classe lida com tudo que o usuário vê e interage com.
 *
 * @author bayerl
 */
public class UserInterface {
    //private InputHandler inputHandler;
    private final GameBook games;
    public UserInterface(GameBook currentBook) {
        //inputHandler = new InputHandler();
        this.games = currentBook;
    }

    public void mainMenu() {
        String options = """
                 ------------------------------------------------------
                | Welcome to the Gamenomicon, please choose an option: |
                |                                                      |
                | 1 - Add a new game review.                           |
                | 2 - Delete a game.                                   |
                | 3 - Search by name.                                  |
                | 4 - Display games.                                   |
                | 5 - End program and save file.                       |
                 ------------------------------------------------------
                """;
        System.out.println(options);

        // Valida o input para navegar no menu
        boolean isValidInput = false;
        String input = null;

        while (!isValidInput) {
            System.out.print("Input: ");
            input = InputHandler.getInput();
            isValidInput = InputHandler.validateIntegerInput(1, 5, input);
        }

        // Escolhi usar switch apenas para fins de estudo e treino
        int choosedOption = Integer.parseInt(input);
        switch (choosedOption) {
            case (1) -> addGameUI();
            case (2) -> removeGameUI();
            case (3) -> searchGameUI();
            case (4) -> displayGamesUI();
            case (5) -> endApplicationUI();
            // FileHandler.save(GameBook games)
        }
    }

    public void addGameUI() {
        System.out.println("Input the requested information: ");

        // Recebe os inputs do user e valida
        System.out.print("Title: ");
        String title = InputHandler.getInput();

        boolean isValidYear = false;

        String year = null;
        while (!isValidYear) {
            System.out.print("Publishing Year: ");
            year = InputHandler.getInput();
            isValidYear = InputHandler.validateIntegerInput(1900, LocalDate.now().getYear(), year);
        }

        boolean isValidScore = false;

        String score = null;
        while (!isValidScore) {
            System.out.print("Score: ");
            score = InputHandler.getInput();
            isValidScore = InputHandler.validateIntegerInput(0, 5, score);
        }

        System.out.print("Review: ");
        String review = InputHandler.getInput();

        // Adiciona o jogo ao gamebook
        Game newGame = new Game(title, review, Integer.parseInt(score), Integer.parseInt(year));
        this.games.addGame(newGame);

        String returning = """
                 ------------------------
                | RETURNING TO MAIN MENU |
                 ------------------------
                """;
        System.out.println(returning);
        mainMenu();
    }
    public void removeGameUI() {
        System.out.print("Input the title of the game you want to remove: ");
        String title = InputHandler.getInput();

        this.games.removeGame(title);
        String returning = """
                 ------------------------
                | RETURNING TO MAIN MENU |
                 ------------------------
                """;
        System.out.println(returning);
        mainMenu();
    }
    public void searchGameUI() {
        System.out.print("Game to search: ");
        String title = InputHandler.getInput();

        List<Game> results = this.games.searchByName(title);
        if(results.isEmpty()) System.out.println("There's no games to display");
        else GameListHandler.display(results);

        String returning = """
                 ------------------------
                | RETURNING TO MAIN MENU |
                 ------------------------
                """;
        System.out.println(returning);
        mainMenu();
    }
    public void displayGamesUI() {
        String displayMenu = """
                 --------------------------------------------------
                | Choose how do you want to explore the reviews.   |
                |                                                  |
                | 1 - Order games by title.                        |
                | 2 - Order games by score.                        |
                | 3 - Order games by publishing year.              |
                 --------------------------------------------------
                
                """;
        System.out.println(displayMenu);

        boolean isValid = false;
        String input = null;

        while (!isValid) {
            System.out.print("Input: ");
            input = InputHandler.getInput();
            isValid = InputHandler.validateIntegerInput(1, 3, input);
        }

        int option = Integer.parseInt(input);
        List<Game> result = switch (option) {
            case (1) -> this.games.sortByName();
            case (2) -> this.games.sortByDescendingScore();
            case (3) -> this.games.sortByPublishingYear();
            default -> null;
        };

        GameListHandler.display(result);

        String returning = """
                 ------------------------
                | RETURNING TO MAIN MENU |
                 ------------------------
                """;
        System.out.println(returning);
        mainMenu();
    }

    public void endApplicationUI() {
        boolean wasSaved = FileHandler.save(this.games);
        if(!wasSaved) {
            System.out.println("Trying one more time...");
            wasSaved = FileHandler.save(this.games);
        }

        String returning = """
                 -------------------------
                |   EXITING APPLICATION   |
                 -------------------------
                """;
        System.out.println(returning);
    }
}
