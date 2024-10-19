class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i=0; i<matrix.length; i++) {
            dp[i][matrix[0].length-1] = (int)(matrix[i][matrix[0].length-1] - '0');
        }
        for(int i=matrix.length-1; i>=0; i--) {
            for(int j=matrix[0].length-2; j>=0; j--) {
                //System.out.println((int)(matrix[i][j] - '0'));
                if((int)(matrix[i][j] - '0') != 0) {
                    dp[i][j] = (int)(matrix[i][j] - '0') + dp[i][j+1];
                }
            }
        }

        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                int temp = dp[i][j], count=2;

                if(temp == 0) continue;
                res = Math.max(temp, res);
                for(int k=i+1; k<matrix.length && temp != 0; k++) {
                    temp = Math.min(temp, dp[k][j]);
                    res = Math.max(res, temp * count);
                    count++;
                }
            }
        }
        // for(int[] i: dp) {
        //     for(int j: i) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }
        return res;

    }
}