class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] result=new int[n/3][3];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int num:nums){
            int outerIndex=index/3;
            int innerIndex=index%3;
            max=Math.max(num,max);
            min=Math.min(num,min);
            if(innerIndex==2){
                if(max-min>k)return new int[][]{};
                max=Integer.MIN_VALUE;
                min=Integer.MAX_VALUE;
            }
            result[outerIndex][innerIndex]=num;
            index++;
        }
        return result;
    }
}