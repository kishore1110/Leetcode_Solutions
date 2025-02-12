class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxSum=-1;
        for(int value:nums){
            int SOD=sumOfDigits(value);
            if(map.containsKey(SOD)){
                maxSum=Math.max(maxSum,value+map.get(SOD));
                if(map.get(SOD)<value){
                    map.put(SOD,value);
                }
            }
            else{
                map.put(SOD,value);
            }
        }
        return maxSum;
    }
    public int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}