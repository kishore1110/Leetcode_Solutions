class Solution {
    public int[] applyOperations(int[] nums) {
        int i=0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
                i+=2;
            }
            else{
                i++;
            }
        }
        int index=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }
        return nums;
    }
}