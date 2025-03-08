class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean [] prime=new boolean[right+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<=right;i++){
            if(prime[i]){
                for(int j=i*i;j<=right;j+=i){
                    prime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=left;i<=right;i++){
            if(prime[i]){
                count++;
            }
        }
        if(count<2){
            return new int[]{-1,-1};
        }
        int[] primeNums=new int[count];
        int index=0;
        for(int i=left;i<=right;i++){
            if(prime[i]){
                primeNums[index++]=i;
            }
        }
        int[] result=new int[2];
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<count;i++){
            if(primeNums[i]-primeNums[i-1]<diff){
                diff=primeNums[i]-primeNums[i-1];
                result[0]=primeNums[i-1];
                result[1]=primeNums[i];
            }
        }
        return result;
    }
}