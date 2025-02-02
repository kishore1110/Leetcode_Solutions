class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Union Find algorithm
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges){
            union(edge,parent,rank);
        }
        return findParent(source,parent)==findParent(destination,parent);
    }
    public void union(int[] edge,int[] parent,int[] rank){
        int n1=edge[0];
        int n2=edge[1];
        int node1=findParent(n1,parent);
        int node2=findParent(n2,parent);
        if(rank[node1]>=rank[node2]){
            parent[node2]=node1;
            rank[node1]+=rank[node2];
        }
        else{
            parent[node1]=node2;
            rank[node2]+=rank[node1];
        }
    }
    public int findParent(int node,int[]parent){
        int par=parent[node];
        while(par!=parent[par]){
            par=parent[par];
        }
        return par;
    }
}