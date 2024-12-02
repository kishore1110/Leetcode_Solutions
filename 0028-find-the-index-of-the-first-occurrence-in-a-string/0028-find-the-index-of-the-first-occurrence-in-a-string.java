class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength=needle.length();
        for(int i=0;i<=haystack.length()-needleLength;i++){
            if(haystack.substring(i,i+needleLength).equals(needle))return i;
        }
        return -1;
    }
}