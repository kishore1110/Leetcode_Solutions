class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left=0;
        int length=nums.length;
        long currResult=0;
        long result=0;
        HashSet<Integer> set=new HashSet<>();
        for(int right=0;right<length;right++){
            if(!set.contains(nums[right])){
                currResult+=nums[right];
                set.add(nums[right]);
                if(right-left+1==k){
                    result=Math.max(result,currResult);
                    currResult-=nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
            else{
                while(nums[left]!=nums[right]){
                    set.remove(nums[left]);
                    currResult-=nums[left];
                    left++;
                }
                left++;
            }
        }
        return result;
    }
}