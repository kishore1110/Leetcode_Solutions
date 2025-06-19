class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=0;
        int result=1;
        for(int num:nums){
            if(num-min<=k){
                max=num;
            }
            else{
                result++;
                min=num;
            }
        }
        return result;
    }
}