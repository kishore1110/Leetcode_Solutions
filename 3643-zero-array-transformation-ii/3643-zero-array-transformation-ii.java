class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length+1];
        int prefixSum=0;
        int index=0;
        int count=0;
        while(index<nums.length && diff[index]+prefixSum>=nums[index]){ // if all nums are 0
            prefixSum+=diff[index];
            index++;
        }
        if(index>=nums.length){
            return count;
        }
        for(int[] query:queries){
            count++;
            int l=query[0];
            int r=query[1];
            int val=query[2];
            if(r<index)continue;  // already they become zero
            l=Math.max(l,index);
            diff[l]+=val;
            diff[r+1]-=val;
            while(index<nums.length && diff[index]+prefixSum>=nums[index]){
                prefixSum+=diff[index];
                index++;
            }
            if(index>=nums.length){
                return count;
            }
        }
        return -1;
    }
}