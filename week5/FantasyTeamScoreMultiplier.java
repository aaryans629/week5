package week5;

import java.util.Arrays;

/**
 * Category C Assignment Problem 1: Fantasy Team Score Multiplier (Easy Tier)
 * 
 * Topics Integrated: Creating/Modifying Arrays, Arrays Passed by Reference
 * 
 * Problem Statement:
 * In a fantasy sports app, every user picks a Captain (2x points) and a Vice-Captain (1.5x points)
 * from their lineup. Write a method that applies both multipliers directly to the lineup's
 * score array, so the app's scoreboard reflects the boosted totals immediately after the match end.
 */
public class FantasyTeamScoreMultiplier {

    /**
     * Applies multipliers directly to the playerScores array in place.
     * Captain gets 2.0x, Vice-Captain gets 1.5x.
     *
     * @param playerScores     Array of player scores (modified in-place)
     * @param captainIndex     Index of the captain
     * @param viceCaptainIndex Index of the vice-captain
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        double[] scores1 = {40, 55, 30, 62};
        System.out.println("Original: " + Arrays.toString(scores1));
        applyMultipliers(scores1, 1, 3);
        System.out.println("After Multipliers (Captain: 1, VC: 3): " + Arrays.toString(scores1));

        System.out.println("\n=== Example 2 ===");
        double[] scores2 = {100, 80, 50};
        System.out.println("Original: " + Arrays.toString(scores2));
        applyMultipliers(scores2, 0, 2);
        System.out.println("After Multipliers (Captain: 0, VC: 2): " + Arrays.toString(scores2));
    }
}
