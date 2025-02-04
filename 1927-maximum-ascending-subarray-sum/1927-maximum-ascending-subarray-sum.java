class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum=0;
        int currSum=0;
        int i;
        for(i=0;i<nums.length-1;i++){
            currSum+=nums[i];
            if(nums[i]>=nums[i+1]){
                maxSum=Math.max(maxSum,currSum);
                currSum=0;
            }
        }
        maxSum=Math.max(maxSum,currSum+nums[i]);
        return maxSum;
    }
}