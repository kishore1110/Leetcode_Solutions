class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int goodPair=0;
        int mod=1000000007;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-reverse(nums[i]);
            goodPair=(goodPair+map.getOrDefault(diff,0))%mod;
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return goodPair;
    }
    public int reverse(int num){
        int rev=0;
        int temp;
        while(num!=0){
            temp=num%10;
            rev=(rev*10)+temp;
            num/=10;
        }
        return rev;
    }
}