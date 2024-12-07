class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++)set.add(jewels.charAt(i));
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
    //the above code O(N*M) if i use set(jewels) to check it will become O(N+M)
    // in the second visit i change into set
    // below is the previous code
    // public int numJewelsInStones(String jewels, String stones) {
    //     int count=0;
    //     for(int i=0;i<stones.length();i++){
    //         if(check(jewels,stones.charAt(i))){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // public boolean check(String jewels,char ch){
    //     for(int i=0;i<jewels.length();i++){
    //         if(jewels.charAt(i)==ch){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}