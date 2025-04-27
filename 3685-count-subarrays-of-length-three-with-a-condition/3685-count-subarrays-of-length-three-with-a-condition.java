class Solution {
    public int countSubarrays(int[] nums) {
        int subArray=0;
        int left=0;
        int right;
        for(right=2;right<nums.length;right++){
            if(2*(nums[left]+nums[right])==nums[right-1]){
                subArray++;
            }
            left++;
        }
        return subArray;
    }
}