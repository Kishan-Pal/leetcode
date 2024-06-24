class Solution {
    public void smooth3by3(int[][] img, int[][] res, int i, int j) {
        int count = 0;
        int sum = 0;
        if(i>0){
            sum = sum + img[i-1][j];
            count = count + 1;
            if(j>0) {
                sum = sum + img[i-1][j-1];
                count = count + 1;
            }
            if(j<img[0].length-1){
                sum = sum + img[i-1][j+1];
                count = count + 1;
            }
        }
        
        
        if(i<img.length-1){
            sum = sum + img[i+1][j];
            count = count + 1;
            if(j>0) {
                sum = sum + img[i+1][j-1];
                count = count + 1;
            }
            if(j<img[0].length-1){
                sum = sum + img[i+1][j+1];
                count = count + 1;
            }
        }
        
        if(j>0){
            sum = sum + img[i][j-1];
            count = count + 1;
        }
        if(j<img[0].length-1){
            sum = sum + img[i][j+1];
            count = count + 1;
        }
        sum = sum + img[i][j];
        count = count + 1;
        res[i][j] = sum/count;
    }
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for(int i=0; i<img.length; i++) {
            for(int j=0; j<img[0].length; j++) {
                this.smooth3by3(img, res, i, j);
            }
        }
        return res;
    }
}