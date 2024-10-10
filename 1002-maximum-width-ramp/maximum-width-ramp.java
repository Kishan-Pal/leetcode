class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Ele> decreasing = new Stack<>();
        int res = 0;
        decreasing.push(new Ele(nums[0], 0));

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < decreasing.peek().ele) {
                decreasing.push(new Ele(nums[i], i));
            }
            else {
                int j = decreasing.size()-1;
                while(j >= 0 && decreasing.get(j).ele <= nums[i]) {
                    res = Math.max(res, i - decreasing.get(j).index);
                    j--;
                }
            }
        }
        return res;
    }
}

class Ele {
    public int ele;
    public int index;
    Ele(int ele, int index) {
        this.ele = ele;
        this.index = index;
    }
}