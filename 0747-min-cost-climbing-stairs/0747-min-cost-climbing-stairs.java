class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache=new int[cost.length+1];
        Arrays.fill(cache,-1);
        dfs(cache,cost,0);
        return Math.min(cache[0],cache[1]);
    }
    public int dfs(int[] cache,int[] cost,int index){
        if(index==cost.length){
            return 0;
        }
        if(index>cost.length-1){
            return Integer.MAX_VALUE;
        }
        if(cache[index]!=-1){
            return cache[index];
        }
        cache[index]=cost[index]+Math.min(dfs(cache,cost,index+1),dfs(cache,cost,index+2));
        return cache[index];
    }
}