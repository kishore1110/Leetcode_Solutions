class Solution {
    public int numTrees(int n) {
        return findCatalanNumber(n);
    }
    public int findCatalanNumber(int n){
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;//base condition
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}