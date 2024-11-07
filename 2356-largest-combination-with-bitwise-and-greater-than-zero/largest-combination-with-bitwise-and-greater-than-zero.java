class Solution {
    public int largestCombination(int[] candidates) {
        int[] map = new int[25];
        int maxi = Integer.MIN_VALUE;
        for(int i: candidates) {
            int count = 0;
            int num = i;
            while(num > 0){
                map[count] += num & 1;
                count++;
                num = num >> 1;
            }
        }
        for(int i=0;i<25;i++){
            maxi =  Math.max(map[i],maxi);
        }
        return maxi;
    }
}