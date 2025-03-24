class Solution {
    public int minCapability(int[] nums, int k) {
        int low=Arrays.stream(nums).min().getAsInt();
        int high=Arrays.stream(nums).max().getAsInt();
        int result=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,k,nums)){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
    public boolean isValid(int value,int k,int[] nums){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=value){
                count++;
                i+=1;
            }
            if(count==k){
                return true;
            }
        }
        return count==k;
    }
}