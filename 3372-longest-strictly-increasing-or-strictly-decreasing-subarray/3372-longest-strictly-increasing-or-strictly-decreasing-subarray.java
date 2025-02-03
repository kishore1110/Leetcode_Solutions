class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount=0;
        int currCount=0;
        // increaseing order
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                currCount++;
            }
            else{
                maxCount=Math.max(currCount+1,maxCount);
                currCount=0;
            }
        }
        maxCount=Math.max(currCount+1,maxCount);
        // decreasing order
        currCount=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                currCount++;
            }
            else{
                maxCount=Math.max(currCount+1,maxCount);
                currCount=0;
            }
        }
        maxCount=Math.max(currCount+1,maxCount);
        return maxCount;
    }
}