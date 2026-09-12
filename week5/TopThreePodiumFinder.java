package week5;

import java.util.Arrays;

/**
 * Category C Practice Problem 3: Top-3 Podium Finder (Intermediate Tier)
 * 
 * Problem Statement:
 * Find the top 3 scores in a single pass through the array without sorting.
 * Returns the three scores in descending order.
 */
public class TopThreePodiumFinder {

    /**
     * Finds the top 3 scores in a single pass without sorting.
     *
     * @param scores Array of scores (length >= 3)
     * @return Array of top 3 scores [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 scores.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int x : scores) {
            if (x >= first) {
                third = second;
                second = first;
                first = x;
            } else if (x >= second) {
                third = second;
                second = x;
            } else if (x > third) {
                third = x;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: " + Arrays.toString(scores1));
        System.out.println("Top 3 Podium: " + Arrays.toString(findTopThreeScores(scores1)));

        System.out.println("\n=== Example 2 ===");
        int[] scores2 = {10, 20, 30};
        System.out.println("Scores: " + Arrays.toString(scores2));
        System.out.println("Top 3 Podium: " + Arrays.toString(findTopThreeScores(scores2)));
    }
}
