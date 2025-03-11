class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,m,n);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,m,n);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j,m,n);
            }
            if(board[m-1][j]=='O'){
                dfs(board,m-1,j,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='B'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int m,int n){
        if(board[i][j]!='O'){
            return;
        }
        board[i][j]='B';
        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];
            if(newI>=m || newI<0 || newJ>=n || newJ<0){
                continue;
            }
            dfs(board,newI,newJ,m,n);
        }
    }
}