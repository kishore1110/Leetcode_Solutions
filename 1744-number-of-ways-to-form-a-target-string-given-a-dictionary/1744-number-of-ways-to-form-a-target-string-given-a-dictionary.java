class Solution {
private static final int MOD = 1000000007;
private int[][] mem;
private int targetSize, wordSize, n;
private int[][] charFreq;

public int numWays(String[] words, String target) {
    targetSize = target.length();
    wordSize = words[0].length();
    n = words.length;
    charFreq = new int[wordSize][26];

    // Calculate character frequency for each position
    for (String word : words) {
        for (int j = 0; j < wordSize; j++) {
            char curr = word.charAt(j);
            charFreq[j][curr - 'a']++;
        }
    }

    mem = new int[wordSize][targetSize];
    for (int[] row : mem) Arrays.fill(row, -1);

    return countWays(words, 0, target, 0);
}

private int countWays(String[] words, int idx, String target, int tpos) {
    if (tpos == targetSize) // Match
        return idx <= wordSize ? 1 : 0;

    if (idx >= wordSize || (wordSize - idx < targetSize - tpos)) // No Match or Insufficient Size
        return 0;

    if (mem[idx][tpos] != -1) // Repeating sub-problem
        return mem[idx][tpos];

    char curr = target.charAt(tpos);
    long waysByNotMatching = countWays(words, idx + 1, target, tpos);
    long waysByMatching = countWays(words, idx + 1, target, tpos + 1) % MOD;
    long totalWays = (waysByNotMatching + (long) charFreq[idx][curr - 'a'] * waysByMatching) % MOD;

    mem[idx][tpos] = (int) totalWays;
    return mem[idx][tpos];
    }
}