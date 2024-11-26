class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int[] i:items1){
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
        for(int[] i:items2){
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i: map.keySet()){
            List<Integer> innerList=new ArrayList<>();
            innerList.add(i);
            innerList.add(map.get(i));
            result.add(innerList);
        }
        return result;
    }
}