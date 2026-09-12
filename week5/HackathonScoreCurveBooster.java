package week5;

import java.util.Arrays;

public class HackathonScoreCurveBooster {

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

