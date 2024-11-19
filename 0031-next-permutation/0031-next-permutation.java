class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int i;
        for(i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                findNextGreaterElement(arr,i);
                break;
            }
        }
        if(i==-1){
            Arrays.sort(arr);
        }
    }
    public void findNextGreaterElement(int []arr,int start){
        int nextI=-1;
        int number=arr[start];
        int n=arr.length;
        for(int i=start+1;i<n;i++){
            if(arr[i]>number){
                nextI=i;
            }
        }
        if(nextI!=-1){
            int temp=number;
            arr[start]=arr[nextI];
            arr[nextI]=temp;
            reverse(arr,start+1,n-1);
        }
    }
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}