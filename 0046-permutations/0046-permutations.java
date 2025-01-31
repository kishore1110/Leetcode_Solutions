class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(result,temp,nums);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> temp,int[] nums){
        if(temp.size()==nums.length){
            List<Integer> perm=new ArrayList<>(temp);
            result.add(perm);
            return;
        }
        for(int i:nums){
            if(!temp.contains(i)){
                temp.add(i);
                backtrack(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}