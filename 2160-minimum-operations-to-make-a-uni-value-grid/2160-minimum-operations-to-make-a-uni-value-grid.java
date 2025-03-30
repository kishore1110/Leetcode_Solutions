class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[m*n];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[index++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int middle=arr[index/2];
        int operations=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int diff=Math.abs(grid[i][j]-middle);
                if(diff%x!=0)return -1;
                else operations+=diff/x;
            }
        }
        return operations;
    }
}