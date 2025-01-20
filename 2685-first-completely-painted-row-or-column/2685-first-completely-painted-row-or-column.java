class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int[][] freq=new int[row*col+1][2];
        int[] rowFreq=new int[row];
        int[] colFreq=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                freq[mat[i][j]]=new int[]{i,j};
            }
        }
        for(int i=0;i<arr.length;i++){
            int[] index=freq[arr[i]];
            rowFreq[index[0]]+=1;
            if(rowFreq[index[0]]>=col)return i;
            colFreq[index[1]]+=1;
            if(colFreq[index[1]]>=row)return i;
        }
        return 0;
    }
}