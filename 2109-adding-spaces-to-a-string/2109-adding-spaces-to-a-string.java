class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder string=new StringBuilder(s);
        int index=0;
        for(int i:spaces){
            string.insert(i+index," ");
            index++;
        }
        return new String(string);
    }
}