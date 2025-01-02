class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] prefixSum=new int[words.length];
        for(int i=0;i<words.length;i++){
            if(i!=0){
                prefixSum[i]=prefixSum[i-1];
            }
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length()-1))){
                prefixSum[i]+=1;
            }
        }
        int[] result=new int[queries.length];
        int index=0;
        for(int[] query:queries){
            int start=query[0];
            int end=query[1];
            if(start==0){
                result[index++]=prefixSum[end];
            }
            else{
                 result[index++]=prefixSum[end]-prefixSum[start-1];
            }
        }
        return result;
    }
}