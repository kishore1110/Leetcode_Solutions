class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int value:nums){
            map.put(value,map.getOrDefault(value,0)+1);
        }
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(result,temp,map,nums.length);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> temp,HashMap<Integer,Integer> map,int length){
        if(temp.size()==length){
            List<Integer> perm=new ArrayList<>(temp);
            result.add(perm);
            return;
        }
        for(int key:map.keySet()){
            if(map.get(key)>0){
                temp.add(key);
                map.put(key,map.getOrDefault(key,0)-1);
                backtrack(result,temp,map,length);
                temp.remove(temp.size()-1);
                map.put(key,map.getOrDefault(key,0)+1);   
            }
        }
    }
}