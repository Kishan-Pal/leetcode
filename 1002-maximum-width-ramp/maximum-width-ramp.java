class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Ele> decreasing = new Stack<>();
        Stack<Ele> increasing = new Stack<>();
        int res = 0;
        Ele a, b;

        for(int i=0; i<nums.length; i++) {
            if(decreasing.isEmpty() || nums[i] < decreasing.peek().ele) {
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