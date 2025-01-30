class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small=Integer.MAX_VALUE;
        int big=Integer.MAX_VALUE;
        for(int value:nums){
            if(value<=small){
                small=value;
            }
            else if(value<=big){
                big=value;
            }
            else{
                return true;
            }
        }
        return false;
    }
}