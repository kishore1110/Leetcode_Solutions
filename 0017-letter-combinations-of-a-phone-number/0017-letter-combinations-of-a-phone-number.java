class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){ 
            List<String> result=new ArrayList<>();
            return result;
        }
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> result=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        backtrack(result,temp,map,digits,0);
        return result;
    }
    public void backtrack(List<String> result,StringBuilder temp,HashMap<Integer,String> map,String digits,int index){
        if(index>=digits.length()){
            result.add(temp.toString());
            return;
        }
        for(char ch:map.get(digits.charAt(index)-'0').toCharArray()){
            temp.append(ch);
            backtrack(result,temp,map,digits,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}