class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0;
        int equal=0;
        for(int value:nums){
            if(value==pivot)equal++;
            else if(value<pivot)less++;
        }
        int left=0;
        int mid=less;
        int right=less+equal;
        int [] result=new int[nums.length];
        for(int value:nums){
            if(value==pivot){
                result[mid++]=value;
            }
            else if(value<pivot){
                result[left++]=value;
            }
            else{
                result[right++]=value;
            }
        }
        return result;
    }
}