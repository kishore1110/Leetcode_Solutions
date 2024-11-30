class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int value:nums){
            map.put(value,map.getOrDefault(value,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        list.sort((a,b)->map.get(a)==map.get(b)?b.compareTo(a):map.get(a).compareTo(map.get(b)));
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }
        return nums;
    }
}