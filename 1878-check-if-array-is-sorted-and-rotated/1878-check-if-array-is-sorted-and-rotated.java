class Solution {
    public boolean check(int[] nums) {
        int breakingPoint=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                breakingPoint++;
            }
        }
        if(breakingPoint>1){
            return false;
        }
        else if(breakingPoint==0){
            return true;
        }
        return nums[nums.length-1]<=nums[0];
    }
}