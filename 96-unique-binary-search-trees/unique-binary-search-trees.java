class Solution {
    public int numTrees(int n) {
        int[][] memo = new int[n+2][n+2];
        return dfs(1, n, memo);
        
    }
    public int dfs(int start, int end, int[][] memo) {
        if(memo[start][end] > 0) {
            return memo[start][end];
        }
        if(start>end) return 0;
        if(start == end) {
            memo[start][end] = 1;
            return 1;
        }
        int numRoots = 0;
        for(int rootval=start; rootval<=end; rootval++) {
            int leftRoots = dfs(start, rootval-1, memo);
            int rightRoots = dfs(rootval+1, end, memo);
            if(leftRoots == 0 && rightRoots == 0) {
                numRoots += 1;
            }
            else if(leftRoots == 0 || rightRoots == 0) {
                numRoots += Math.max(leftRoots, rightRoots);
            }
            else {
                numRoots += leftRoots*rightRoots;
            }
            
        }
        memo[start][end] = numRoots;
        return memo[start][end];
    }
}