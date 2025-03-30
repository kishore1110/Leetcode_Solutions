class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        int[] freq=new int[26];
        HashSet<Integer> set=new HashSet<>();
        int prev=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i)-'a');
            if(i==freq[s.charAt(i)-'a']){
                set.remove(s.charAt(i)-'a');
            }
            if(set.size()==0){
                result.add((i+1)-prev);
                prev=i+1;
            }
        }
        return result;
    }
}