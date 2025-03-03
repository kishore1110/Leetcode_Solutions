class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int totalOne=0;
        for(int bit:nums){
            totalOne+=bit;
        }
        ArrayList<Integer> result=new ArrayList<>();
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
            if(score==maxScore){
                result.add(i);
            }
            if(score>maxScore){
                maxScore=score;
                result.clear();
                result.add(i);
            }
        }
        if(zeroLeft==maxScore){
            result.add(nums.length);
        }
        else if(zeroLeft>maxScore){
            maxScore=zeroLeft;
            result.clear();
            result.add(nums.length);
        }
        return result;
    }
}