class Solution {
    public int[] sortedSquares(int[] nums) {
         //Use Two Pointer for better time complexity
         int left=0;
         int right=nums.length-1;
         int i=nums.length-1;
         int []result=new int[nums.length];
         while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[i--]=nums[left]*nums[left];
                left++;
            }
            else{
                result[i--]=nums[right]*nums[right];
                right--;
            }
         }
         return result;
    }
}