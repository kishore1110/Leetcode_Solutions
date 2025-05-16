class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       int curr=groups[0];
       List<String> result=new ArrayList<>();
       result.add(words[0]);
       for(int i=1;i<groups.length;i++){
            if(groups[i]!=curr){
                curr=groups[i];
                result.add(words[i]);
            }
       }
       return result;
    }
}