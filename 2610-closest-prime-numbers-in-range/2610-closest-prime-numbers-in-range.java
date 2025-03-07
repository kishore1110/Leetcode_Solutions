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
        int[][] sortedList=new int[count-1][3];
        index=0;
        for(int i=1;i<count;i++){
            sortedList[index++]=new int[]{primeNums[i]-primeNums[i-1],primeNums[i-1],primeNums[i]};
        }
        Arrays.sort(sortedList,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        result[0]=sortedList[0][1];
        result[1]=sortedList[0][2];
        return result;
    }
}