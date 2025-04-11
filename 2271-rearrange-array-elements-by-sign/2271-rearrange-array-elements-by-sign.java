class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result=new int[nums.length];
        int po=0;
        int ne=1;
        for(int num:nums){
            if(num>0){
                result[po]=num;
                po+=2;
            }
            else{
                result[ne]=num;
                ne+=2;
            }
        }
        return result;
    }
}