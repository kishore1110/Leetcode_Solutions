class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo=new int[s1.length()+1][s2.length()+1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return dp(s1,s2,s3,0,0,0,memo);
    }
    public boolean dp(String s1, String s2, String s3,int index1,int index2,int index3,int[][] memo){
        if(index3>=s3.length()){
            if(index1>=s1.length() && index2>=s2.length())return true;
            return false;
        }
        if(memo[index1][index2]!=-1){
            return memo[index1][index2]==1?true:false;
        }
        boolean ans=false;
        if(index1<s1.length() && s1.charAt(index1)==s3.charAt(index3)){
            ans|=dp(s1,s2,s3,index1+1,index2,index3+1,memo);
        }
        if(index2<s2.length() && s2.charAt(index2)==s3.charAt(index3)){
            ans|= dp(s1,s2,s3,index1,index2+1,index3+1,memo);
        }
        memo[index1][index2]=ans==true?1:0;
        return ans;
    }
}