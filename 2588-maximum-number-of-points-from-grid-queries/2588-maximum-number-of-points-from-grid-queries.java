class Solution {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int[] result=new int[queries.length];
        int[][] sortedQueries=new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }
        Arrays.sort(sortedQueries,(a,b)->a[0]-b[0]);
        int point=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=1;
        for(int[] query:sortedQueries){
            while(!pq.isEmpty() && pq.peek()[0]<query[0]){
                int[] poped=pq.poll();
                int row=poped[1];
                int col=poped[2];
                point++;
                for(int[] dir:directions){
                    int nr=row+dir[0];
                    int nc=col+dir[1];
                    if(nr<n && nc<m && nr>-1 && nc>-1 && visited[nr][nc]==0){
                        pq.offer(new int[]{grid[nr][nc],nr,nc});
                        visited[nr][nc]=1;
                    }
                }
            }
            result[query[1]]=point;
        }
        return result;
    }
    
}