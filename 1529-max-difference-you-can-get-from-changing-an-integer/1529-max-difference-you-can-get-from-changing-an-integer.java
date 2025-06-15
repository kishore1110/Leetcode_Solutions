class Solution {
    public int maxDiff(int num) {
        int n=findLen(num);
        int[] max=new int[n];
        int[] min=new int[n];
        int index=n-1;
        while(num>0){
            int temp=num%10;
            max[index]=temp;
            min[index--]=temp;
            num/=10;
        }
        int maxFirstDigit=max[0];
        for(int no:max){
            if(no!=9){
                maxFirstDigit=no;
                break;
            }
        }
        int minFirstDigit=max[0];
        int minValue=1;
        if(minFirstDigit==1){
            for(int i=1;i<max.length;i++){
                if(max[i]!=1 && max[i]!=0){
                    minFirstDigit=max[i];
                    minValue=0;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(max[i]==maxFirstDigit){
                max[i]=9;
            }
            if(min[i]==minFirstDigit){
                min[i]=minValue;
            }
        }
        int maxNumber=0;
        int minNumber=0;
        for(int i=0;i<n;i++){
            maxNumber=(maxNumber*10)+max[i];
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