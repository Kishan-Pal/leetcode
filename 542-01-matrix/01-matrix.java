class Solution {
    int[][] dir = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int[] direction: dir) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if(nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length && !visited[nx][ny]) {
                    res[nx][ny] = res[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return res;
    }




}