class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        for(char i='a';i<='z';i++){
            int first=s.indexOf(i);
            int last=s.lastIndexOf(i);
            if(last>first+1){
                HashSet<Character> set=new HashSet<>();
                for(int j=first+1;j<last;j++){
                    set.add(s.charAt(j));
                }
                count+=set.size();
            }
        }
        return count;
    }
}