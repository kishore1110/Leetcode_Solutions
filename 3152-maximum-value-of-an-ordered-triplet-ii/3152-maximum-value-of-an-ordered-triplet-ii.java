class Solution {
    public long maximumTripletValue(int[] nums) {
        long result=0;
        long maxDifference=0;
        int maxValue=nums[0];
        for(int i=0;i<nums.length;i++){
            result=Math.max(1L*nums[i]*maxDifference,result);
            maxDifference=Math.max(maxDifference,maxValue-nums[i]);
            maxValue=Math.max(maxValue,nums[i]);
        }
        return result;
    }
}