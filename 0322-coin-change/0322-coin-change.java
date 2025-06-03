class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo=new int[amount+1];
        Arrays.fill(memo,-2);
        int result=dp(coins,amount,memo);
        return result;
    }
    public int dp(int[] coins,int amount,int[] memo){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(memo[amount]!=-2){
            return memo[amount];
        }
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int res=dp(coins,amount-coin,memo);
            if(res!=-1){
                min=Math.min(min,res+1);
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}