class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int len=nums.length;
        backtrack(0,result,temp,nums,len);
        return result;
    }
    public void backtrack(int index,List<List<Integer>> result,List<Integer> temp,int[] nums,int len){
        if(index>=len){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        backtrack(index+1,result,temp,nums,len);
        temp.remove(temp.size()-1);
        backtrack(index+1,result,temp,nums,len);
    }

}