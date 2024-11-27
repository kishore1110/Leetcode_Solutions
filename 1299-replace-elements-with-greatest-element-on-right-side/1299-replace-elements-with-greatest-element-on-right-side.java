class Solution {
    public int[] replaceElements(int[] arr) {
        int length=arr.length;
        int[] result=new int[length];
        int maxElement=-1;
        for(int i=length-1;i>-1;i--){
            if(arr[i]>maxElement){
                result[i]=maxElement;
                maxElement=arr[i];
            }
            else{
                result[i]=maxElement;
            }
        }
        return result;
    }
}