package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveRankingEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {

            return (cgpa * 10.0) + (codingScore / 2.0);
        }

        @Override
        public int compareTo(Candidate other) {

            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] array = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append((i + 1)).append(". ")
              .append(array[i].getName())
              .append(" (").append(String.format("%.1f", array[i].getCompositeScore())).append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println("Rankings: " + result);
    }
}

