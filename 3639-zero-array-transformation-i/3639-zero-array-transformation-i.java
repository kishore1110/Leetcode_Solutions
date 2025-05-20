class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] differenceArray=new int[nums.length];
        differenceArray[0]=0;
        for(int i=1;i<nums.length;i++){
            differenceArray[i]=nums[i]-nums[i-1];
        }
        for(int[] q:queries){
            int l=q[0];
            int r=q[1];
            differenceArray[l]-=1;
            if(r!=nums.length-1){
                differenceArray[r+1]+=1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                nums[i]+=differenceArray[i];
            }
            else{
                nums[i]=nums[i-1]+differenceArray[i];
            }
            if(nums[i]>0){
                return false;
            }
        }
        return true;
    }
}