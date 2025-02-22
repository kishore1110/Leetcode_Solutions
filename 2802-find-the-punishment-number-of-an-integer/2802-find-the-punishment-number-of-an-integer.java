class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String squareStr = String.valueOf(i * i);
            Map<String, Boolean> memo = new HashMap<>(); // Memoization map
            if (isPunishment(0, 0, i, squareStr, memo)) {
                result += i * i;
            }
        }
        return result;
    }

    public boolean isPunishment(int index, int currSum, int target, String value, Map<String, Boolean> memo) {
        // Base case: If we have processed the entire string and sum matches the target
        if (index >= value.length()) {
            return currSum == target;
        }

        // Create a key for memoization
        String key = index + "," + currSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Try splitting the string at different points
        for (int j = index; j < value.length(); j++) {
            String currString = value.substring(index, j + 1);
            int num = Integer.parseInt(currString);

            if (isPunishment(j + 1, currSum + num, target, value, memo)) {
                memo.put(key, true);
                return true;
            }
        }

        // Store result in memoization table
        memo.put(key, false);
        return false;
    }
}
