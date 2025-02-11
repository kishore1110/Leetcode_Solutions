class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder string=new StringBuilder(s);
        int flag=0;
        while(flag==0){
            int innerflag=0;
            for(int i=0;i<=string.length()-part.length();i++){
                if(string.substring(i,i+part.length()).equals(part)){
                    string.delete(i,i+part.length());
                    innerflag=1;
                    break;
                }
            }
            if(innerflag==0){
                flag=1;
            }
        }
        return new String(string);
    }
}