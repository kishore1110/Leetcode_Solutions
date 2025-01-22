class Solution {
    public int[][] highestPeak(int[][] isWater) {
        LinkedList<int[]> queue=new LinkedList<>();
        int row=isWater.length;
        int col=isWater[0].length;
        int[][] result=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isWater[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions={{1,0},{0,1},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] index=queue.poll();
                for(int[] dir:directions){
                    int newRow=index[0]+dir[0];
                    int newCol=index[1]+dir[1];
                    if(newRow<0 || newRow>=row || newCol>=col || newCol<0 || result[newRow][newCol]!=0 || isWater[newRow][newCol]==1)continue;
                    result[newRow][newCol]=result[index[0]][index[1]]+1;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
        return result;
    }
}