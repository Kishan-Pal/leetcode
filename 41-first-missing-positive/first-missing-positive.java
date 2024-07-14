class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i: nums) {
            if(i > 0)
            hash.put(i, 1);
        }
        for(int i=1; i<Integer.MAX_VALUE; i++) {
            if(!hash.containsKey(i)) return i;
        }
        return 0;
    }
}