class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(valid(words[i],words[j]))count++;
            }
        }
        return count;
    }
    public boolean valid(String str1,String str2){
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}