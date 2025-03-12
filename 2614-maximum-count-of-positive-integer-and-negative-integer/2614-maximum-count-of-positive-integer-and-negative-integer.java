class Solution {
    public int maximumCount(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int PosFirstindex=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>0){
                PosFirstindex=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        left=0;
        right=nums.length-1;
        int NegLastIndex=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<0){
                NegLastIndex=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        if(PosFirstindex==-1){
            return NegLastIndex+1;
        }
        return Math.max(NegLastIndex+1,nums.length-PosFirstindex);
    }
}