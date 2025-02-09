class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int leftBehindPair=0;
        int badPairCount=0;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-i;
            if(map.containsKey(diff)){
                badPairCount+=leftBehindPair-map.get(diff);
                map.put(diff,map.get(diff)+1);
            }
            else{
                map.put(diff,1);
                badPairCount+=leftBehindPair;
            }
            leftBehindPair++;
        }
        return badPairCount;
    }
}