class Solution {
    public static long getHours(int[] piles, int k) {
        long hours = 0;
        for(int i=0; i<piles.length; i++) {
            hours += piles[i] / k;
            if(piles[i] % k > 0) {
                hours++;
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int min = Integer.MAX_VALUE;

        int minVal = 1;
        int maxVal = piles[piles.length-1];

        while(minVal < maxVal) {
            int mid = (minVal + maxVal)/2;
            long hrs = getHours(piles, mid);
            //System.out.println("k = " + mid + " hrs = " + hrs);
            if(hrs <= h) {
                min = Math.min(min, mid);
                maxVal = mid-1;
            }
            else if(hrs > h) {
                minVal = mid+1;
            }
        }
        long hrs = getHours(piles, minVal);
        //System.out.println("k = " + minVal + " hrs = " + hrs);
        if(hrs <= h) {
            min = Math.min(min, minVal);
        }
        
        
        return min;
    }
}