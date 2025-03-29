class Solution {
    int MOD=1000000007;
    public int maximumScore(List<Integer> nums, int k) {
        int N=nums.size();
        // calculate prime score of each number
        int[] primeScores=new int[N];
        for(int i=0;i<N;i++){
            int distinct=0;
            int num=nums.get(i);
            for(int j=2;j<=(int)Math.sqrt(nums.get(i));j++){
                if(num%j==0){
                    distinct++;
                    while(num%j==0){
                        num/=j;
                    }
                }
            }
            if(num>1)distinct++;    //divide by the same number
            primeScores[i]=distinct;
        }
        // buildint the subarray range for each number
        int[] left=new int[N];
        int[] right=new int[N];
        Arrays.fill(left,-1);
        Arrays.fill(right,N);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && primeScores[i]>primeScores[stack.peek()]){
                int index=stack.pop();
                right[index]=i;
            }
            if(!stack.isEmpty())left[i]=stack.peek();
            stack.push(i);
        }
        
        // my brute force the above are optimizations
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<N;i++){
            pq.offer(new int[]{nums.get(i),i});
        }
        int result=1;
        while(!pq.isEmpty() && k>0){
            int[] element=pq.poll();
            int score=element[0];
            int index=element[1];
            int leftRange=index-left[index];
            int rightRange=right[index]-index;
            long possibleSubArraysCount=1L*leftRange*rightRange;
            long count=Math.min(possibleSubArraysCount,(long)k);
            result=(int)((1L*result*pow(score,(int)count))%MOD);
            k-=count;
        }
        return result;
    }
    public int pow(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (int)((1L * res * x) % MOD);
            }
            x = (int)((1L * x * x) % MOD);
            n /= 2;
        }
        return res;
    }
}