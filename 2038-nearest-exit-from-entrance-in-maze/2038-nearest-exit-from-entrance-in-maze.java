class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(entrance);
        int row=maze.length;
        int col=maze[0].length;
        int step=0;
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited=new boolean[row][col];
        visited[entrance[0]][entrance[1]]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] pos=queue.poll();
                if(pos[0]==0 || pos[1]==0 || pos[0]==row-1 || pos[1]==col-1){
                    if(step>0){
                        return step;
                    }
                }
                for(int[] dir:directions){
                    int nr=dir[0]+pos[0];
                    int nc=dir[1]+pos[1];
                    if(nr<0 || nc<0 || nr>=row || nc>=col || maze[nr][nc]=='+' || visited[nr][nc]==true)continue;
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
            step++;
        }
        return -1;
    }
}