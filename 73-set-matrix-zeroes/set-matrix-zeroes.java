class Solution {

    public void clear(int[][] matrix, int i, int j, int n, int m) {
        for(int i1=0; i1<n; i1++) {
            matrix[i1][j] = 0;
        }
        for(int j1=0; j1<m; j1++) {
            matrix[i][j1] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(temp[i][j] == 0) {
                    clear(matrix, i, j, n, m);
                }
            }
        }
    }
}