package week5;

public class TopPerformerTracker {

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

