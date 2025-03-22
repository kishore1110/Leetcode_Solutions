class Solution {
    public int rob(int[] nums) {
        // int[] memo=new int[nums.length];
        // Arrays.fill(memo,-1);
        // int maxProfit=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     maxProfit=Math.max(maxProfit,dfs(i,nums,memo));
        // }
        // return maxProfit;
        int prev1=0;
        int prev2=0;
        int temp;
        for(int i=0;i<nums.length;i++){
            temp=Math.max(nums[i]+prev1,prev2);
            prev1=prev2;
            prev2=temp;
        }
        return prev2;
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