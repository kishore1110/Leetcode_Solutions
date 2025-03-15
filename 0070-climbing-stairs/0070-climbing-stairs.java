class Solution {
    public int climbStairs(int n) {
        int[] cache=new int[n];
        Arrays.fill(cache,-1);
        return backtrack(n,0,cache);
    }
    public int backtrack(int n,int step,int[] cache){
        if(step==n){
            return 1;
        }
        if(step>n){
            return 0;
        }
        if(cache[step]!=-1){
            return cache[step];
        }
        cache[step]=backtrack(n,step+1,cache)+backtrack(n,step+2,cache);
        return cache[step];
    }
}