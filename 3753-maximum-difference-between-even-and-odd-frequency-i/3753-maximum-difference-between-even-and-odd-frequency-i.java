class Solution {
    public int maxDifference(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int oddMax=0;
        int oddMin=101;
        int evenMax=0;
        int evenMin=101;
        for(int frq:freq){
            if(frq==0)continue;
            if(frq%2==0){
                if(frq>evenMax){
                    evenMax=frq;
                }
                if(frq<evenMin){
                    evenMin=frq;
                }
            }
            else{
                if(frq>oddMax){
                    oddMax=frq;
                }
                if(frq<oddMin){
                    oddMin=frq;
                }
            }
        }
        int result=oddMax-evenMin;
        if(result<0){
            result=Math.max(result,oddMin-evenMin);
        }
        return result;
    }
}