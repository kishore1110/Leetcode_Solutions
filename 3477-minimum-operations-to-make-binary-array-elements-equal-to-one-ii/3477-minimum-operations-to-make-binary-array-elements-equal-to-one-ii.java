class Solution {
    public int minOperations(int[] nums) {
        int flipCount=0;
        int changed=0;
        for(int i=0;i<nums.length;i++){
            if(changed==0){
                if(nums[i]==0){
                    flipCount++;
                    changed^=1;
                }
            }
            else{
                if((nums[i]^1)==0){
                    flipCount++;
                    changed^=1;
                }
            }
        }
        return flipCount;
    }
}