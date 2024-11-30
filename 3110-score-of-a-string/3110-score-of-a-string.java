class Solution {
    public int scoreOfString(String s) {
        int Score=0;
        int length=s.length();
        for(int i=0;i<length-1;i++){
            Score+=Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return Score;
    }
}