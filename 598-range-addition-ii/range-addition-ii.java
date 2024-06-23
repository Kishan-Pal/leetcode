class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x=m-1, y=n-1;
        for(int[] i: ops) {
            x = (x < i[0]-1? x : i[0]-1);
            y = (y < i[1]-1? y : i[1]-1);
        }
        return (x+1)*(y+1);
    }
}