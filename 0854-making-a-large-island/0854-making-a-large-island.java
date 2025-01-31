class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int label=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,n,label++);
                }
            }
        }
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                }
            }
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int area=1;
                    HashSet<Integer> set=new HashSet<>();
                    for(int[] dir:directions){
                        int nr=i+dir[0];
                        int nc=j+dir[1];
                        if(nr<0 || nc<0 || nr>=n || nc>=n || grid[nr][nc]==0 || set.contains(grid[nr][nc]))continue;
                        area+=map.get(grid[nr][nc]);
                        set.add(grid[nr][nc]);
                    }
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea==0?n*n:maxArea;
    }
    public void dfs(int[][] grid,int i,int j,int n,int label){
        if(i<0 || j<0 || i>=n || j>=n || grid[i][j]!=1){
            return;
        }
        grid[i][j]=label;
        dfs(grid,i+1,j,n,label);
        dfs(grid,i,j+1,n,label);
        dfs(grid,i-1,j,n,label);
        dfs(grid,i,j-1,n,label);
    }
}