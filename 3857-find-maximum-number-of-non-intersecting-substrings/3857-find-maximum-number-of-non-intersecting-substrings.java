class Solution {
    public int maxSubstrings(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (map.containsKey(ch)) {
                int idx = map.get(ch);
                if (i - idx + 1 >= 4) {
                    count++;
                    map.clear();
                }
            } else {
                map.put(ch, i);
            }
        }

        return count;
    }
}