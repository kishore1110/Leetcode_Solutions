class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[]freq=new int[2001];
        int distinct=0;
        for(int num:nums){
            if(freq[num]==0){
                distinct++;
                freq[num]=1;
            }
        }
        Arrays.fill(freq,0);
        int left=0;
        int right;
        int subArrayCount=0;
        int currentDistinct=0;
        for(right=0;right<nums.length;right++){
            if(freq[nums[right]]==0){
                currentDistinct++;
            }
            freq[nums[right]]++;
            while(currentDistinct==distinct){
                subArrayCount+=nums.length-right;
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    currentDistinct--;
                }
                left++;
            }
        }
        return subArrayCount;
    }
}