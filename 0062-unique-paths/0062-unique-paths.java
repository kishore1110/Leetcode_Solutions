class Solution {
    public int uniquePaths(int m, int n) {  
        int[][] memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0,m,n,memo);
    }
    public int dfs(int x,int y,int m,int n,int[][] memo){
        if(x>=m || y>=n)return 0;
        if(x==m-1 && y==n-1){
            return 1;
        }
        if(memo[x][y]!=-1){
            return memo[x][y];
        }
        int down=dfs(x+1,y,m,n,memo);
        int right=dfs(x,y+1,m,n,memo);
        memo[x][y]=down+right;
        return memo[x][y];
    }
}