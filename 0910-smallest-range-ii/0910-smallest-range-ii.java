class Solution {
    public int smallestRangeII(int[] arr, int k) {
        Arrays.sort(arr);
        int length=arr.length;
        int minDifference=arr[length-1]-arr[0];
        int smallest=arr[0]+k;
        int largest=arr[length-1]-k;
        for(int i=1;i<length;i++){
                int min=Math.min(smallest,arr[i]-k);
                int max=Math.max(arr[i-1]+k,largest);
                minDifference=Math.min(max-min,minDifference);
        }
        return minDifference;
    }
}