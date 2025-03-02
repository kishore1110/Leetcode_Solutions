class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int left=0;
        int right=0;
        ArrayList<int[]> result=new ArrayList<>();
        while(left<nums1.length && right<nums2.length){
            int elem1=nums1[left][0];
            int elem2=nums2[right][0];
            if(elem1==elem2){
                result.add(new int[]{elem1,nums1[left][1]+nums2[right][1]});
                left++;
                right++;
            }
            else if(elem1<elem2){
                result.add(new int[]{elem1,nums1[left][1]});
                left++;
            }
            else{
                result.add(new int[]{elem2,nums2[right][1]});
                right++;
            }
        }
        while(left<nums1.length){
            result.add(nums1[left]);
            left++;
        }
        while(right<nums2.length){
            result.add(nums2[right]);
            right++;
        }
        int[][] arr=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;
    }
}