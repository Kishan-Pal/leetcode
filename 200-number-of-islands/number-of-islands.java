class Solution {
    public boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] != '0' && dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') return false;

        visited[row][col] = true;
        boolean result = true;
    

        result = dfs(grid, row, col - 1) || result;
        result = dfs(grid, row, col + 1) || result;
        result = dfs(grid, row - 1, col) || result;
        result = dfs(grid, row + 1, col) || result;
        return result;
    }
}