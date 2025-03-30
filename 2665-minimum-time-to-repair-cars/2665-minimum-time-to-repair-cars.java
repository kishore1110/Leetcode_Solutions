class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1;
        int max=Arrays.stream(ranks).max().getAsInt();
        long high=1L*max*cars*cars;
        long result=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            long count=0;
            for(int r:ranks){
                count+=(long)Math.sqrt(mid/(long)r);
                if(count>=cars)break;
            }
            if(count>=cars){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
}