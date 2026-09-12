package week5;

/**
 * Category C Practice Problem 4: Hackathon Seating Grid Optimizer (Intermediate Tier)
 * 
 * Problem Statement:
 * Classify seating rows as "Quiet Zone" (< threshold) or "Buzzing Zone" (>= threshold)
 * using a reusable rowAverage helper method.
 */
public class HackathonSeatingGridOptimizer {

    /**
     * Computes the average score for a single row.
     *
     * @param row Array representing scores in one row
     * @return Row average
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int s : row) {
            sum += s;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies each row in the seating grid.
     *
     * @param seatingScores 2D jagged array of scores
     * @param threshold     Threshold to distinguish Quiet vs Buzzing
     * @return Formatted string with classifications
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println("Threshold: " + threshold);
        System.out.println("Output: " + classifyRows(seating, threshold));
    }
}
