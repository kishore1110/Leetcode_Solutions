class Solution {
    int result=0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums,0,0);
        return result;
    }
    public void backtrack(int[] nums,int index,int currSum){
        if(index>=nums.length){
            return;
        }
        result+=currSum^nums[index];
        backtrack(nums,index+1,currSum^nums[index]);
        backtrack(nums,index+1,currSum);
    }
}