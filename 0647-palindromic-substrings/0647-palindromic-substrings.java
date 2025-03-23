class Solution {
    public int countSubstrings(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            // odd length
            int left=i;
            int right=i;
            while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
            // even length
            left=i;
            right=i+1;
            while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}