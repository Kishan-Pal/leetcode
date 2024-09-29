class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] visited = new int[n][n];
        int c=1;
        int i=0, j=-1;
        while(c <= n*n) {
            while(j+1<n && visited[i][j+1] == 0) {
                j++;
                result[i][j] = c;
                c++;
                visited[i][j] = 1;
            }
            while(i+1<n && visited[i+1][j] == 0) {
                i++;
                result[i][j] = c;
                c++;
                visited[i][j] = 1;
            }
            while(j-1>=0 && visited[i][j-1] == 0) {
                j--;
                result[i][j] = c;
                c++;
                visited[i][j] = 1;
            }
            while(i-1>=0 && visited[i-1][j] == 0) {
                i--;
                result[i][j] = c;
                c++;
                visited[i][j] = 1;
            }
        }
        return result;
    }
}