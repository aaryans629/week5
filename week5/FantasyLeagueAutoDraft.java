package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Category C Assignment Problem 5: Fantasy League Auto-Draft Ranking Engine (Advanced Tier)
 * 
 * Topics Integrated: Arrays, Method Overloading, Static Methods, Standard Library (Arrays.sort),
 * Constructors & Encapsulation
 */
public class FantasyLeagueAutoDraft {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Rank descending by fantasy points (batting average)
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    /**
     * Experience-only eligibility rule: matches >= 10 qualifies regardless of injury.
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Combined matches-and-fitness rule for newer players: matches >= 5 and not injured.
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players, sorts them using Arrays.sort(), and formats the ranking string.
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append((i + 1)).append(". ").append(draftableArray[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);
        System.out.println("Draft and Rank Output: " + result);
    }
}
