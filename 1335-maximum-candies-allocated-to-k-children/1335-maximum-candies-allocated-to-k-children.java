class Solution {
    public int maximumCandies(int[] candies, long k) {
        int  maxCandie=Integer.MIN_VALUE;
        for(int candie:candies){
            maxCandie=Math.max(candie,maxCandie);
        }
        int low=1;
        int high=maxCandie;
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long childrenCanGet=0;
            for(int candie:candies){
                childrenCanGet+=candie/mid;
            }
            System.out.println(childrenCanGet);
            if(childrenCanGet>=k){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }
}