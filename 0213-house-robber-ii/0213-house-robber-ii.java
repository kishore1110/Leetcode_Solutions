class Solution {
    public int rob(int[] nums) {
        // my solution
//         int[] memoFalse = new int[nums.length];
//         int[] memoTrue=new int[nums.length];
//         Arrays.fill(memoTrue, -1);
//         Arrays.fill(memoFalse, -1);
//         return dfs(0, nums, memoTrue,memoFalse,false);
//     }
//     private int dfs(int index, int[] nums, int[] memoTrue,int[] memoFalse,boolean flag) {
//         if (index >= nums.length) return 0;
//         if(flag && index==nums.length-1)return 0;
//         if(flag && memoTrue[index]!=-1){
//             return memoTrue[index];
//         }
//         else if(memoFalse[index] != -1) return memoFalse[index];
//         int robCurrent;
//         if(index==0){
//             robCurrent = nums[index] + dfs(index + 2, nums, memoTrue,memoFalse,true);
//         }
//         else robCurrent = nums[index] + dfs(index + 2, nums, memoTrue,memoFalse,flag);
//         int skipCurrent = dfs(index + 1, nums, memoTrue,memoFalse,flag);
//         if(flag){
//             memoTrue[index]=Math.max(robCurrent,skipCurrent);
//             return memoTrue[index];
//         }
//         memoFalse[index] = Math.max(robCurrent, skipCurrent);
//         return memoFalse[index];
//     }
// }
        if(nums.length==1){
            return nums[0]; // sanity
        }
        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);
        // include first element
        int answerOne=dfs(0,nums,memo,nums.length-1);
        Arrays.fill(memo,-1);
        // include last element
        int answerTwo=dfs(1,nums,memo,nums.length);
        return Math.max(answerOne,answerTwo);
    }
    public int dfs(int index,int[] nums,int[] memo,int length){
        if(index>=length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int include=nums[index]+dfs(index+2,nums,memo,length);
        int skip=dfs(index+1,nums,memo,length);
        memo[index]=Math.max(include,skip);
        return memo[index];
    }
}