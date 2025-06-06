class Solution {
    int result=0;
    public int findTargetSumWays(int[] nums, int target) {
        dp(nums,target,0,0);
        return result;
    }
    public void dp(int[] nums,int target,int index,int currSum){
        if(index>=nums.length){
            if(currSum==target){
                result++;
            }
            return;
        }
        dp(nums,target,index+1,currSum+nums[index]);
        dp(nums,target,index+1,currSum-nums[index]);
    }
}