class Solution {
    public int minMaxDifference(int num) {
        int n=findLen(num);
        int[] arr=new int[n];
        int[] min=new int[n];
        int index=n-1;
        while(num>0){
            int temp=num%10;
            arr[index]=temp;
            min[index--]=temp;
            num/=10;
        }
        int maxFirstDigit=-1;
        for(int no:arr){
            if(no!=9){
                maxFirstDigit=no;
                break;
            }
        }
        int minFirstDigit=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]==maxFirstDigit){
                arr[i]=9;
            }
            if(min[i]==minFirstDigit){
                min[i]=0;
            }
        }
        int maxNumber=0;
        int minNumber=0;
        for(int i=0;i<n;i++){
            maxNumber=(maxNumber*10)+arr[i];
            minNumber=(minNumber*10)+min[i];
        }
        return maxNumber-minNumber;
    }
    public int findLen(int num){
        int res=0;
        while(num>0){
            res++;
            num/=10;
        }
        return res;
    }
}