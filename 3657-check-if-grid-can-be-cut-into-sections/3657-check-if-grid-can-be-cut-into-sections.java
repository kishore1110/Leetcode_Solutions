class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int N=rectangles.length;
        int[][] x=new int[N][2];
        int[][] y=new int[N][2];
        int index=0;
        for(int[] rectangle:rectangles){
            int xStart=rectangle[0];
            int yStart=rectangle[1];
            int xEnd=rectangle[2];
            int yEnd=rectangle[3];
            x[index]=new int[]{xStart,xEnd};
            y[index++]=new int[]{yStart,yEnd};
        }
        Arrays.sort(x,(a,b)->a[0]-b[0]);
        int count=0;
        int start=x[0][0];
        int end=x[0][1];
        for(int i=1;i<N;i++){
            if(x[i][0]<end){
                end=Math.max(end,x[i][1]);
            }
            else{
                count++;
                start=x[i][0];
                end=x[i][1];
            }
        }
        count++;
        if(count>2){
            return true;
        }
        Arrays.sort(y,(a,b)->a[0]-b[0]);
        count=0;
        start=y[0][0];
        end=y[0][1];
        for(int i=1;i<N;i++){
            if(y[i][0]<end){
                end=Math.max(end,y[i][1]);
            }
            else{
                count++;
                start=y[i][0];
                end=y[i][1];
            }
        }
        count++;
        return count>2;
    }
}