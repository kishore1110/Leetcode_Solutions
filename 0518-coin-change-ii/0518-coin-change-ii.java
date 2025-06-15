class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo=new int[coins.length][amount+1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return dfs(coins,0,amount,memo);
    }
    public int dfs(int[] coins,int index,int amount,int[][] memo){
        if(amount<0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        if(memo[index][amount]!=-1){
            return memo[index][amount];
        }
        int ans=0;
        for(int i=index;i<coins.length;i++){
            ans+=dfs(coins,i,amount-coins[i],memo);
        }
        memo[index][amount]=ans;
        return ans;
    }
}