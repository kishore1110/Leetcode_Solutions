class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int leftBehindPair=0;
        long badPairCount=0;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-i;
            badPairCount+=leftBehindPair;
            if(map.containsKey(diff)){
                badPairCount-=map.get(diff);
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
            leftBehindPair++;
        }
        return badPairCount;
    }
}