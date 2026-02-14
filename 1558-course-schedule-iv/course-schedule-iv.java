class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] matrix = new boolean[numCourses][numCourses]; 
        for(int[] ele:prerequisites) {
            matrix[ele[0]][ele[1]] = true;
        }
        floyd(matrix);
        List<Boolean> ans = new ArrayList<>();
        for(int[] q:queries){
            ans.add(matrix[q[0]][q[1]]);
        }

        return ans;
    }

    void floyd(boolean[][] matrix) {
        int n = matrix.length;
        for(int via=0;via<n;via++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = (matrix[i][via] && matrix[via][j]) || matrix[i][j];
                }
            }
        }
    }
}