class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] result=new int[m-k+1][n-k+1];
        if(k==1)return result;
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                result[i][j]=subMatrix(grid,i,j,k);
            }
        }
        return result;
    }
    public int subMatrix(int[][] grid,int x,int y,int k){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).equals(list.get(i)))continue;
            result=Math.min(result,Math.abs(list.get(i-1)-list.get(i)));
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}