class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int[]> indexMap=new HashMap<>();
        HashMap<Integer,Integer> rowMap=new HashMap<>();
        HashMap<Integer,Integer> colMap=new HashMap<>();
        int row=mat.length;
        int col=mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                indexMap.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++){
            int[] index=indexMap.get(arr[i]);
            rowMap.put(index[0],rowMap.getOrDefault(index[0],0)+1);
            if(rowMap.get(index[0])>=col)return i;
            colMap.put(index[1],colMap.getOrDefault(index[1],0)+1);
            if(colMap.get(index[1])>=row)return i;
            
        }
        return 0;
    }
}