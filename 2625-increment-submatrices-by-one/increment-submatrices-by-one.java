class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for(int[] query: queries) {
            modify(res, query[0], query[1], query[2], query[3]);
        }
        return res;
    }

    public void modify(int[][] res, int x1, int y1, int x2, int y2) {
        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                res[i][j]++;
            }
        }
    }
}