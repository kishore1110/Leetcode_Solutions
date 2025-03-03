class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int totalOne=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                totalOne++;
            }
            
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int maxScore=-1;
        int zeroLeft=0;
        int oneLeft=0;
        for(int i=0;i<nums.length;i++){
            int score=zeroLeft+totalOne-oneLeft;
            if(nums[i]==0){
                zeroLeft++;
            }
            else{
                oneLeft++;
            }
            if(score>=maxScore){
                maxScore=score;
                map.computeIfAbsent(maxScore,k->new ArrayList<Integer>()).add(i);
            }
        }
        if(zeroLeft>=maxScore){
            maxScore=zeroLeft;
            map.computeIfAbsent(maxScore,k->new ArrayList<Integer>()).add(nums.length);
        }
        return map.get(maxScore);
    }
}