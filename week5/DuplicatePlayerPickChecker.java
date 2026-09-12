package week5;

/**
 * Category C Assignment Problem 2: Duplicate Player Pick Checker (Easy Tier)
 * 
 * Topics Integrated: Arrays, Strings, Nested Loops
 * 
 * Problem Statement:
 * A glitch in the fantasy app's draft screen occasionally lets a user tap the same player twice
 * before the UI catches up, silently adding them to the lineup twice. Write a method that checks
 * a submitted lineup for a repeated player name before it's accepted.
 */
public class DuplicatePlayerPickChecker {

    /**
     * Checks an array of player names for duplicates using plain nested loops without Collections.
     *
     * @param playerNames Array of player names in the lineup
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Example 1 ===");
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Input: {\"Kohli\", \"Bumrah\", \"Kohli\", \"Rohit\"}");
        System.out.println("Output: " + findDuplicatePick(lineup1));

        System.out.println("\n=== Example 2 ===");
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Input: {\"Kohli\", \"Bumrah\", \"Rohit\"}");
        System.out.println("Output: " + findDuplicatePick(lineup2));
    }
}
