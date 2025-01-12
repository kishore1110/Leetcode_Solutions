class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0)return false;
        int opened=0;
        int wildCard=0;
        int closed=0;
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0')wildCard++;
            else if(s.charAt(i)=='(')opened++;
            else closed++;
            if(closed>opened+wildCard)return false; 
        }
        opened=0;
        wildCard=0;
        closed=0;
        for(int i=s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0')wildCard++;
            else if(s.charAt(i)=='(')opened++;
            else closed++;
            if(opened>closed+wildCard)return false;
        }
        return true;
    }
}