class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0,m,n,memo,obstacleGrid);
    }
    public int dfs(int x,int y,int m,int n,int[][] memo,int[][] obstacleGrid){
        if(x>=m || y>=n || obstacleGrid[x][y]==1)return 0;
        if(x==m-1 && y==n-1){
            return 1;
        }
        if(memo[x][y]!=-1){
            return memo[x][y];
        }
        int down=dfs(x+1,y,m,n,memo,obstacleGrid);
        int right=dfs(x,y+1,m,n,memo,obstacleGrid);
        memo[x][y]=down+right;
        return memo[x][y];
    }
}