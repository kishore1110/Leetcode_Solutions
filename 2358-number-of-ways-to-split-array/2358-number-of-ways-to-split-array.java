class Solution {
    public int waysToSplitArray(int[] nums) {
        // need space
        // int[] leftSum=new int[nums.length];
        // int[] rightSum=new int[nums.length];
        // leftSum[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     leftSum[i]=leftSum[i-1]+nums[i];
        // }
        // rightSum[nums.length-1]=nums[nums.length-1];
        // for(int i=nums.length-2;i>=0;i--){
        //     rightSum[i]=rightSum[i+1]+nums[i];
        // }
        // int validSplits=0;
        // for(int i=0;i<nums.length-1;i++){
        //     if(leftSum[i]>=rightSum[i+1]){
        //         validSplits++;
        //     }
        // }
        // return validSplits;
        // another good idea
        long totalSum=0;
        for(int value:nums){
            totalSum+=value;
        }
        int validSplits=0;
        long currSum=0;
        for(int i=0;i<nums.length-1;i++){
            currSum+=nums[i];
            if(currSum>=(totalSum-currSum)){
                validSplits++;
            }
        }
        return validSplits;
    }
}