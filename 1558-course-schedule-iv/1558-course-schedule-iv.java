class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // wharshell algorithm
        int[][] mat=new int[numCourses][numCourses];
        int freeze=0;
        for(int[] vertices:prerequisites){
            mat[vertices[0]][vertices[1]]=1;
        }
        while(freeze<numCourses){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(i==freeze || j==freeze || mat[i][j]==1){
                        continue;
                    }
                    if(mat[i][freeze]==1 && mat[freeze][j]==1){
                        mat[i][j]=1;
                    }
                }
            }
            freeze++;
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] vertices:queries){
            int i=vertices[0];
            int j=vertices[1];
            if(mat[i][j]==1){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}