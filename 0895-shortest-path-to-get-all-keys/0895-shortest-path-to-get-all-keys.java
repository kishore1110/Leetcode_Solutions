class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        // bitmask bfs
        int sX=0;
        int sY=0;
        int m=grid.length;
        int n=grid[0].length();
        int totalKeys=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='@'){
                    sX=i;
                    sY=j;
                }
                else if(Character.isLowerCase(grid[i].charAt(j))){
                    totalKeys++;
                }
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        int[][][] visited=new int[m][n][1<<totalKeys];
        queue.offer(new int[]{sX,sY,0,0});
        visited[sX][sY][0]=1;
        while(!queue.isEmpty()){
            int[] polled=queue.poll();
            int x=polled[0];
            int y=polled[1];
            int keyMask=polled[2];
            int steps=polled[3];
            if(check(keyMask,totalKeys)){
                return steps;
            }
            for(int[] dir:directions){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx].charAt(ny)=='#')continue;
                if(Character.isUpperCase(grid[nx].charAt(ny))){
                    int pos=grid[nx].charAt(ny)-'A';
                    if((keyMask&(1<<pos))==0){
                        continue;
                    }
                }
                int newKey=keyMask;
                if(Character.isLowerCase(grid[nx].charAt(ny))){
                    int pos=grid[nx].charAt(ny)-'a';
                    newKey=keyMask|1<<pos;
                }
                if(visited[nx][ny][newKey]==1)continue;
                visited[nx][ny][newKey]=1;
                queue.offer(new int[]{nx,ny,newKey,steps+1});
            }
        }
        return -1;
    }
    public boolean check(int keyMask,int total){
        int count=0;
        while(keyMask>0){
            count+=(keyMask&1);
            keyMask=keyMask>>1;
        }
        return count==total;
    }
}