class DetectSquares {
        HashMap<List<Integer>,Integer> map;
        List<int[]> list;
    public DetectSquares() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public void add(int[] point) {
        int[] arr={point[0],point[1]};
        list.add(arr);
        map.put(Arrays.asList(point[0],point[1]),map.getOrDefault(Arrays.asList(point[0],point[1]),0)+1);
    }
    
    public int count(int[] point) {
        int count=0;
        int px=point[0];
        int py=point[1];
        for(int [] pt:list){ // diagonal duplicates counted here
            int x=pt[0];
            int y=pt[1];
            if(Math.abs(px-x)!=Math.abs(py-y) || x==px || y==py){  //condition for valid diagonal
                continue;
            }
            count+=map.getOrDefault(Arrays.asList(x,py),0)*map.getOrDefault(Arrays.asList(px,y),0);
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */