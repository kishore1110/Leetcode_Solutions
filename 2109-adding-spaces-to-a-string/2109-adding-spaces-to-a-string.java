class Solution {
    public String addSpaces(String s, int[] spaces) {
        //StringBuilder string=new StringBuilder(s);
        // int index=0;
        // for(int space:spaces){
        //     string.insert(space+index," ");
        //     index++;
        // }
        // return new String(string);
        //insert shift the characters so more time complexity so try to use append
        StringBuilder string=new StringBuilder();
        int start=0;
        for(int space:spaces){
            string.append(s,start,space).append(" ");
            start=space;
        }
        string.append(s.substring(start));
        return new String(string);
    }
}