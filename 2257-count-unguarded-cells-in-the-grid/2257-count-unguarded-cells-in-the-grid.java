class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix=new int[m][n];
        for(int i=0;i<walls.length;i++){
            matrix[walls[i][0]][walls[i][1]]=2;
        }
        for(int i=0;i<guards.length;i++){
            matrix[guards[i][0]][guards[i][1]]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    dp(matrix,m,n,i,j);
                }
            }
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    result++;
                }
            }
        }
        return result;
    }
    public void dp(int[][] matrix,int m,int n,int i,int j){
        for (int x = i + 1; x < m && matrix[x][j] != 2 && matrix[x][j] != 1; x++) {
            if (matrix[x][j] == 0) matrix[x][j] = 3;
        }

        for (int x = i - 1; x >= 0 && matrix[x][j] != 2 && matrix[x][j] != 1; x--) {
            if (matrix[x][j] == 0) matrix[x][j] = 3;
        }
        for (int y = j + 1; y < n && matrix[i][y] != 2 && matrix[i][y] != 1; y++) {
            if (matrix[i][y] == 0) matrix[i][y] = 3;
        }
        for (int y = j - 1; y >= 0 && matrix[i][y] != 2 && matrix[i][y] != 1; y--) {
            if (matrix[i][y] == 0) matrix[i][y] = 3; 
        }
}
}