class Solution {
    public int findCircleNum(int[][] isConnected) {
        //printG(isConnected);
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected[0].length; j++) {
                if(isConnected[i][j] == 1) {
                    for(int k=0; k<isConnected.length; k++) {
                        if(k != j && isConnected[k][i] == 1) {
                            isConnected[k][j] = 1;
                        }
                    }
                }
            }
        }
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res++;
                for(int j=0; j<visited.length; j++) {
                    if(isConnected[i][j] == 1) {
                        visited[j] = true;
                    }
                }
            }
        }
        //printG(isConnected);
        return res;
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