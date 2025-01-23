class Solution {
    public int countServers(int[][] grid) {
        int serverCount=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && check(grid,i,j,row,col)){
                    serverCount++;   
                }
            }
        }
        return serverCount;
    }
    public boolean check(int[][] grid,int i,int j,int row,int col){
        for(int m=i+1;m<row;m++){
            if(grid[m][j]==1){
                return true;
            }
        }
        for(int n=j+1;n<col;n++){
            if(grid[i][n]==1){
                return true;
            }
        }
        for(int k=i-1;k>-1;k--){
            if(grid[k][j]==1){
                return true;
            }
        }
        for(int l=j-1;l>-1;l--){
            if(grid[i][l]==1){
                return true;
            }
        }
        return false;
    }
}