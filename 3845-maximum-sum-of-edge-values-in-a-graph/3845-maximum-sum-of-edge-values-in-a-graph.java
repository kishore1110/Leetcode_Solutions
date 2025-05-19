class Solution {
    public long maxScore(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int[] edg:edges){
            adj.computeIfAbsent(edg[0],k->new ArrayList<>()).add(edg[1]);
            adj.computeIfAbsent(edg[1],k->new ArrayList<>()).add(edg[0]);
        }
        ArrayList<Integer> cycles=new ArrayList<>();
        ArrayList<Integer> chains=new ArrayList<>();
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                int[] cnt=new int[1];
                if(dfs(i,-1,visited,adj,cnt)){
                    cycles.add(cnt[0]);
                }
                else{
                    chains.add(cnt[0]);
                }
            }
        }
        Collections.sort(cycles,Collections.reverseOrder());
        Collections.sort(chains,Collections.reverseOrder());
        long ans=0;
        for(int edgeCount:cycles){
            ans+=1L*n*(n-1+n-2);
            n-=3;
            edgeCount-=2; // two edge calculated in cycle no of edge==no of nodes
            while(edgeCount>1){
                ans+=1L*n*(n+2);
                n--;
                edgeCount--;
            }
            //last edge
            ans+=1L*(n+1)*(n+2);
            edgeCount--;
        }
        // now for chains same as cycles
        for(int componentSize:chains){
            if(componentSize==1)continue;
            if(componentSize==2){
                ans+=1L*n*(n-1);
                n--;
                continue;
            }
            ans+=1L*n*(n-1+n-2);
            n-=3;
            componentSize-=2; // two edge calculated in cycle no of edge==no of nodes
            while(componentSize>1){
                ans+=1L*n*(n+2);
                n--;
                componentSize--;
            }
        }
        return ans;
    }
    public boolean dfs(int node,int parent,int[] visited,HashMap<Integer,ArrayList<Integer>> adj,int[] cnt){
        visited[node]=1;
        cnt[0]++;
        boolean ans=false;
        if(adj.containsKey(node)){
            for(int n:adj.get(node)){
                if(visited[n]==0){
                    ans=ans|dfs(n,node,visited,adj,cnt);
                }
                else if(n!=parent){
                    ans=true;
                }
            }
        }
        return ans;
    }
}