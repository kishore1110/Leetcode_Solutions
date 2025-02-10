class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int pairCount=0;
        for(int value:nums){
            if(map.containsKey(value+k)){
                pairCount+=map.get(value+k);
            }
            if(map.containsKey(value-k)){
                pairCount+=map.get(value-k);
            }
            map.put(value,map.getOrDefault(value,0)+1);
        }
        return pairCount;
    }
}