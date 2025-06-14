class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return dfs(s,wordDict,0,memo);
    }
    public boolean dfs(String s,List<String> wordDict,int index,int[] memo){
        if(index>=s.length()){
            return true;
        }
        if(memo[index]!=-1){
            return memo[index]==1?true:false;
        }
        for(String str:wordDict){
            if(index+str.length()<=s.length()){
                if(s.substring(index,index+str.length()).equals(str)){
                    if(dfs(s,wordDict,index+str.length(),memo)){
                        memo[index]=1;
                        return true;
                    }
                }
            }
        }
        memo[index]=0;
        return false;
    }
}