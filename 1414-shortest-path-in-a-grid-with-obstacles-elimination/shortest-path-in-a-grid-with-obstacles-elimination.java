import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        // If we have enough k to cover all obstacles in a straight path
        if (k >= n + m - 2) return n + m - 2;

        // visited[x][y][k_left] = true means we've visited (x, y) with k_left obstacles we can still remove
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        // Each element: [i, j, steps, remaining_k]
        queue.offer(new int[]{0, 0, 0, k});
        visited[0][0][k] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], steps = cur[2], rem = cur[3];

            if (x == n - 1 && y == m - 1) return steps;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int nk = rem - grid[nx][ny]; // reduce k if hitting obstacle
                    if (nk >= 0 && !visited[nx][ny][nk]) {
                        visited[nx][ny][nk] = true;
                        queue.offer(new int[]{nx, ny, steps + 1, nk});
                    }
                }
            }
        }
        
        return -1;
    }
}
