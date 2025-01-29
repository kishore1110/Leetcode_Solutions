class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        // row wise
        for(int i=0;i<row;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<col;j++){
                list.add(grid[i][j]);
            }
            map.put(list,map.getOrDefault(list,0)+1);
        }
        // column wise
        for(int i=0;i<col;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<row;j++){
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)){
                count+=map.get(list);
            }
        }
        return count;
    }
}