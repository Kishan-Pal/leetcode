class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            hash.put(nums[i], 1);
        }
        for(int i=1; i<=n; i++) {
            if(!hash.containsKey(i)) {
                res.add(i);
            }
        }
        return res;
    }
}