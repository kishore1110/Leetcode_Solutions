class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        
        // second time add memo
        long totalSum=1;
        for(int num:nums){
            totalSum*=num;
        }
        return backtrack(nums,0,target,totalSum,1,0);
    }
    public boolean backtrack(int[] nums,int index,long target,long totalSum,long curr,int count){
        if(curr>target){
            return false;
        }
        if(count>0 && count<nums.length && curr==target && totalSum==target*curr){
            return true;
        }
        if(index>=nums.length){
            return false;
        }
        return backtrack(nums,index+1,target,totalSum,curr*nums[index],count+1) || backtrack(nums,index+1,target,totalSum,curr,count);
    }
}