class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int value:nums){
            prefixSum+=value;
            int required=prefixSum-goal;
            if(map.containsKey(required)){
                count+=map.get(required);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}