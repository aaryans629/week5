package week5;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

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

