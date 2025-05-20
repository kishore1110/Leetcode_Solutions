class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxVal=(int)Math.pow(2,maximumBit)-1; //<k
        int[] result=new int[nums.length];
        int totalXor=0;
        for(int num:nums){
            totalXor^=num;
        }
        int last=nums.length-1;
        for(int i=0;i<nums.length;i++){
            result[i]=(totalXor^maxVal)&maxVal;
            totalXor^=nums[last];
            last--;
        }
        System.out.println(18^1);
        return result;
    }
}