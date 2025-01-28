class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int subCount=0;
        int prefixCount=0;
        for(int value:nums){
            prefixCount+=value%2;
            int required=prefixCount-k;
            if(map.containsKey(required)){
                subCount+=map.get(required);
            }
            map.put(prefixCount,map.getOrDefault(prefixCount,0)+1);
        }
        return subCount;
    }
}