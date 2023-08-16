package gamenomicon.ui;

import gamenomicon.model.Game;
import java.util.List;

public class GameListHandler {
    public static void display(List<Game> games) {
        games.stream().forEach(System.out::println);
    }
}
