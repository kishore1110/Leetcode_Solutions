class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int[] zeroPrefix=new int[nums.length+1];
        int[] onePrefix=new int[nums.length+1];
        int totalOne=0;
        int totalZero=0;
        for(int i=0;i<nums.length;i++){
            zeroPrefix[i]=totalZero;
            onePrefix[i]=totalOne;
            if(nums[i]==0){
                totalZero++;
            }
            else{
                totalOne++;
            }
        }
        zeroPrefix[nums.length]=totalZero;
        onePrefix[nums.length]=totalOne;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int maxScore=-1;
        for(int i=0;i<=nums.length;i++){
            int score=zeroPrefix[i]+totalOne-onePrefix[i];
            if(score>=maxScore){
                maxScore=score;
                map.computeIfAbsent(maxScore,k->new ArrayList<Integer>()).add(i);
            }
        }
        return map.get(maxScore);
    }
}