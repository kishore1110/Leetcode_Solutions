class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates=new int[10];
        for(int i=0;i<9;i++){
            candidates[i]=i+1;
        }
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(result,temp,candidates,n,0,0,k);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> temp,int[] candidates, int target,int currentSum,int index,int k){
        if(currentSum>target){
            return;
        }
        if(currentSum==target){
            if(temp.size()==k)result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(result,temp,candidates,target,currentSum+candidates[i],i+1,k);
            temp.remove(temp.size()-1);
        }
    }
}