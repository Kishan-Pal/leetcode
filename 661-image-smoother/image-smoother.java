class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = 0;
                int sum = 0;
                boolean ig = i>0;
                boolean il = i<m-1;
                boolean jg = j>0;
                boolean jl = j<n-1;
                if(ig){
                    sum = sum + img[i-1][j];
                    count = count + 1;
                    if(jg) {
                        sum = sum + img[i-1][j-1];
                        count = count + 1;
                    }
                    if(jl){
                        sum = sum + img[i-1][j+1];
                        count = count + 1;
                    }
                }
                
                
                if(il){
                    sum = sum + img[i+1][j];
                    count = count + 1;
                    if(jg) {
                        sum = sum + img[i+1][j-1];
                        count = count + 1;
                    }
                    if(jl){
                        sum = sum + img[i+1][j+1];
                        count = count + 1;
                    }
                }
                
                if(jg){
                    sum = sum + img[i][j-1];
                    count = count + 1;
                }
                if(jl){
                    sum = sum + img[i][j+1];
                    count = count + 1;
                }
                sum = sum + img[i][j];
                count = count + 1;
                res[i][j] = sum/count;
            }
        }
        return res;
    }
}