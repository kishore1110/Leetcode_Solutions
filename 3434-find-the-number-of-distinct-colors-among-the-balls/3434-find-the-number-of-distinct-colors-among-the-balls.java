class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int distinct=0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        int[] result=new int[queries.length];
        int index=0;
        for(int[] query:queries){
            int ball=query[0];
            int change=query[1];
            if(freq.containsKey(ball)){
                int prevColor=freq.get(ball);
                map.put(prevColor,map.get(prevColor)-1);
                if(map.get(prevColor)==0){
                    map.remove(prevColor);
                    distinct--;
                }
            }
            freq.put(ball,change);
            if(!map.containsKey(change)){
                distinct++;
                map.put(change,1);
            }
            else{
                map.put(change,map.get(change)+1);
            }
            result[index++]=distinct;
        }
        return result;
    }
}