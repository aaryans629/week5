package week5;

/**
 * Category C Assignment Problem 3: Top Performer Tracker (Intermediate Tier)
 * 
 * Topics Integrated: Arrays, Loops, Logical Thinking
 * 
 * Problem Statement:
 * A fantasy league's weekly recap wants to instantly call out the week's standout performer
 * and the week's biggest disappointment, along with how wide the gap between them was —
 * without sorting the entire scoreboard just to read off two numbers.
 */
public class TopPerformerTracker {

    /**
     * Finds min, max, and spread in a single pass through the array.
     *
     * @param scores Array of scores (length >= 2)
     * @return Formatted string "Min: X | Max: Y | Spread: Z"
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            return "Invalid scores array";
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            int score = scores[i];
            if (score < min) {
                min = score;
            }
            if (score > max) {
                max = score;
            }
        }

        int spread = max - min;
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, spread);
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: {45, 82, 79, 90, 33, 90, 61}");
        System.out.println("Output: " + findMinMaxSpread(scores));

        System.out.println("\n=== Example 2 ===");
        int[] scores2 = {50, 50};
        System.out.println("Scores: {50, 50}");
        System.out.println("Output: " + findMinMaxSpread(scores2));
    }
}
