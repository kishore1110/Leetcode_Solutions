class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleastK(word,k)-atleastK(word,k+1);
    }
    public long atleastK(String word,int k){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        int left=0;
        int right;
        long result=0;
        int constantCount=0;
        for(right=0;right<word.length();right++){
            if(map.containsKey(word.charAt(right))){
                map.put(word.charAt(right),map.getOrDefault(word.charAt(right),0)+1);
            }
            else{
                constantCount++;
            }
            while(left<word.length() && check(map) && constantCount>=k){
                if(map.containsKey(word.charAt(left))){
                    map.put(word.charAt(left),map.getOrDefault(word.charAt(left),0)-1);
                }
                else{
                    constantCount--;
                }
                left++;
                result+=word.length()-right;
            }
        }
        return result;
    }
    public boolean check(HashMap<Character,Integer> map){
        return map.get('a')>0 && map.get('e')>0 && map.get('i')>0 && map.get('o')>0 && map.get('u')>0 ;
    }
}