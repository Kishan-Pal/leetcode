class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, isConnected, visited);
            }
        }
        return res;
    }

    public void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for(int j=0; j<visited.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public void printG(int[][] connections) {
        for(int i=0; i<connections.length; i++) {
            for(int j=0; j<connections[0].length; j++) {
                System.out.print(connections[i][j] + " ");

            }
            System.out.println();
        }
    }
}