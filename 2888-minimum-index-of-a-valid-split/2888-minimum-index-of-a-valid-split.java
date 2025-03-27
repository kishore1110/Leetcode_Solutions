class Solution {
    public int minimumIndex(List<Integer> nums) {
        // int N=nums.size();
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int dominant=0;
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        //     if(dominant==0 && map.get(num)>N/2){
        //         dominant=num;
        //     }
        // }
        // int totalCount=map.get(dominant);
        // int Currcount=0;
        // for(int i=0;i<N;i++){
        //     if(nums.get(i)==dominant)Currcount++;
        //     if(Currcount>(i+1)/2 && totalCount-Currcount>(N-i-1)/2){
        //         return i;
        //     }
        // }
        // return -1;

        // Without HashMap(what about boyer major algorithm)
        int candidate=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            count=num==candidate?count+1:count-1;
        }
        int totalCount=0;
        for(int num:nums){
            if(num==candidate)totalCount++;
        }
        int Currcount=0;
        int N=nums.size();
        for(int i=0;i<N;i++){
            if(nums.get(i)==candidate)Currcount++;
            if(Currcount>(i+1)/2 && totalCount-Currcount>(N-i-1)/2){
                return i;
            }
        }
        return -1;

    }
}