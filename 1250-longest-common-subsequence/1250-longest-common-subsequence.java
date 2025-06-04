class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo=new int[text1.length()][text2.length()];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return dp(text1,text2,0,0,memo);
    }
    public int dp(String text1,String text2,int index1,int index2,int[][] memo){
        if(index1>=text1.length() || index2>=text2.length()){
            return 0;
        }
        if(memo[index1][index2]!=-1){
            return memo[index1][index2];
        }
        int ans=0;
        if(text1.charAt(index1)==text2.charAt(index2)){
            ans=1+dp(text1,text2,index1+1,index2+1,memo);
        }
        else{
            ans=Math.max(dp(text1,text2,index1+1,index2,memo),dp(text1,text2,index1,index2+1,memo));
        }
        memo[index1][index2]=ans;
        return ans;
    }
}