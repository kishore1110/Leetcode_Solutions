class Solution {
    int count=0;
    public int numTilePossibilities(String tiles) {
        int[] freq=new int[26];
        for(int i=0;i<tiles.length();i++){
            freq[tiles.charAt(i)-'A']++;
        }
        backtrack(freq);
        return count;
    }
    public void backtrack(int[] freq){
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                freq[i]--;
                count++;
                backtrack(freq);
                freq[i]++;
            }
        }
    }
}