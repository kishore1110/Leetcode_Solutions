class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount=0;
        int incCount=1;
        int decCount=1;
        // increaseing order
        for(int i=1;i<nums.length;i++){
            maxCount=Math.max(maxCount,Math.max(decCount,incCount));
            if(nums[i]>nums[i-1]){
                decCount=1;
                incCount++;
            }
            else if(nums[i]<nums[i-1]){
                incCount=1;
                decCount++;
            }
            else{
                decCount=1;
                incCount=1;
            }
        }
        maxCount=Math.max(maxCount,Math.max(decCount,incCount));
        return maxCount;
    }
}