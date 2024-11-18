class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k>0){
            int[] result=new int[code.length];
            for(int i=0;i<code.length;i++){
                int sum=0;
                int count=0;
                for(int j=(i+1)%code.length;;j=(j+1)%code.length){
                    if(count==k){
                        break;
                    }
                    sum+=code[j];
                    count++;
                }
                result[i]=sum;
            }
           return result;
        }
        else if(k<0){
            int[] result=new int[code.length];
            for(int i=0;i<code.length;i++){
                int sum=0;
                int count=0;
                int start=i==0?code.length-1:i-1;
                for(int j=start;;j--){
                    if(count==Math.abs(k)){
                        break;
                    }
                    sum+=code[j];
                    count++;
                    if(j==0){
                        j=code.length;
                    }
                }
                result[i]=sum;
            }
            return result;
        }
        else{
            Arrays.fill(code,0);
            return code;
        }
    }
}