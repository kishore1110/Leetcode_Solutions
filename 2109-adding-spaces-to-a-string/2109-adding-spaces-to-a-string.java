class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder string=new StringBuilder(s);
        int []newSpaces =new int[spaces.length];
        for(int i=0;i<spaces.length;i++){
            newSpaces[i]=spaces[i]+i;
        }
        for(int i:newSpaces){
            string.insert(i," ");
        }
        return new String(string);
    }
}