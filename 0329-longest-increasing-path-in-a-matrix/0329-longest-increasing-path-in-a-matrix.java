class Solution {
    int[][] memo;
    int[][] directions={{1,0},{0,1},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        memo=new int[m][n];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        int result=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result=Math.max(result,dfs(matrix,i,j,m,n));
            }
        }
        return result;
    }
    public int dfs(int[][] matrix,int x,int y,int m,int n){
        if(memo[x][y]!=-1){
            return memo[x][y];
        }
        int ans=1;
        for(int[] dir:directions){
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(nx<0 || ny<0 || nx>=m || ny>=n || matrix[nx][ny]<=matrix[x][y])continue;
            ans=Math.max(ans,1+dfs(matrix,nx,ny,m,n));
        }
        memo[x][y]=ans;
        return ans;
    }
}