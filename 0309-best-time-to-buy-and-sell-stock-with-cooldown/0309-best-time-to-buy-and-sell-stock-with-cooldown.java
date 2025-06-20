class Solution {
    public int maxProfit(int[] prices) {
        //0->buy 1->sell
        int[][] memo=new int[prices.length][2];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return dp(prices,0,0,memo);
    }
    public int dp(int[] prices,int index,int trans,int[][] memo){
        if(index>=prices.length){
            // if(trans==1)return Integer.MIN_VALUE/2;
            return 0;
        }
        if(memo[index][trans]!=-1){
            return memo[index][trans];
        }
        int ans=0;
        if(trans==0){
            ans=dp(prices,index+1,1,memo)-prices[index];
        }
        else{
            ans=dp(prices,index+2,0,memo)+prices[index];
        }
        ans=Math.max(ans,dp(prices,index+1,trans,memo));
        memo[index][trans]=ans;
        return ans;
    }
}