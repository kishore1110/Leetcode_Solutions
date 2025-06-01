class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public int minMoves(String[] classroom, int energy) {
        // new type of bfs
        int m=classroom.length;
        int n=classroom[0].length();
        int sX=0;
        int sY=0;
        List<int[]> litterList=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(classroom[i].charAt(j)=='S'){
                    sX=i;
                    sY=j;
                }
                else if(classroom[i].charAt(j)=='L'){
                    litterList.add(new int[]{i,j});
                }
            }
        }
        HashMap<String,Integer> map=new HashMap<>();
        int totalLitter=litterList.size();
        for(int i=0;i<totalLitter;i++){
            int[] pos=litterList.get(i);
            map.put(pos[0]+","+pos[1],i);
        }
        int[][][][] visited=new int[m][n][energy+1][1<<totalLitter];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{sX,sY,energy,0,0});// x,y,currentEnergy,collectedLitterMask,steps
        visited[sX][sY][energy][0]=1;
        while(!queue.isEmpty()){
            int[] popped=queue.poll();
            int x=popped[0];
            int y=popped[1];
            int currEnergy=popped[2];
            int mask=popped[3];
            int steps=popped[4];
            if(mask==(1<<totalLitter)-1){
                return steps;
            }
            for(int[] dir:directions){
                int nX=dir[0]+x;
                int nY=dir[1]+y;
                if(nX<0 || nY<0 || nX>=m || nY>=n || classroom[nX].charAt(nY)=='X')continue;
                int newEnergy = currEnergy - 1;
                if (newEnergy < 0) continue;
                if (classroom[nX].charAt(nY) == 'R') {
                    newEnergy = energy;
                }
                int newMask=mask;
                if(classroom[nX].charAt(nY)=='L'){
                    int pos=map.get(nX+","+nY);
                    newMask=newMask|(1<<pos);
                }
                if(visited[nX][nY][newEnergy][newMask]==1){
                    continue;
                }
                visited[nX][nY][newEnergy][newMask]=1;
                queue.offer(new int[]{nX,nY,newEnergy,newMask,steps+1});
            }
        }
        return -1;
    }
}