class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount=0;
        int currCount=1;
        int decCount=1;
        // increaseing order
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                maxCount=Math.max(decCount,maxCount);
                decCount=1;
                currCount++;
            }
            else if(nums[i]<nums[i-1]){
                maxCount=Math.max(currCount,maxCount);
                currCount=1;
                decCount++;
            }
            else{
                maxCount=Math.max(currCount,maxCount);
                maxCount=Math.max(decCount,maxCount);
                decCount=1;
                currCount=1;
            }
        }
        maxCount=Math.max(currCount,maxCount);
        maxCount=Math.max(decCount,maxCount);
        return maxCount;
    }
}