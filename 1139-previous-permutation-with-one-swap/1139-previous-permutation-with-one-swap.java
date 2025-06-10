class Solution {
    public int[] prevPermOpt1(int[] arr) {
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[i] && (j==i+1 || arr[j]!=arr[j-1])){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    return arr;
                }
            }
        }
        return arr;
    }
}