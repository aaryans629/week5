# Week 5 Assignment Problems (Category C Core)

---

### Problem 1: Fantasy Team Score Multiplier (Easy Tier)
**Topics Integrated:** Creating/Modifying Arrays, Arrays Passed by Reference

#### Problem Statement
In a fantasy sports app, every user picks a Captain (2× points) and a Vice-Captain (1.5× points) from their lineup. Write a method that applies both multipliers directly to the lineup's score array, so the app's scoreboard reflects the boosted totals immediately after the match end.

#### Requirements
- `applyMultipliers(...)` must modify the caller's original array directly — it should return nothing at all.
- Only the captain's and vice-captain's positions change; every other score stays exactly as it was.

#### Function Signature
```java
static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex)
```

#### Examples
- **Input:** `double[] scores = {40, 55, 30, 62}; applyMultipliers(scores, 1, 3); Arrays.toString(scores)`
- **Output:** `"[40.0, 110.0, 30.0, 93.0]"`
- **Explanation:** Index 1 (55) is captain doubled to 110.0. Index 3 (62) is vice-captain multiplied by 1.5 to 93.0.
- **Constraints:** `playerScores.length` up to 15. `captainIndex` and `viceCaptainIndex` are always valid distinct indices.

---

### Problem 2: Duplicate Player Pick Checker (Easy Tier)
**Topics Integrated:** Arrays, Strings, Nested Loops

#### Problem Statement
A glitch in the fantasy app's draft screen occasionally lets a user tap the same player twice before the UI catches up, silently adding them to the lineup twice. Write a method that checks a submitted lineup for a repeated player name before it's accepted.

#### Requirements
- Compare every name against every other name using plain nested loops — no Collections class of any kind.
- Report the first duplicate found, scanning in order; if none exist, say so clearly.

#### Function Signature
```java
static String findDuplicatePick(String[] playerNames)
```

#### Examples
- **Input:** `{"Kohli", "Bumrah", "Kohli", "Rohit"}` -> **Output:** `"Duplicate Found: Kohli"`
- **Input:** `{"Kohli", "Bumrah", "Rohit"}` -> **Output:** `"No Duplicates Found"`
- **Constraints:** Lineup size up to 11 players. Comparison is case-sensitive.

---

### Problem 3: Top Performer Tracker (Intermediate Tier)
**Topics Integrated:** Arrays, Loops, Logical Thinking

#### Problem Statement
A fantasy league's weekly recap wants to instantly call out the week's standout performer and the week's biggest disappointment, along with how wide the gap between them was — without sorting the entire scoreboard just to read off two numbers.

#### Requirements
- Do not sort the array — find the minimum and maximum in a single pass through the array.
- Report the minimum, the maximum, and the spread (max − min) together.

#### Function Signature
```java
static String findMinMaxSpread(int[] scores)
```

#### Examples
- **Input:** `{45, 82, 79, 90, 33, 90, 61}`
- **Output:** `"Min: 33 | Max: 90 | Spread: 57"`
- **Constraints:** `scores.length` is at least 2, up to 10,000.

---

### Problem 4: Match Day Grid Analyzer (Intermediate Tier)
**Topics Integrated:** 2D Arrays, User-Defined Methods (reused), Loops

#### Problem Statement
A cricket stats app logs runs scored in every over of every match as a grid — one row per match, one column per over. The app wants to flag which matches were genuine "Power Surge" innings (a high scoring rate throughout) without repeating the same averaging code once per match.

#### Requirements
- Write a private helper, `rowAverage(int[] row)`, and call it once per match from the main method — do not recompute an average inline more than once.
- A match averaging at or above the threshold is a "Power Surge"; below it, "Normal".

#### Function Signatures
```java
static double rowAverage(int[] row)
static String classifyMatches(int[][] runsPerOver, int threshold)
```

#### Examples
- **Input:** `{{4, 6, 8}, {10, 12, 14}, {2, 3, 1}}, threshold = 8`
- **Output:** `"Match 0: Normal | Match 1: Power Surge | Match 2: Normal"`
- **Constraints:** Rows may have different lengths (jagged grid).

---

### Problem 5: Fantasy League Auto-Draft Ranking Engine (Advanced Tier)
**Topics Integrated:** Arrays, Method Overloading, Static Methods, Arrays.sort, Constructors & Encapsulation

#### Problem Statement
An auto-draft feature needs to decide which players are draftable and rank them by fantasy points — but the draft rule isn't one simple cutoff. A player with a long track record qualifies on experience alone, but a newer player still needs to be both reasonably experienced and currently fit to make the cut.

#### Requirements
- Provide two overloaded `isDraftable(...)` checks: a matches-played-only rule for established players, and a combined matches-and-fitness rule for everyone else.
- `Player` must implement `Comparable<Player>` so that `Arrays.sort(...)` alone can rank the draftable array by fantasy points (batting average), descending.

#### Function Signatures
```java
public Player(String name, int matchesPlayed, double battingAverage, boolean injured)
static boolean isDraftable(int matchesPlayed)
static boolean isDraftable(int matchesPlayed, boolean injured)
int compareTo(Player other)
static String draftAndRank(Player[] players)
```

#### Examples
- **Input:**
  - `new Player("Virat", 15, 48.0, false)`
  - `new Player("Rahul", 7, 55.0, false)`
  - `new Player("Sameer", 3, 60.0, false)`
  - `new Player("Dev", 12, 20.0, true)`
- **Output:** `"1. Rahul | 2. Virat | 3. Dev"`
