class Solution {
    int[] parent;
    int[] size;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        //Union Find
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        size=new int[n];
        Arrays.fill(size,1);
        for(int[] edge:edges){
            unionFind(edge[0],edge[1]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] edge:edges){
            int root=findParent(edge[0]);
            if(map.containsKey(root)){
                map.put(root,map.get(root)&edge[2]);
            }
            else{
                map.put(root,edge[2]);
            }
        }
        int[] result=new int[query.length];
        int index=0;
        for(int[] q:query){
            int root1=findParent(q[0]);
            int root2=findParent(q[1]);
            if(root1!=root2){
                result[index++]=-1;
            }
            else{
                result[index++]=map.get(root1);
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
        int parent1=findParent(node1);
        int parent2=findParent(node2);
        int size1=size[parent1];
        int size2=size[parent2];
        if(size1>=size2){
            parent[parent2]=parent1;
            size[parent1]+=size[parent2];
        }
        else{
            parent[parent1]=parent2;
            size[parent2]+=size[parent1];
        }
    }
}