class Solution {
    public int numDecodings(String s) {
        int[] memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return dp(s,0,memo);
    }
    public int dp(String s,int index,int[] memo){
        if(index>=s.length()){
            return 1;
        }
        if(s.charAt(index)=='0'){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int ans=0;
        ans+=dp(s,index+1,memo);
        if (index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if (num >= 10 && num <= 26) {
                ans += dp(s, index + 2, memo);
            }
        }
        memo[index]=ans;
        return ans;
    }
}