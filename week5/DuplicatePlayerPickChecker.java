package week5;

public class DuplicatePlayerPickChecker {

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

