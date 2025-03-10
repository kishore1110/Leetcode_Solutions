class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atleastK(nums,k)-atleastK(nums,k+1);
    }
    public int atleastK(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right;
        int result=0;
        for(right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(left<nums.length && map.size()>=k){
                result+=nums.length-right;
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return result;
    }
}