class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);   
    }
    public int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int result=0;
        int left=0;
        int currOddCount=0;
        for(int right=0;right<nums.length;right++){
            currOddCount+=nums[right]%2;
            while(currOddCount>goal){
                currOddCount-=nums[left]%2;
                left++;
            }
            result+=(right-left+1);
        }
        return result;
    }
}