package gamenomicon.entities;

import gamenomicon.comparators.ScoreComparator;
import gamenomicon.comparators.YearComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBook {
    List<Game> games;

    public GameBook() {
        this.games = new ArrayList<>();
    }

    public void addGame(Game newGame) {
        try {
            this.games.add(newGame);
            System.out.println("Game successfully added.");
        } catch (Exception e) {
            System.out.println("An unexpected error has occurred");
        }
    }
    public void removeGame(String title) {
        boolean wasFound = false;
        for(Game g : this.games) {
            if(g.getTitle().equals(title)) {
                System.out.println(title + " was removed");
                this.games.remove(g);
                wasFound = true;
            }
        }
        if(!wasFound) System.out.println("Game not found.");
    }
    public List<Game> searchByName(String title) {
        List<Game> results = new ArrayList<>();
        for(Game g : this.games) {
            if(g.getTitle().equals(title)) results.add(g);
        }
        System.out.println(results.size() + " " + "games found.");
        return results;
    }
    public List<Game> sortByName() {
        List<Game> sorted = new ArrayList<>(this.games);
        Collections.sort(sorted);
        return sorted;
    }
    public List<Game> sortByDescendingScore() {
        List<Game> sorted = new ArrayList<>(this.games);
        Collections.sort(sorted, new ScoreComparator());
        return sorted;
    }
    public List<Game> sortByPublishingYear() {
        List<Game> sorted = new ArrayList<>(this.games);
        Collections.sort(sorted, new YearComparator());
        return sorted;
    }
}
