class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int minLength=s.length();
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']>1){
                minLength-=2;
                freq[s.charAt(i)-'a']-=2;
            }
            freq[s.charAt(i)-'a']+=1;
        }
        return minLength;
    }
}