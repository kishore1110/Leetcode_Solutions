class Solution {
    public int rob(int[] nums) {
        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxProfit=Math.max(maxProfit,dfs(i,nums,memo));
        }
        return maxProfit;
    }
    public int dfs(int index,int[] nums,int[] memo){
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int base=nums[index];
        int maxProfit=base;
        for(int i=index+2;i<nums.length;i++){
            maxProfit=Math.max(maxProfit,base+dfs(i,nums,memo));
        }
        memo[index]=maxProfit;
        return memo[index];
    }
}