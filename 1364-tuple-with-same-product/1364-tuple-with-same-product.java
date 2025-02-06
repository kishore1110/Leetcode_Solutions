class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
                }
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    count+=map.get(nums[i]*nums[j])-2;
                }
            }
        }
        return count;
    }
}