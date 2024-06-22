class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        boolean[] isAvailable = new boolean[n+1];
        for(int i=0; i<n; i++) {
            isAvailable[nums[i]] = true;
        }
        for(int i=1; i<=n; i++) {
            if(!isAvailable[i]) {
                res.add(i);
            }
        }
        return res;
    }
}