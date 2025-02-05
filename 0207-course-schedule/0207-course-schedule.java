class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological sorting
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            indegree[preq[0]]++;
            adj.get(preq[1]).add(preq[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int completed=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            completed++;
            for(int dependentNode:adj.get(node)){
                indegree[dependentNode]--;
                if(indegree[dependentNode]==0){
                    queue.add(dependentNode);
                }
            }
        }
        return completed==numCourses;
    }
}