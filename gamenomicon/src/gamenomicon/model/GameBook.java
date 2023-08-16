package gamenomicon.model;

import gamenomicon.comparators.ScoreComparator;
import gamenomicon.comparators.YearComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A classe GameBook mantém e gerencia os jogos resgistrados
 * @author bayerl
 */
public class GameBook {
    List<Game> games;

    public GameBook() {
        this.games = new ArrayList<>();
    }

    /**
     * O método addGame gera uma nova entrada no Gamenomicon.
     *
     * @param newGame   Recebe um novo jogo para ser adicionado ao Gamenomicon.
     */
    public void addGame(Game newGame) {
            this.games.add(newGame);
            System.out.println("Game successfully added.");
        /*
        try {
        } catch (Exception e) {
            System.out.println("An unexpected error has occurred");
        }
        */
    }

    /**
     * Remove um jogo do Gamenomicon
     *
     * @param title Título do jogo a ser removido
     */
    public void removeGame(String title) {
        Iterator<Game> gameIterator = this.games.iterator();
        boolean wasFound = false;
        while(gameIterator.hasNext()) {
            Game currentGame = gameIterator.next();
            if(currentGame.getTitle().equals(title)) {
                gameIterator.remove();
                wasFound = true;
                System.out.println(title + " was removed");
            }
        }
        if(!wasFound) System.out.println("Game not found.");
    }

    /**
     * Busca entradas no Gamenomicon baseado em um termo.
     *
     * @param title Termo utilizado para a busca no Gamenomicon.
     * @return Retorna um List com os jogos encontrados.
     */
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
    public List<String[]> getFullList() {
        List<String[]> entries = new ArrayList<>();
        for(Game game : this.games) {
            entries.add(new String[]{game.getTitle(), game.getReview(),
                    String.valueOf(game.getScore()), String.valueOf(game.getPublishingYear())});
        }
        return entries;
    }
}
