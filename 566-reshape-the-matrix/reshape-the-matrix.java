class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int r1 = mat.length, c1 = mat[0].length;
        if(r == r1 || c == c1) return mat;
        if(r > r1 && c > c1) return mat;
        if(r*c < r1*c1) return mat;
        int[][] res = new int[r][c];
        int[] temp = new int[r1*c1];
        for(int i=0; i<r1; i++) {
            for(int j=0; j<c1; j++) {
                temp[c1*i + j] = mat[i][j];
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                res[i][j] = temp[c*i+j];
            }
        }
        return res;
    }
}