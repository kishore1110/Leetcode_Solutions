class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        
        // second time add memo
        long totalSum=1;
        for(int num:nums){
            totalSum*=num;
        }
        HashMap<String,Boolean> memo=new HashMap<>();
        return backtrack(nums,0,target,totalSum,1,0,memo);
    }
    public boolean backtrack(int[] nums,int index,long target,long totalSum,long curr,int count,HashMap<String,Boolean> memo){
        if(curr>target){
            return false;
        }
        if(count>0 && count<nums.length && curr==target && totalSum==target*curr){
            return true;
        }
        if(index>=nums.length){
            return false;
        }
        String key=index+","+curr;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        boolean ans=backtrack(nums,index+1,target,totalSum,curr*nums[index],count+1,memo) || backtrack(nums,index+1,target,totalSum,curr,count,memo);
        memo.put(key,ans);
        return ans;
    }
}