class Solution {
    public int videoStitching(int[][] clips, int time) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] clip: clips) {
            map.put(clip[0], Math.max(map.getOrDefault(clip[0], 0), clip[1]));
        }
        int start = 0;
        int end = 0;
        int count = 0;
        while(true) {
            int newEnd = end;
            for(int i=start; i <= end; i++) {
                newEnd = Math.max(newEnd, map.getOrDefault(i, 0));
                if(newEnd >= time) break;
            }
            if(end == newEnd) return -1;
            start = end + 1;
            end = newEnd;
            count++;
            if(end >= time) return count;
            if(start > end) return -1;
        }

        


    }
}