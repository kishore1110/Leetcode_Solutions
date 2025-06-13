class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int value:nums){
            totalSum+=value;
        }
        if(totalSum%2==1){
            return false;
        }
        int[][] memo=new int[nums.length][totalSum/2+1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return backtrack(nums,0,0,totalSum,memo);
    }
    public boolean backtrack(int[] nums,int index,int currentSum,int totalSum,int[][] memo){
        if(2*currentSum==totalSum){
            return true;
        }
        if(2*currentSum>totalSum || index>=nums.length){
            return false;
        }
        if(memo[index][currentSum]!=-1){
            return memo[index][currentSum]==1?true:false;
        }
        boolean ans=backtrack(nums,index+1,currentSum+nums[index],totalSum,memo) || backtrack(nums,index+1,currentSum,totalSum,memo);
        memo[index][currentSum]=ans==true?1:0;
        return ans;
    }
}