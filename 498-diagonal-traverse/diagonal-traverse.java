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
                if(curi == 0 && curj < mat[0].length-1) { // hit top
                    inci = 1;
                    incj = -1;
                    curj = curj+1;
                }
                else if(curi == 0 && curj == mat[0].length - 1) { // hit top right corner
                    inci = 1;
                    incj = -1;
                    curi = 1;
                }
                else if(curj == mat[0].length - 1) { // hit right
                    inci = 1;
                    incj = -1;
                    curi = curi + 1;
                }
                else {
                    curi += inci;
                    curj += incj;
                }
            }
            else if(inci == 1 && incj == -1) {
                if(curi == mat.length - 1 && curj > 0) { // hit bottom
                    inci = -1;
                    incj = 1;
                    curj += 1;
                }
                else if(curi == mat.length -1 && curj == 0) { // hit bottom left corner
                    inci = -1;
                    incj = 1;
                    curj += 1;
                }
                else if(curi < mat.length - 1 && curj == 0) { // hit left
                    inci = -1;
                    incj = 1;
                    curi += 1;
                }
                else {
                    curi += inci;
                    curj += incj;
                }
            }
            
        }
        return res;
    }
}