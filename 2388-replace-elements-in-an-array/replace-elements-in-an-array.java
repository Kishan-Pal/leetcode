class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        Map<Integer, Integer> indexOf = new HashMap<>();

        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            indexOf.put(nums[i], i);
        }

        for(int[] operation: operations) {
            indexOf.put(operation[1], indexOf.get(operation[0]));
            indexOf.put(operation[0], -1);
        }
        for(Map.Entry<Integer, Integer> entry: indexOf.entrySet()) {
            if(entry.getValue() != -1) {
                res[entry.getValue()] = entry.getKey();
            }
        }
        return res;
    }
}