class Solution {
    public int maxDepth(String s) {
        int maxCount=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                maxCount=Math.max(maxCount,++open);
            }
            else if(s.charAt(i)==')'){
                open--;
            }
        }
        return maxCount;
    }
}