class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // pacific
        int m=heights.length;
        int n=heights[0].length;
        int fixedI=0;
        HashSet<ArrayList<Integer>> pacificSet=new HashSet<>();
        for(int j=0;j<n;j++){
            dfs(heights,pacificSet,fixedI,j,m,n);
        }
        int fixedJ=0;
        for(int i=0;i<m;i++){
            dfs(heights,pacificSet,i,fixedJ,m,n);
        }
        //atlantic
        HashSet<ArrayList<Integer>> atlanticSet=new HashSet<>();
        fixedI=m-1;
        for(int j=0;j<n;j++){
            dfs(heights,atlanticSet,fixedI,j,m,n);
        }
        fixedJ=n-1;
        for(int i=0;i<m;i++){
            dfs(heights,atlanticSet,i,fixedJ,m,n);
        }
        pacificSet.retainAll(atlanticSet);
        List<List<Integer>> result=new ArrayList<>();
        for(ArrayList<Integer> pair:pacificSet){
            result.add(pair);
        }
        return result;
    }
    public void dfs(int[][] heights,HashSet<ArrayList<Integer>> set,int i,int j,int m,int n){
        set.add(new ArrayList<>(Arrays.asList(i,j)));
        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];
            if(newI>=m || newI<0 || newJ>=n || newJ<0 || set.contains(Arrays.asList(newI,newJ))){
                continue ;
            }
            if(heights[newI][newJ]>=heights[i][j]){
                dfs(heights,set,newI,newJ,m,n);
            }
        }
    }
}