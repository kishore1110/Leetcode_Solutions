class Solution {
    public int maxScore(String s) {
        int totalOnes=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                totalOnes++;
            }
        }
        int currZero=0;
        int currOne=0;
        int maxScore=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                currOne++;
            }
            else{
                currZero++;
            }
            maxScore=Math.max(maxScore,currZero+(totalOnes-currOne));
        }
        return maxScore;
    }
}