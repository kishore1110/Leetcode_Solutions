class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k>0){
            int n=code.length;
            int[] result=new int[n];
            //first window
            int sum=0;
            for(int i=0;i<k;i++){
                sum+=code[i+1];
            }
            result[0]=sum;
            for(int i=1;i<n;i++){
                result[i]=result[i-1]-code[i]+code[(i+k)%n];
            }
            return result;
        }
        else if(k<0){
            int n=code.length;
            int[] result=new int[n];
            int sum=0;
            //first window
            for(int i=n-2;i>=n+k-1;i--){
                sum+=code[i];
            }
            result[n-1]=sum;
            for(int i=n-2;i>=0;i--){
                result[i]=result[i+1]-code[i]+code[(i+k+n)%n];
            }
            return result;
        }
        int[] result=new int[code.length];
        return result;
    }
}