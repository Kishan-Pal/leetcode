class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] exists = new boolean[100001];
        for(int i: nums) {
            if(exists[i]) {
                res.add(i);
            }
            else {
                exists[i] = true;
            }
        }
        return res;
    }
}