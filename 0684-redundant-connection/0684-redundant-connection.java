class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        int[] rank=new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        int[] result=new int[2];
        for(int[] edge:edges){
            if(!union(parent,rank,edge)){
                result=edge;
            }
        }
        return result;
    }
    public int findParent(int node,int[] parent){
        int par=parent[node];
        while(par!=parent[par]){
            par=parent[par];
        }
        return par;
    }
    public boolean union(int[] parent,int[] rank,int[] edge){
        int node1=edge[0];
        int node2=edge[1];
        int parentNode1=findParent(node1,parent);
        int parentNode2=findParent(node2,parent);
        if(parentNode1==parentNode2){
            return false;
        }
        if(rank[parentNode1]>=rank[parentNode2]){
            parent[parentNode2]=parentNode1;
            rank[parentNode1]+=rank[parentNode2];
        }
        else{
            parent[parentNode1]=parentNode2;
            rank[parentNode2]+=rank[parentNode1];
        }
        return true;
    }
}