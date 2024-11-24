class Solution {
    public int orangesRotting(int[][] grid) {
        int minute=0;
        int row=grid.length;
        int col=grid[0].length;
         Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)fresh++;
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(fresh>0 && !queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] arr=new int[2];
                arr=queue.poll();
                int x=arr[0];
                int y=arr[1];
                for(int[] direction:directions){
                    int newX=x+direction[0];
                    int newY=y+direction[1];
                    if(newX<row && newX>=0 && newY<col && newY>=0 && grid[newX][newY]==1){
                        queue.add(new int[]{newX,newY});
                        fresh--;
                        grid[newX][newY]=2;
                    }
                }
            }
            minute++;
        }
        return fresh==0?minute:-1;
    }
}
