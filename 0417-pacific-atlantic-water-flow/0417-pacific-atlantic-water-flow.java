class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        for(int j=0;j<n;j++){
            dfs(heights,pacific,0,j,m,n);
            dfs(heights,atlantic,m-1,j,m,n);
        }
        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0,m,n);
            dfs(heights,atlantic,i,n-1,m,n);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights,boolean[][] valid,int i,int j,int m,int n){
        valid[i][j]=true;
        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];
            if(newI>=m || newI<0 || newJ>=n || newJ<0 || valid[newI][newJ]==true){
                continue ;
            }
            if(heights[newI][newJ]>=heights[i][j]){
                dfs(heights,valid,newI,newJ,m,n);
            }
        }
    }
}