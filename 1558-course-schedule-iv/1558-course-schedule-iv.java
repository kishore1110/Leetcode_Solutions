class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // wharshell algorithm
        boolean[][] mat=new boolean[numCourses][numCourses];
        int freeze=0;
        for(int[] vertices:prerequisites){
            mat[vertices[0]][vertices[1]]=true;
        }
        while(freeze<numCourses){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(i==freeze || j==freeze || mat[i][j]==true){
                        continue;
                    }
                    if(mat[i][freeze]==true && mat[freeze][j]==true){
                        mat[i][j]=true;
                    }
                }
            }
            freeze++;
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] vertices:queries){
            result.add(mat[vertices[0]][vertices[1]]);
        }
        return result;
    }
}