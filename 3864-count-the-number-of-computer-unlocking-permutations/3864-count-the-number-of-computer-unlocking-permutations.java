class Solution {
    public int countPermutations(int[] complexity) {
        int MOD=1000000000+7;
        int ans=1;
        for(int i=1;i<=complexity.length-1;i++){
            if(complexity[i]<=complexity[0])return 0;
            ans=(int)((1L*ans*i)%MOD);
        }
        return ans;
    }
}