class Solution {
    public int uniquePaths(int m, int n) {
        int[][] waysReached = new int[m][n];
        waysReached[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int top = 0, left = 0;
                if(i > 0) {
                    top += waysReached[i-1][j];
                }
                if(j > 0) {
                    left += waysReached[i][j-1];
                }
                waysReached[i][j] += top+left;
            }
        }
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         System.out.print(waysReached[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return waysReached[m-1][n-1];
    }
}