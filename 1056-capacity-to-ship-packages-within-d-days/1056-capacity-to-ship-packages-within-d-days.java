class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int weight:weights){
            sum+=weight;
        }
        int low=1;
        int high=sum;
        int result=0;
        while(low<=high){
            int limit=low+(high-low)/2;
            int daysTakes=0;
            int currentSum=0;
            for(int weight:weights){
                if(limit<weight){
                    daysTakes=Integer.MAX_VALUE-1;
                    break;
                }
                currentSum+=weight;
                if(currentSum>limit){
                    daysTakes++;
                    currentSum=weight;
                }
            }
            daysTakes++;
            System.out.println(limit+" "+daysTakes);
            if(daysTakes<=days){
                result=limit;
                high=limit-1;
            }
            else{
                low=limit+1;
            }
        }
        return result;
    }
}