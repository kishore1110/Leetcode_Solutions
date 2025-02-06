class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sorting
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        int[] result=new int[numCourses];
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
        int index=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            result[index++]=node;
            for(int dependentNode:adj.get(node)){
                indegree[dependentNode]--;
                if(indegree[dependentNode]==0){
                    queue.add(dependentNode);
                }
            }
        }
        return index==numCourses?result:new int[]{};
    }
}