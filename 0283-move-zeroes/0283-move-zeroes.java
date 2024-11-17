class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int last=n-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]==0){
                for(int j=i;j<last;j++){
                    nums[j]=nums[j+1];
                }
                nums[last]=0;
                last--;
            }
        }
        
    }
}