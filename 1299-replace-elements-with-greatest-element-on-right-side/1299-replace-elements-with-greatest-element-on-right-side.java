class Solution {
    public int[] replaceElements(int[] arr) {
        int length=arr.length;
        int[] result=new int[length];
        int maxElement=-1;
        for(int i=length-1;i>-1;i--){
            result[i]=maxElement;
            maxElement=Math.max(maxElement,arr[i]);
        }
        return result;
    }
}