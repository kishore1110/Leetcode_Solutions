class Solution {
    public long maximumProfit(int[] prices, int k) {
        // 0->Buy  1->Sell  2-> Any thing can do
        long ans=0;
        long[][][] memo=new long[prices.length][2*(k+1)][3];
        for(long[][] arr:memo){
            for(long[] ar:arr){
                Arrays.fill(ar,-1);
            }
        }
        // for(int i=1;i<=k;i++){
        //     ans=Math.max(ans,dp(prices,0,2*i,2,memo));
        // }
        return dp(prices,0,2*k,2,memo);
    }
    public long dp(int[] prices,int index,int k,int condition,long[][][] memo){
        if(index>=prices.length || k==0){
            if(condition!=2)return Integer.MIN_VALUE/2;
            return 0;
        }
        if(memo[index][k][condition]!=-1){
            return memo[index][k][condition];
        }
        if(condition==0){
            long buy=-prices[index]+dp(prices,index+1,k-1,2,memo);
            long skip=dp(prices,index+1,k,condition,memo);
            memo[index][k][condition]=Math.max(buy,skip);
            return memo[index][k][condition];
        }
        else if(condition==1){
            long sell=prices[index]+dp(prices,index+1,k-1,2,memo);
            long skip=dp(prices,index+1,k,condition,memo);
            memo[index][k][condition]=Math.max(sell,skip);
            return memo[index][k][condition];
        }
        long buy=-prices[index]+dp(prices,index+1,k-1,1,memo);
        long sell=prices[index]+dp(prices,index+1,k-1,0,memo);
        long skip=dp(prices,index+1,k,condition,memo);
        memo[index][k][condition]=Math.max(buy,Math.max(sell,skip));
        return memo[index][k][condition];
    }
}