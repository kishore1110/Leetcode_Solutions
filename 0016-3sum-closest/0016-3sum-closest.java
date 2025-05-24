class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<arr.length-2;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                int d=Math.abs(target-sum);
                if(d==0)return sum;
                else if(d==diff && sum>result){
                    result=sum;
                }
                else if(d<diff){
                    diff=d;
                    result=sum;
                }
                if(sum>target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }
}