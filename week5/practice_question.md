# Week 5 Practice Problems (Category C Core)

---

### Problem 1: Hackathon Score Curve Booster (Easy Tier)
#### Problem Statement
The judging panel at a campus hackathon realizes the coding round was tougher than intended, and wants to give every team a flat bonus before the final leaderboard is printed. Write a method that boosts every score in place — no new array, no return value needed — and print the result using the standard library's own formatting helper.

#### Requirements
- `curveScores(...)` must modify the caller's original array directly — it should return nothing at all.
- Use `Arrays.toString(...)` to print the final leaderboard.

#### Function Signature
```java
static void curveScores(int[] scores, int bonus)
```

#### Examples
- **Input:** `int[] scores = {70, 85, 60}; curveScores(scores, 10); Arrays.toString(scores)`
- **Output:** `"[80, 95, 70]"`
- **Constraints:** `scores.length` up to 200. `bonus` is a non-negative integer.

---

### Problem 2: Duplicate Team Name Finder (Easy Tier)
#### Problem Statement
Hackathon registration is chaotic, and the organizers suspect the same team accidentally submitted their name twice under two different form entries. Write a method that scans the list of registered team names and reports the first duplicate it finds.

#### Requirements
- Compare every name against every other name using plain nested loops — no Collections class of any kind.
- Report the first duplicate found, scanning in order; if none exist, say so clearly.

#### Function Signature
```java
static String findDuplicateTeam(String[] teamNames)
```

#### Examples
- **Input:** `{"ByteForce", "CodeCrafters", "ByteForce"}` -> **Output:** `"Duplicate Found: ByteForce"`
- **Input:** `{"ByteForce", "CodeCrafters", "NullPointers"}` -> **Output:** `"No Duplicates Found"`
- **Constraints:** Up to 100 team names. Comparison is case-sensitive.

---

### Problem 3: Top-3 Podium Finder (Intermediate Tier)
#### Problem Statement
With hundreds of teams submitting scores, sorting the entire array just to find the top 3 podium finishers is overkill — a judge on stage wants the podium announced the instant scoring wraps up, without waiting for a full sort. Find the top 3 scores in a single pass through the array.

#### Requirements
- Do not sort the array and do not use `Arrays.sort(...)` — track the top 3 scores as you scan once, left to right.
- Return the three scores in descending order.

#### Function Signature
```java
static int[] findTopThreeScores(int[] scores)
```

#### Examples
- **Input:** `{45, 82, 79, 90, 33, 90, 61}`
- **Output:** `[90, 90, 82]`
- **Explanation:** Two teams tied for top score (90), so both appear; third-place is 82.
- **Constraints:** `scores.length` is at least 3, up to 10,000.

---

### Problem 4: Hackathon Seating Grid Optimizer (Intermediate Tier)
#### Problem Statement
The venue is arranged as a grid of seating rows, and organizers want to walk the floor toward the rows where teams are visibly struggling versus rows humming along fine. Classify every row using one small, reusable helper method rather than repeating averaging logic by hand.

#### Requirements
- Write a private helper, `rowAverage(int[] row)`, and call it once per row from the main method — do not recompute an average inline more than once.
- A row averaging below the threshold is a `"Quiet Zone"`; at or above it, a `"Buzzing Zone"`.

#### Function Signatures
```java
static double rowAverage(int[] row)
static String classifyRows(int[][] seatingScores, int threshold)
```

#### Examples
- **Input:** `{{40, 50, 45}, {85, 90, 95}, {30, 20, 25}}, threshold = 60`
- **Output:** `"Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone"`
- **Constraints:** Rows may vary in length (jagged grid).

---

### Problem 5: Placement Drive Shortlisting & Ranking Engine (Advanced Tier)
#### Problem Statement
The placement cell wants one script to do two jobs: decide who's eligible for a company's coding round, and rank everyone who qualifies. Eligibility isn't one simple rule — a strong CGPA alone is enough, but a borderline CGPA can still qualify through a genuinely good coding-test score. Once shortlisted, candidates should be ranked by a composite score, using Java's own sort rather than writing a sort by hand.

#### Requirements
- Provide two overloaded `isEligible(...)` checks: a CGPA-only quick filter, and a combined CGPA-and-coding-score filter for borderline cases.
- `Candidate` must implement `Comparable<Candidate>` so that `Arrays.sort(...)` alone can rank a shortlisted array by composite score, descending.

#### Function Signatures
```java
public Candidate(String name, double cgpa, int codingScore)
static boolean isEligible(double cgpa)
static boolean isEligible(double cgpa, int codingScore)
int compareTo(Candidate other)
static String shortlistAndRank(Candidate[] candidates)
```

#### Examples
- **Input:**
  - `new Candidate("Aisha", 8.2, 40)`
  - `new Candidate("Rohit", 6.8, 65)`
  - `new Candidate("Meena", 6.0, 90)`
  - `new Candidate("Karan", 7.5, 20)`
- **Output:** `"1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)"`
