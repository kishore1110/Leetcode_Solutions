class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray=s.toCharArray();
        int[] prefix=new int[s.length()+1];
        for(int[] shift:shifts){
            if(shift[2]==1){
                prefix[shift[1]+1]+=1;
                prefix[shift[0]]-=1;
            }
            else{
                prefix[shift[1]+1]-=1;
                prefix[shift[0]]+=1;
            }
        }
        int diff=prefix[prefix.length-1];
        for(int i=s.length()-1;i>=0;i--){
            int newChar = ((charArray[i] - 'a' + diff) % 26 + 26) % 26;
            charArray[i] = (char) (newChar + 'a');
            diff+=prefix[i];
        }
        return new String(charArray);
    }
}