class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[] prefixRow1=new long[n];
        long[] prefixRow2=new long[n];
        for (int i = 0; i < n; i++) {
            prefixRow1[i] = grid[0][i];
            prefixRow2[i] = grid[1][i];
        }
        for(int i=1;i<n;i++){
            prefixRow1[i]+=prefixRow1[i-1];
            prefixRow2[i]+=prefixRow2[i-1];
        }
        long minResult=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long top=prefixRow1[n-1]-prefixRow1[i];
            long bottom=i!=0?prefixRow2[i-1]:0;
            long secondRobot=Math.max(top,bottom);
            minResult=Math.min(minResult,secondRobot);
        }
        return minResult;
    }
}