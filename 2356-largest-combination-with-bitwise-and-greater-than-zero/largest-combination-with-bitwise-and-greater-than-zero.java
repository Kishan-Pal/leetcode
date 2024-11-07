class Solution {
    public int largestCombination(int[] candidates) {
        int[] map = new int[25];
        int maxi = Integer.MIN_VALUE;
        for(int i: candidates) {
            int count = 0;
            int num = i;
            while(num > 0){
                map[count] += num & 1;
                maxi =  Math.max(map[count],maxi);
                count++;
                num = num >> 1;
            }
        }
        return maxi;
    }
}