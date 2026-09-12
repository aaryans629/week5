package week5;

/**
 * Category C Assignment Problem 4: Match Day Grid Analyzer (Intermediate Tier)
 * 
 * Topics Integrated: 2D Arrays, User-Defined Methods (reused), Loops
 * 
 * Problem Statement:
 * A cricket stats app logs runs scored in every over of every match as a grid —
 * one row per match, one column per over. The app wants to flag which matches were genuine
 * "Power Surge" innings (a high scoring rate throughout) without repeating the same
 * averaging code once per match.
 */
public class MatchDayGridAnalyzer {

    /**
     * Private helper to compute the average of a single match's overs.
     *
     * @param row Array of runs scored per over in one match
     * @return Average runs per over
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies matches as "Power Surge" (>= threshold) or "Normal" (< threshold).
     *
     * @param runsPerOver 2D jagged array of runs per over for each match
     * @param threshold   Average threshold
     * @return Pipe-separated match classifications
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(classification);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println("Threshold: " + threshold);
        System.out.println("Output: " + classifyMatches(runs, threshold));
    }
}
