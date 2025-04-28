class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result=0;
        long count=0;
        int left=0;
        int right;
        long currentSum=0;
        long currentCount=0;
        for(right=0;right<nums.length;right++){
            currentSum+=nums[right];
            currentCount++;
            count++;
            while(currentSum*currentCount>=k){
                count--;
                currentSum-=nums[left];
                currentCount--;
                left++;
            }
            result+=count;
        }
        return result;
    }
}