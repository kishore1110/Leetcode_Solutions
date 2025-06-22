class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo=new int[word1.length()][word2.length()];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return dp(word1,word2,0,0,memo);
    }
    public int dp(String word1, String word2,int index1,int index2,int[][] memo){
        if(index2>=word2.length()){
            return word1.length()-index1;
        }
        if(index1>=word1.length()){
            return word2.length()-index2;
        }
        if(memo[index1][index2]!=-1){
            return memo[index1][index2];
        }
        int ans=Integer.MAX_VALUE;
        if(word1.charAt(index1)==word2.charAt(index2)){
            ans=Math.min(ans,dp(word1,word2,index1+1,index2+1,memo));    //match
        }
        ans=Math.min(ans,1+dp(word1,word2,index1+1,index2,memo));    //delete
        ans=Math.min(ans,1+dp(word1,word2,index1+1,index2+1,memo));  //replace
        ans=Math.min(ans,1+dp(word1,word2,index1,index2+1,memo));   //insert
        memo[index1][index2]=ans;    
        return ans;
    }
}