class Solution {
    public int rob(int[] nums) {
        int[] memoFalse = new int[nums.length];
        int[] memoTrue=new int[nums.length];
        Arrays.fill(memoTrue, -1);
        Arrays.fill(memoFalse, -1);
        return dfs(0, nums, memoTrue,memoFalse,false);
    }
    private int dfs(int index, int[] nums, int[] memoTrue,int[] memoFalse,boolean flag) {
        if (index >= nums.length) return 0;
        if(flag && index==nums.length-1)return 0;
        if(flag && memoTrue[index]!=-1){
            return memoTrue[index];
        }
        else if(memoFalse[index] != -1) return memoFalse[index];
        int robCurrent;
        if(index==0){
            robCurrent = nums[index] + dfs(index + 2, nums, memoTrue,memoFalse,true);
        }
        else robCurrent = nums[index] + dfs(index + 2, nums, memoTrue,memoFalse,flag);
        int skipCurrent = dfs(index + 1, nums, memoTrue,memoFalse,flag);
        if(flag){
            memoTrue[index]=Math.max(robCurrent,skipCurrent);
            return memoTrue[index];
        }
        memoFalse[index] = Math.max(robCurrent, skipCurrent);
        return memoFalse[index];
    }
}