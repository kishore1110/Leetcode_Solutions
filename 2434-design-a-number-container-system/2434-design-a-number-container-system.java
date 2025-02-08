class NumberContainers {
    HashMap<Integer,Integer> indMap;
    HashMap<Integer,PriorityQueue<Integer>> pqMap;
    public NumberContainers() {
        indMap=new HashMap<>();
        pqMap=new HashMap<>();
    }
    
    public void change(int index, int number) {
        indMap.put(index,number);
        pqMap.computeIfAbsent(number,k->new PriorityQueue<>((a,b)->a-b)).offer(index);
    }
    
    public int find(int number) {
        if(!pqMap.containsKey(number)){
            return -1;
        }
        if(pqMap.get(number).size()==0){
            return -1;
        }
        while(indMap.get(pqMap.get(number).peek())!=number){
            pqMap.get(number).poll();
            if(pqMap.get(number).size()==0){
                return -1;
            }
        }
        return pqMap.get(number).peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */