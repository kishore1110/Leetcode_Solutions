class Solution {
    public int assignEdgeWeights(int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int[] edg:edges){
            map.computeIfAbsent(edg[0],k->new ArrayList<>()).add(edg[1]);
            map.computeIfAbsent(edg[1],k->new ArrayList<>()).add(edg[0]);
        }
        int edgeCount=findHeight(map,1,-1)-1;
        int MOD=1000000000+7;
        long result=modPow(2,edgeCount-1,MOD);  // this is combinatorics
        return (int)(result%MOD);
    }
    public int findHeight(HashMap<Integer,ArrayList<Integer>> map,int root,int parent){
        if(!map.containsKey(root)){
            return 0;
        }
        int maxVal=0;
        for(int child:map.get(root)){
            if(child==parent)continue;
            maxVal=Math.max(maxVal,findHeight(map,child,root));
        }
        return maxVal+1;
    }
    public int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * b) % mod;
            b = (b * b) % mod;
            exp=exp >>1;
        }
        return (int) result;
    }
    // A good Solution

    // int n = edges.size() + 1;

    //     // Create adjacency list
    //     List<List<Integer>> g = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         g.add(new ArrayList<>());
    //     }

    //     for (List<Integer> e : edges) {
    //         int u = e.get(0) - 1;
    //         int v = e.get(1) - 1;
    //         g.get(u).add(v);
    //         g.get(v).add(u);
    //     }

    //     // BFS for depth
    //     int[] depth = new int[n];
    //     Arrays.fill(depth, -1);
    //     Queue<Integer> q = new LinkedList<>();
    //     depth[0] = 0;
    //     q.add(0);

    //     // Precompute powers of 2 modulo MOD
    //     for (int i = 0; i < n; i++) {
    //         pow2.add(0L);
    //     }
    //     pow2.set(0, 1L);
    //     for (int i = 1; i < n; i++) {
    //         long val = (pow2.get(i - 1) << 1) % MOD;
    //         pow2.set(i, val);
    //     }

    //     int maxDepth = 0;
    //     while (!q.isEmpty()) {
    //         int u = q.poll();
    //         maxDepth = Math.max(maxDepth, depth[u]);
    //         for (int v : g.get(u)) {
    //             if (depth[v] == -1) {
    //                 depth[v] = depth[u] + 1;
    //                 q.add(v);
    //             }
    //         }
    //     }

    //     return pow2.get(maxDepth - 1);
    
}