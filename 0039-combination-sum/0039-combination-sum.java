class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(result,temp,candidates,target,0,0);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> temp,int[] candidates, int target,int currentSum,int index){
        if(currentSum>target){
            return;
        }
        if(currentSum==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(result,temp,candidates,target,currentSum+candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}