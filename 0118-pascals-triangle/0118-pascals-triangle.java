class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> baseCase=new ArrayList<>();
        baseCase.add(1);
        result.add(baseCase);
        for(int i=1;i<numRows;i++){
            List<Integer> innerList=new ArrayList<>(i+1);
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    innerList.add(1);
                }
                else{
                    List<Integer> aboveList=result.get(result.size()-1);
                    innerList.add(aboveList.get(j-1)+aboveList.get(j));
                }
            }
            result.add(innerList);
        }
        return result;
    }
}