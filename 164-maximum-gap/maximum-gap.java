class Bucket {
    public int min;
    public int max;
    Bucket() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    Bucket(int min, int max) {
        this.min = min; 
        this.max = max;
    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if(max == min) return 0;

        double gap = Math.max(1, (double)(max-min)/(nums.length-1));
        Map<Integer, Bucket> map = new HashMap<>();
        for(int i: nums) {
            int index = (int)((i-min)/gap);
            if(map.containsKey(index)) {
                Bucket cur = map.get(index);
                cur.min = Math.min(cur.min, i);
                cur.max = Math.max(cur.max, i);
            }
            else {
                map.put(index, new Bucket(i, i));
            }
        }
        int maxGap = 0;
        int preMax = min;
        int lastIndex = (int)((max - min)/gap);
        for(int i=0; i<=lastIndex; i++) {
            if(!map.containsKey(i)) continue;
            Bucket cur = map.get(i);
            maxGap = Math.max(maxGap, cur.min - preMax);
            preMax = cur.max;
        }
        return maxGap;
    }
}