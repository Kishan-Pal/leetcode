class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int k=1;
        res.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(res.get(k-1)[1] >= intervals[i][0]) {
                if(res.get(k-1)[1] > intervals[i][1]) {
                    continue;
                }
                else {
                    res.get(k-1)[1] = intervals[i][1];
                }
            }
            else {
                res.add(intervals[i]);
                k = k + 1;
            }
        }
        int[][] result = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}