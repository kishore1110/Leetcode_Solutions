class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int left=0;
        int right=0;
        int result=0;
        while(right<s.length()){
            freq[s.charAt(right)-'a']++;
            while(check(freq)){
                result+=s.length()-right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
    public boolean check(int[] freq){
        return freq[0]>0 && freq[1]>0 && freq[2]>0;
    }
}