class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] rightLarge=new int[n];
        rightLarge[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            rightLarge[i]=Math.max(rightLarge[i+1],nums[i+1]);
        }
        int small=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>small && nums[i]<rightLarge[i]){
                return true;
            }
            small=Math.min(small,nums[i]);
        }
        return false;
    }
}