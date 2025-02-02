class Solution {
    public void gameOfLife(int[][] board) {
        int row=board.length;
        int col=board[0].length;
        int[][] clone=new int[row][col];
        for(int i=0;i<row;i++){
            clone[i]=Arrays.copyOf(board[i],col);
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int count=0;
                for(int[] dir:directions){
                    int nr=i+dir[0];
                    int nc=j+dir[1];
                    if(nr<0 || nc<0 || nr>=row || nc>=col)continue;
                    if(clone[nr][nc]==1)count++;
                }
                if(clone[i][j]==1 && (count<2) || count>3){
                    board[i][j]=0;
                }
                else if(clone[i][j]==0 && count==3){
                    board[i][j]=1;
                }
            }
        }
    }
}