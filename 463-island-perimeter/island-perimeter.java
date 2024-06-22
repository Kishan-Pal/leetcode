class Solution {
    public int noOfWalls(int[][] grid, int i, int j, int row, int col) {
        int count = 0;
        if(i-1 < 0 || grid[i-1][j] == 0) count += 1;
        if(i+1 >= row || grid[i+1][j] == 0) count += 1;
        if(j-1 < 0 || grid[i][j-1] == 0) count += 1;
        if(j+1 >= col || grid[i][j+1] == 0) count += 1;
        System.out.println(i + " " + j + " count: " + count);

        return count;

    }

    public int visit(int[][] grid, int i, int j, int row, int col, int[][] visited, int count) {
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == 0 || visited[i][j] == 1) return count;
        count = count + noOfWalls(grid, i, j, row, col);
        visited[i][j] = 1;
        count = visit(grid, i, j+1, row, col, visited, count);
        count = visit(grid, i+1, j, row, col, visited, count);
        count = visit(grid, i, j-1, row, col, visited, count);
        count = visit(grid, i-1, j, row, col, visited, count);
        return count;
    }

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0, i=0, j=0, found = 0;
        int[][] visited = new int[row][col];
        for(i=0; i<row; i++) {
            for(j=0; j<col; j++) {
                if(grid[i][j] == 1) {
                    found = 1;
                    break;
                }
            }
            if(found == 1) break;
        }
        count = visit(grid, i, j, row, col, visited, count);
        return count;
    }
}