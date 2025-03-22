class Solution {
    int[] parent;
    int[] size;
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int[] edg:edges){
            unionFind(edg[0],edg[1]);
            adj.computeIfAbsent(edg[0],k->new ArrayList<>()).add(edg[1]);
            adj.computeIfAbsent(edg[1],k->new ArrayList<>()).add(edg[0]);
        }
        for(int i=0;i<n;i++){
            parent[i]=findParent(parent[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        for(int p:parent){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        for(int key:map.keySet()){
            if(!adj.containsKey(key)){
                result++;
            }
            else if(map.get(key)-1==adj.get(key).size()){
                boolean valid=true;
                for(int node:adj.get(key)){
                    if(map.get(key)-1!=adj.get(node).size()){
                        valid=false;
                    }
                }
                if(valid)result++;
            }
        }
        return result;
    }
    public int findParent(int node){
        int currentParent=parent[node];
        while(currentParent!=parent[currentParent]){
            currentParent=parent[currentParent];
        }
        return currentParent;
    }
    public void unionFind(int node1,int node2){
        int root1=findParent(node1);
        int root2=findParent(node2);
        if(size[root1]>=size[root2]){
            parent[root2]=root1;
            size[root1]+=size[root2];
        }
        else{
            parent[root1]=root2;
            size[root2]+=size[root1];
        }
    }
}