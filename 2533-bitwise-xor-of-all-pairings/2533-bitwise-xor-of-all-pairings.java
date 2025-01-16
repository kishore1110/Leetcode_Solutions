class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums2.length%2==0){
            if(nums1.length%2==0){
                return 0;
            }
            else{
                int res=0;
                for(int value:nums2){
                    res^=value;
                }
                return res;
            }
        }
        else{
            if(nums1.length%2==0){
                int res=0;
                for(int value:nums1){
                    res^=value;
                }
                return res;
            }
            else{
                int res=0;
                for(int value:nums1){
                    res^=value;
                }
                for(int value:nums2){
                    res^=value;
                }

                return res;
            }
        }
    }
}