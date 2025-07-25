class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        int negativeMax = Integer.MIN_VALUE;
        for(int i: nums) {
            if(i >= 0) {
                if(!set.contains(i)) {
                    res = Math.max(res, 0);
                    set.add(i);
                    res += i;
                }
            }
            else {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}