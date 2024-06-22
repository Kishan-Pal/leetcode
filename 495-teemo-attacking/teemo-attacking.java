class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start=timeSeries[0], res = 0, i, temp;
        for(i=1; i<timeSeries.length; i++) {
            if(timeSeries[i] - timeSeries[i-1] > duration-1) {
                res = res + timeSeries[i-1] - start + duration;
                start = timeSeries[i];
            }
        }
        res = res + timeSeries[i-1] - start + duration;
        return res;
    }
}