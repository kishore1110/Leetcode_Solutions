class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //bottom up
        int[] dp=new int[days.length+1];
        for(int i=days.length-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            int costIndex=0;
            int j=i;
            for(int day:new int[]{1,7,30}){
                while(j<days.length && days[j]<days[i]+day){
                    j++;
                }
                dp[i]=Math.min(dp[i],costs[costIndex]+dp[j]);
                costIndex++;
            }
        }
        return dp[0];
    }
}