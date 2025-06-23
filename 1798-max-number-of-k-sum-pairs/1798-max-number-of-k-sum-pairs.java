class Solution {
    public int maxOperations(int[] nums, int k) {
        // Arrays.sort(nums);
        // int left=0;
        // int right=nums.length-1;
        // int result=0;
        // while(left<right){
        //     int sum=nums[left]+nums[right];
        //     if(sum==k){
        //         result++;
        //         left++;
        //         right--;
        //     }
        //     else if(sum<k){
        //         left++;
        //     }
        //     else{
        //         right--;
        //     }
        // }
        // return result;
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        for(int num:nums){
            int required=k-num;
            if(map.containsKey(required) && map.get(required)>0){
                result++;
                map.put(required,map.get(required)-1);
            }
            else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return result;
    }
}