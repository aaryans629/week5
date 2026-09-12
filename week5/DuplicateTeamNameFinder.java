package week5;

public class DuplicateTeamNameFinder {

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

