package gamenomicon.comparators;

import gamenomicon.entities.Game;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Game> {
    public int compare(Game g1, Game g2) {
        int result = Integer.compare(g1.getScore(), g2.getScore());

        if(result == 0) return g1.compareTo(g2);
        return result;
    }
}
