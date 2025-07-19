
class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int max = 0;
            int same = 1;
            Double slope = 0.0;
            for(int j=i+1; j<points.length; j++) {
                Double dx = (double) points[j][0] - points[i][0];
                Double dy = (double) points[j][1] - points[i][1];
                if(dx == 0 && dy==0) {
                    same++;

                }
                else if(dx == 0) {
                    slope = Double.POSITIVE_INFINITY;

                }
                else if(dy == 0) {
                    slope = 0.0;
                }
                else {
                    slope = dy/dx;
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            ans = Math.max(ans, max + same);
        }
        return ans;
    }
}