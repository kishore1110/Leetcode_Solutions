class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> memo=new HashMap<>();
        return dp(nums,target,0,0,memo);
    }
    public int dp(int[] nums,int target,int index,int currSum,HashMap<String,Integer> memo){
        if(index>=nums.length){
            return currSum==target?1:0;
        }
        String key=index+","+currSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int ans=dp(nums,target,index+1,currSum+nums[index],memo)+dp(nums,target,index+1,currSum-nums[index],memo);
        memo.put(key,ans);
        return ans;
    }
}