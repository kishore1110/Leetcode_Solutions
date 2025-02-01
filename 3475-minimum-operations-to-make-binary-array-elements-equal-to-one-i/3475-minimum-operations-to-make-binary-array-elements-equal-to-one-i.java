class Solution {
    public int minOperations(int[] nums) {
        int flipCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(i+2>=nums.length){
                    return -1;
                }
                nums[i+1]^=1;
                nums[i+2]^=1;
                flipCount++;
            }
        }
        return flipCount;
    }
}