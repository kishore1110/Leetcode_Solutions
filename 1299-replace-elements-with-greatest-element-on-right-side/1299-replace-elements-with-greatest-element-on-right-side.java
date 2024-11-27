class Solution {
    public int[] replaceElements(int[] arr) {
        int length=arr.length;
        int[] result=new int[length];
        int maxElement=arr[length-1];
        result[length-1]=-1;
        for(int i=length-2;i>-1;i--){
            result[i]=maxElement;
            maxElement=Math.max(maxElement,arr[i]);
        }
        return result;
    }
}