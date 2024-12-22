class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<List<int[]>> list=new ArrayList<>();
        int[] result=new int[queries.length];
        Arrays.fill(result,-1);
        for(int i=0;i<heights.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<queries.length;i++){
            Arrays.sort(queries[i]);
            int alice=queries[i][0];
            int bob=queries[i][1];
            if(alice==bob || heights[bob]>heights[alice]){
                result[i]=bob;
            }
            else{
                list.get(bob).add(new int[]{Math.max(heights[alice],heights[bob]),i});
            }
        }
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<heights.length;i++){
            for(int[] groups:list.get(i)){
                minheap.add(groups);
            }
            while(!minheap.isEmpty() && heights[i]>minheap.peek()[0]){
                int[] popped=minheap.poll();
                result[popped[1]]=i;
            }
        }
        return result;
    }
}