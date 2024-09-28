class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        int noVisited = 2;
        visited[0][0] = 1;
        result.add(matrix[0][0]);
        int i=0, j=0;
        int maxVisit = matrix.length * matrix[0].length;
        while(noVisited <= maxVisit) {
            while(j+1 < matrix[0].length && visited[i][j+1] == 0) {
                visited[i][j+1] = 1;
                j = j + 1;
                result.add(matrix[i][j]);
                noVisited = noVisited + 1;
            }
            while(i+1 < matrix.length && visited[i+1][j] == 0) {
                visited[i+1][j] = 1;
                i = i + 1;
                result.add(matrix[i][j]);
                noVisited = noVisited + 1;
            }
            while(j-1 >= 0 && visited[i][j-1] == 0) {
                visited[i][j-1] = 1;
                j = j - 1;
                result.add(matrix[i][j]);
                noVisited = noVisited + 1;
            }
            while(i-1 >= 0 && visited[i-1][j] == 0) {
                visited[i-1][j] = 1;
                i = i - 1;
                result.add(matrix[i][j]);
                noVisited = noVisited + 1;
            }
        }
        return result;
    }
}