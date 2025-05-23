class Solution {
    int MOD=1000000000+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo=new int[n+1][target+1];
        for(int[] m:memo){
            Arrays.fill(m,-1);
        }
        return dp(k,n,target,0,0,memo);
    }
    public  int dp(int face,int n,int target,int currentSum,int level,int[][] memo){
        if(currentSum>target){
            return 0;
        }
        if(level>=n){
            return currentSum==target?1:0;
        }
        if(memo[level][currentSum]!=-1){
            return memo[level][currentSum];
        }
        int ways=0;
        for(int i=1;i<=face;i++){
            ways=(ways+dp(face,n,target,currentSum+i,level+1,memo))%MOD;
        }
        memo[level][currentSum]=ways;
        return memo[level][currentSum];
    }
}