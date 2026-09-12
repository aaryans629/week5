package week5;

/**
 * Category C Practice Problem 2: Duplicate Team Name Finder (Easy Tier)
 * 
 * Problem Statement:
 * Hackathon registration is chaotic, and the organizers suspect the same team accidentally
 * submitted their name twice. Write a method that scans the list of registered team names
 * and reports the first duplicate it finds using plain nested loops without Collections.
 */
public class DuplicateTeamNameFinder {

    /**
     * Finds the first duplicate team name in the list.
     *
     * @param teamNames Array of team names
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Output: " + findDuplicateTeam(teams1));

        System.out.println("\n=== Example 2 ===");
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("Output: " + findDuplicateTeam(teams2));
    }
}
