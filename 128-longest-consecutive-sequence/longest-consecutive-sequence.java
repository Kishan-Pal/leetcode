class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> parent = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            parent.put(nums[i], parent.getOrDefault(nums[i]+1, nums[i]));
            if(parent.containsKey(nums[i]-1)) {
                parent.put(nums[i]-1, parent.get(nums[i]));
            }

        }
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            res = Math.max(res, getParent(parent, nums[i]) - nums[i] + 1);
        }
        return res;
    }
    public static int getParent(Map<Integer, Integer> parent, int num) {
        if(parent.get(num) != num) {
            int parent1 = getParent(parent, parent.get(num));
            parent.put(num, parent1);
            return parent1;

        }
        return num;
    }
}