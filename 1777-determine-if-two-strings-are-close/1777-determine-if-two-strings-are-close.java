class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<word1.length();i++){
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0)+1);
            freq1[word1.charAt(i)-'a']++;
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0)+1);
            freq2[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i]==0 && freq2[i]!=0 || freq2[i]==0 && freq1[i]!=0){
                return false;
            }
        }
        int[] word1Array=new int[map1.size()];
        int[] word2Array=new int[map2.size()];
        int index=0;
        for(int value:map1.values()){
            word1Array[index++]=value;
        }
        index=0;
        for(int value:map2.values()){
            word2Array[index++]=value;
        }
        Arrays.sort(word1Array);
        Arrays.sort(word2Array);
        return Arrays.equals(word2Array,word1Array);
    }
}