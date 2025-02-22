class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(0,temp,result,nums,nums.length);
        return result;
    }
    public void backtrack(int index,List<Integer> temp,List<List<Integer>> result,int[] nums,int length){
        if(index>=length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        backtrack(index+1,temp,result,nums,length);
        temp.remove(temp.size()-1);
        while(index<length-1 && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(index+1,temp,result,nums,length);
    }
}