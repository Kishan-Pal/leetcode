class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        LinkedList<int[]> res = new LinkedList<>();
        int i=0;    // traverse status in intervals
        int j=0;    // len of res
        while(i < intervals.length && intervals[i][0] <= newInterval[0]) {
            res.add(intervals[i]);
            i++;
            j++;
        }
        i--;
        if(i == -1) {
            res.add(newInterval);
            j++;
            i++;
        }
        if(newInterval[0] > res.get(i)[1]) {
            res.add(newInterval);
            j++;
        }
        while(i < intervals.length && newInterval[1] > intervals[i][1]) {
            i++;
        }
        if(i >= intervals.length || newInterval[1] < intervals[i][0]) {
            int[] temp = res.get(j-1);
            temp[1] = newInterval[1];
            while(i < intervals.length) {
                res.add(intervals[i]);
                i++;
                j++;
            }
        }
        else {
            if(newInterval[1] < intervals[i][1]) {
                int[] temp = res.get(j-1);
                temp[1] = intervals[i][1];
                i++;
                while(i < intervals.length) {
                    res.add(intervals[i]);
                    i++;
                    j++;
                }
            }
            else {
                int[] temp = res.get(j-1);
                temp[1] = intervals[i][1];
                i++;
                while(i < intervals.length) {
                    res.add(intervals[i]);
                    i++;
                    j++;
                }
            }
            
        }
        // if(newInterval[0] >= res.get(i-1)[0] && newInterval[0] <= res.get(i-1)[1]) {
        //     while(intervals[i][1] <= newInterval[1])
        // }
        // if(res.get(i-1)[1] >= newInterval[0] && res.get(i-1)[1] >= newInterval[1]) {
        //     while(i < intervals.length) {
        //         res.add(intervals[i]);
        //         i++;
        //     }
        // }
        // else {

        // }
        // for(int[] k: res) {
        //     for(int h: k) {
        //         System.out.print(h + " " );

        //     }
        //     System.out.println();
        // }
        int[][] final1 = new int[j][];
        int k=0;
        for(int[] l: res) {
            final1[k] = l;
            k++;
        }
        return final1;
    }
}