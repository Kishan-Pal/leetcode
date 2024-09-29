class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0, r=matrix.length-1, mid;
        while(l<=r) {
            mid = (l+r)/2;
            if(target < matrix[mid][0]) {
                r = mid - 1;
            }
            else if( target > matrix[mid][0]) {
                l = mid + 1;
            }
            else {
                return true;
            }
        }
        if(r == -1) return false;
        int pos = r;
        l = 0;
        r = matrix[0].length-1;
        while(l<=r) {
            mid = (l+r) / 2;
            if(target == matrix[pos][mid]) {
                return true;
            }
            else if(target < matrix[pos][mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}