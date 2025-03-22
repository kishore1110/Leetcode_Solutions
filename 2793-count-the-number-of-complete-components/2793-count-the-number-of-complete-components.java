class Solution {
    int[] parent;
    int[] size;
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int[] edg:edges){
            adj.computeIfAbsent(edg[0],k->new ArrayList<>()).add(edg[1]);
            adj.computeIfAbsent(edg[1],k->new ArrayList<>()).add(edg[0]);
        }
        boolean[] visited=new boolean[n];
        int result=0;
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            ArrayList<Integer> component=dfs(i,adj,visited,new ArrayList<>());
            boolean valid=true;
            if(component.size()>1){
                for(int node:component){
                    if(adj.get(node).size()!=component.size()-1){
                        valid=false;
                        break;
                    }
                }
            }
            if(valid)result++;
        }
        return result;
    }
    public ArrayList<Integer> dfs(int node,HashMap<Integer,ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> component){
        if(visited[node]){
            return null;
        }
        visited[node]=true;
        component.add(node);
        if(adj.containsKey(node)){
            for(int n:adj.get(node)){
                if(!visited[n]){
                    dfs(n,adj,visited,component);
                }
            }
        }
        return component;
    }
}