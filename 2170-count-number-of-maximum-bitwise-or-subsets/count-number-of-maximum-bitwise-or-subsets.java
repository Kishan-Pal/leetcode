class Solution {

    public int countRecursive(int[] nums, int maxOr, int curOr, int i, int[] count) {
        if(i == nums.length) {
            if(curOr == maxOr) {
                return 1;
            }
            return 0;
        }
        //considering the current element
        int count1 = countRecursive(nums, maxOr, curOr|nums[i], i+1, count);
        // ignoring the current elelemt
        int count2 = countRecursive(nums, maxOr, curOr, i+1, count);

        return count1+count2;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int[] count = new int[1];
        count[0] = 0;
        for(int i: nums) {
            maxOr |= i;
        }
        //System.out.println("Max OR = " + maxOr);
        return countRecursive(nums, maxOr, 0, 0, count);
        //System.out.println(count[0]);
        //return count[0];
    }
}