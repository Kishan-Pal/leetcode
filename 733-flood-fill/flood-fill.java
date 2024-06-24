class Solution {
    public void dfs(int[][] image, int i, int j, int color, int n, int m, int ele) {
        if(i < 0 || i > n-1 || j < 0 || j > m-1 || image[i][j] != ele) return;
        image[i][j] = color;
        dfs(image, i-1, j, color, n, m, ele);
        dfs(image, i, j-1, color, n, m, ele);
        dfs(image, i+1, j, color, n, m, ele);
        dfs(image, i, j+1, color, n, m, ele);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length, ele = image[sr][sc];
        if(color == ele) return image;
        dfs(image, sr, sc, color, n, m, ele);
        return image;
        
    }
}