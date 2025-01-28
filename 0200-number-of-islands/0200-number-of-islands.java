class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,row,col,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int x, int y, int row, int col,char[][] grid){
        if(x<0 || y<0 || x>=row || y>=col || grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        dfs(x+1,y,row,col,grid);
        dfs(x-1,y,row,col,grid);
        dfs(x,y+1,row,col,grid);
        dfs(x,y-1,row,col,grid);
    }
}