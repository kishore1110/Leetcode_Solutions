class Solution {
    public int maximumCandies(int[] candies, long k) {
        long candieSum=0;
        for(int candie:candies){
            candieSum+=candie;
        }
        if(candieSum<k)return 0;
        int low=1;
        int high=(int)(candieSum/k);
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long childrenCanGet=0;
            for(int candie:candies){
                childrenCanGet+=candie/mid;
            }
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