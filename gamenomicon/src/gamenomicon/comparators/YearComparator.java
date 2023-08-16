package gamenomicon.comparators;

import gamenomicon.model.Game;
import java.util.Comparator;

public class YearComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        int result = Integer.compare(g1.getPublishingYear(), g2.getPublishingYear());
        if(result == 0) return g1.compareTo(g2);
        return result;
    }
}
