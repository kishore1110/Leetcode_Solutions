class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;
        int maxCount=0;
        int left=0;
        int right;
        for(right=0;right<nums.length;right++){
            if(nums[right]==0)zero++;
            if(zero>k){
                maxCount=Math.max(maxCount,right-left);
                if(zero>k){
                    if(nums[left]==0)zero--;
                    left++;
                }
            }
        }
        maxCount=Math.max(maxCount,right-left);
        return maxCount;
    }
}