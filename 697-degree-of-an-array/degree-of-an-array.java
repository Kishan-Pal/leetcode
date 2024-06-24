class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length, max = 0, res=50000, l, r, temp;
        int[] count = new int[50000];
        List<Integer> maxcount = new ArrayList<>();
        for(int i: nums) {
            count[i] += 1;
            if(count[i] > max) {
                maxcount.clear();
                maxcount.add(i);
                max = count[i];
            }
            else if(count[i] == max) {
                maxcount.add(i);
            }
        }
        if(max == 1) return 1;

        for(int i: maxcount) {
            l=0;
            r=n-1;
            while(nums[l] != i) l += 1;
            while(nums[r] != i) r -= 1;
            temp = r - l + 1;
            res = (res < temp? res: temp);
        }
        return res;
    }
}