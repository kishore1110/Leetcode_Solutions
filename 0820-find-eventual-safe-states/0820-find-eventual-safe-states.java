class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(dfs(i,graph,map)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean dfs(int node,int[][] graph,HashMap<Integer,Boolean> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        map.put(node,false);
        for(int adj:graph[node]){
            if(!dfs(adj,graph,map)){
                return false;
            }
        }
        map.put(node,true);
        return true;
    }
} 