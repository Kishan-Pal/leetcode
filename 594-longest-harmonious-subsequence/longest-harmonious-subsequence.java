class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i: nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for(int i: hash.keySet()) {
            if(hash.containsKey(i+1)) {
                int val = hash.get(i+1) + hash.get(i);
                max = ((max > val)? max: val);
            }
        }
        return max;
    }
}