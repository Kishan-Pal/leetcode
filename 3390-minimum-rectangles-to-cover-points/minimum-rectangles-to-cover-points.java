class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        for(int[] i: points) {
            System.out.println(new StringBuilder().append(i[0]).append(" : ").append(i[1]).toString());
            // System.out.println(i[0] + " : " + i[1]);
        }
        int count = 0;
        int num;
        int i=0;
        while(i<points.length) {
            num = points[i][0];
            count++;
            while(i<points.length && points[i][0] - num <= w) i++;
        }
        return count;
    }
}