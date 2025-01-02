class Solution {
    public boolean rotateString(String s, String goal) {
        String rotatedString=s+s;
        return s.length()==goal.length() && rotatedString.indexOf(goal)!=-1;
    }
}