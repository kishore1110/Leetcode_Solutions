class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
       int totalXor=0;
       int maxVal=(int)Math.pow(2,maximumBit)-1;
       for(int i:nums){
        totalXor^=i;
       } 
       int []result=new int[nums.length];
       int index=0;
       for(int i=nums.length-1;i>-1;i--){
            result[index]=totalXor^maxVal;
            index++;
            totalXor^=nums[i];
       }
       return result;
    }
}