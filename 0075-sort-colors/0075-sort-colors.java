class Solution {
    public void sortColors(int[] arr) {
        // int left=0;
        // int right=nums.length-1;
        // int current=0;
        // while(current<=right){
        //     if(nums[current]==0){
        //         swap(nums,left,current);
        //         left++;
        //         current++;
        //     }
        //     else if(nums[current]==1){
        //         current++;
        //     }
        //     else{
        //         swap(nums,current,right);
        //         right--;
        //     }
        // }
        int oneCount=0;
        int zeroCount=0;
        for(int i: arr){
            if(i==1)oneCount++;
            else if(i==0)zeroCount++;
        }
        for(int i=0;i<zeroCount;i++){
            arr[i]=0;
        }
        for(int i=zeroCount;i<zeroCount+oneCount;i++){
            arr[i]=1;
        }
        for(int i=zeroCount+oneCount;i<arr.length;i++){
            arr[i]=2;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}