class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] leftSmall=new int[n];
        int[] rightLarge=new int[n];
        leftSmall[0]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            leftSmall[i]=Math.min(nums[i-1],leftSmall[i-1]);
        }
        rightLarge[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            rightLarge[i]=Math.max(rightLarge[i+1],nums[i+1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>leftSmall[i] && nums[i]<rightLarge[i]){
                return true;
            }
        }
        return false;
    }
}