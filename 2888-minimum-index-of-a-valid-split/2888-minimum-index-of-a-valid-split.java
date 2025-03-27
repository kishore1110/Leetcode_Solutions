class Solution {
    public int minimumIndex(List<Integer> nums) {
        int N=nums.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int dominant=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>N/2){
                dominant=num;
            }
        }
        int totalCount=map.get(dominant);
        int Currcount=0;
        for(int i=0;i<N;i++){
            if(nums.get(i)==dominant)Currcount++;
            if(Currcount>(i+1)/2 && totalCount-Currcount>(N-i-1)/2){
                return i;
            }
        }
        return -1;
    }
}