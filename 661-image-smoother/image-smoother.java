class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int count = 0;
        int sum = 0;
        boolean ig;
        boolean il;
        boolean jg;
        boolean jl;
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                count = 0;
                sum = 0;
                ig = i>0;
                il = i<m-1;
                jg = j>0;
                jl = j<n-1;
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