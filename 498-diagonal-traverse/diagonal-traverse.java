class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int inci = -1;
        int incj = 1;
        int count = 0;
        int curi = 0;
        int curj = 0;
        int[] res = new int[mat.length * mat[0].length];

        while(count < mat.length * mat[0].length) {
            res[count++] = mat[curi][curj];
            if(inci == -1 && incj == 1) {
                if(curj == mat[0].length - 1) { // hit top right corner or right
                    inci = 1;
                    incj = -1;
                    curi += 1;
                    continue;
                }
                else if(curi == 0) { // hit top
                    inci = 1;
                    incj = -1;
                    curj += 1;
                    continue;
                }
            }
            else{
                if(curi == mat.length - 1 ) { // hit bottom or bottom left corner
                    inci = -1;
                    incj = 1;
                    curj += 1;
                    continue;
                }
                else if(curj == 0) { // hit left
                    inci = -1;
                    incj = 1;
                    curi += 1;
                    continue;
                }
            }
            curi += inci;
            curj += incj;
            
        }
        return res;
    }
}