package week5;

import java.util.Arrays;

/**
 * Category C Practice Problem 1: Hackathon Score Curve Booster (Easy Tier)
 * 
 * Problem Statement:
 * The judging panel at a campus hackathon wants to give every team a flat bonus before the final
 * leaderboard is printed. Write a method that boosts every score in place — no new array, no return
 * value needed — and print the result using Arrays.toString().
 */
public class HackathonScoreCurveBooster {

    /**
     * Curves scores in place by adding the bonus to each score.
     *
     * @param scores Array of team scores (modified in place)
     * @param bonus  Flat bonus amount
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        int[] scores = {70, 85, 60};
        System.out.println("Original: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("Curved (+10): " + Arrays.toString(scores));
    }
}
