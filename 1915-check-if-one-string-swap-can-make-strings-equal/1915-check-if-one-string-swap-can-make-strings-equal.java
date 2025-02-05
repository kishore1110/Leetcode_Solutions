class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int misMatchCount=0;
        int left=0;
        int right=0;
        int s1Index=-1;
        int s2Index=-1;
        while(right<s1.length()){
            if(s1.charAt(left)!=s2.charAt(right)){
                misMatchCount++;
                if(s1Index==-1){
                    s1Index=left;
                }
                else{
                    s2Index=left;
                }
            }
            right++;
            left++;
        }
        if(misMatchCount!=2){
            return false;
        }
        return s1.charAt(s1Index)==s2.charAt(s2Index) && s2.charAt(s1Index)==s1.charAt(s2Index);
    }
}