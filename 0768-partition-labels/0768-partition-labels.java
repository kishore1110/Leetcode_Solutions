class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        int[] freq=new int[26];
        HashSet<Character> set=new HashSet<>();
        int prev=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
            freq[s.charAt(i)-'a']--;
            if(check(set,freq)){
                result.add((i+1)-prev);
                prev=i+1;
                set.clear();
            }
        }
        return result;
    }
    public boolean check(HashSet<Character> set,int[] freq){
        for(int i:set){
            if(freq[i-'a']>0){
                return false;
            }
        }
        return true;
    }
}