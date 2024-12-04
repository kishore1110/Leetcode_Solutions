class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
            char nextChar=str1.charAt(i)=='z'?'a':(char)(str1.charAt(i)+1);
            if(str1.charAt(i)==str2.charAt(j) || nextChar==str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j==str2.length()?true:false;
    }
}