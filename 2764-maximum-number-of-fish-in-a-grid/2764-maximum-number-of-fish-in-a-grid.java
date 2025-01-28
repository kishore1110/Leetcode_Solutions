class Solution {
    public int findMaxFish(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int maxFish=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0){
                    maxFish=Math.max(maxFish,findMaxArea(i,j,row,col,grid));
                }
            }
        }
        return maxFish;
    }
    public int findMaxArea(int x, int y, int row, int col,int[][] grid){
        int count=0;
        if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0){
            return 0;
        }
        count+=grid[x][y];
        grid[x][y]=0;
        count+=findMaxArea(x+1,y,row,col,grid);
        count+=findMaxArea(x-1,y,row,col,grid);
        count+=findMaxArea(x,y+1,row,col,grid);
        count+=findMaxArea(x,y-1,row,col,grid);
        return count;
    }
}