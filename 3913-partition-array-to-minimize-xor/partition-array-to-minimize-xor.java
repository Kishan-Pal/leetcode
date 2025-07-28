import java.util.*;

class Solution {
    int[] prefixXor;
    int[][] dp;
    int n;

    public int minXor(int[] nums, int k) {
        n = nums.length;
        prefixXor = new int[n + 1]; // prefixXor[i] = XOR from 0 to i-1
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ nums[i];
        }

        dp = new int[n + 1][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(0, k);
    }

    private int dfs(int index, int k) {
        if (dp[index][k] != -1) return dp[index][k];

        if (k == 0 && index == n) return 0;
        if (k == 0 || index == n) return Integer.MAX_VALUE;

        int minMax = Integer.MAX_VALUE;

        // Try every possible subarray end point
        for (int j = index + 1; j <= n - k + 1; j++) {
            int currXor = prefixXor[j] ^ prefixXor[index];
            int next = dfs(j, k - 1);
            if (next != Integer.MAX_VALUE) {
                minMax = Math.min(minMax, Math.max(currXor, next));
            }
        }

        dp[index][k] = minMax;
        return minMax;
    }
}
