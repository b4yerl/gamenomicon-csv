package gamenomicon.comparators;

import gamenomicon.model.Game;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        int result = Integer.compare(g2.getScore(), g1.getScore());

        if(result == 0) return g1.compareTo(g2);
        return result;
    }
}
